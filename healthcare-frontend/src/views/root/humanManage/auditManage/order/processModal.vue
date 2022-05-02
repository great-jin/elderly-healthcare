<template>
  <a-modal
    title="流程详情"
    :visible="visible"
    width="70%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="back" @click="cancel">取消</a-button>
      <a-popconfirm
        title="确认拒绝该申请"
        ok-text="是"
        cancel-text="否"
        @confirm="ok('cancel')"
        style="background-color: red"
      >
        <a-button key="submit" type="primary">拒绝</a-button>
      </a-popconfirm>
      <a-popconfirm
        title="确认同意该申请"
        ok-text="是"
        cancel-text="否"
        @confirm="ok('ok')"
      >
        <a-button key="submit" type="primary">同意</a-button>
      </a-popconfirm>
    </template>
    <div>
      <div class="process-content">
        <a-descriptions>
          <a-descriptions-item label="员工编号">
            {{ vacateInfo.staffId }}
          </a-descriptions-item>
          <a-descriptions-item label="员工姓名">
            {{ vacateInfo.staffName }}
          </a-descriptions-item>
          <a-descriptions-item label="部门名">
            {{ vacateInfo.organizeName }}
          </a-descriptions-item>
          <a-descriptions-item label="请假类别">
            {{ vacateInfo.vacateType }}
          </a-descriptions-item>
          <a-descriptions-item label="开始时间">
            {{ vacateInfo.startTime }}
          </a-descriptions-item>
          <a-descriptions-item label="请假天数">
            {{ vacateInfo.countTime }} 天
          </a-descriptions-item>
          <a-descriptions-item label="请假原因" :span="3">
            {{ vacateInfo.vacateReason }}
          </a-descriptions-item>
          <a-descriptions-item label="备注" :span="3">
            {{ vacateInfo.comment }}
          </a-descriptions-item>
        </a-descriptions>
      </div>
      <div class="process-step">
        <a-steps :current="current" v-if="true">
          <a-step title="申请提交" description="填写相关申请提交" />
          <a-step title="等待审批" description="等待上级领导审批" />
          <a-step title="审核结果" :description="result" />
        </a-steps>
      </div>
    </div>
  </a-modal>
</template>

<script>
import moment from 'moment'
import { updateVacateInfo } from '@/api/vacateInfo'

export default {
  name: 'ProcessModal',
  data () {
    return {
      type: '',
      vacateId: '',
      visible: false,
      current: 1,
      result: '等待审核',
      vacateInfo: {}
    }
  },
  methods: {
    paramReceive (type, data) {
      this.type = type
      this.visible = true
      this.vacateId = data.id
      this.transData(data)
    },
    transData (data) {
      const _data = data
      this.vacateInfo = _data
      this.vacateInfo.startTime = moment(_data.startTime).format('YYYY-MM-DD')
    },
    ok (type) {
      let _vacate = {}
      switch (type) {
        case 'ok':
          _vacate = {
            id: this.vacateId,
            isApprove: 1
          }
          break
        case 'cancel':
          _vacate = {
            id: this.vacateId,
            isApprove: 2
          }
          break
      }
      updateVacateInfo(_vacate).then(res => {
        if (res.data) {
          this.$message.success('操作成功')
        } else {
          this.$message.error('操作失败，请稍后重试')
        }
      })
      this.visible = false
    },
    cancel () {
      this.visible = false
    }
  }
}
</script>

<style scoped>
  .process-content{
    padding: 5px 10px;
    margin-bottom: 35px;
  }
  .process-content ant-descriptions-item-colon{
    font-size: 15px;
  }
  .process-step{
    padding: 5px 50px;
  }
</style>
