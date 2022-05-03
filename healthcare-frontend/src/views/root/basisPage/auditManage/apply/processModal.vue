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
          <a-descriptions-item label="申请部门">
            {{ applyInfo.organizeName }}
          </a-descriptions-item>
          <a-descriptions-item label="申请人">
            {{ applyInfo.staffId }}
          </a-descriptions-item>
          <a-descriptions-item label="申请时间">
            {{ applyInfo.applyTime }}
          </a-descriptions-item>
          <a-descriptions-item label="申请原因" :span="12">
            {{ applyInfo.applyReason }}
          </a-descriptions-item>
        </a-descriptions>
        <a-table
          :columns="columns"
          :data-source="data"
        />
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
import { columns } from './const'
import { listApplyGoods } from '@/api/assetApplyGoods'
import { updateApplyInfo } from '@/api/assetApplyInfo'

export default {
  name: 'ProcessModal',
  data () {
    return {
      data: [],
      columns,
      applyId: '',
      visible: false,
      current: 1,
      result: '等待审核',
      applyInfo: {}
    }
  },
  methods: {
    paramReceive (data) {
      this.visible = true
      this.applyInfo = data
      this.applyId = data.applyId
      this.getData(data)
    },
    getData (data) {
      // 转换时间格式
      this.applyInfo.applyTime = moment(data.applyTime).format('YYYY-MM-DD')
      // 查询相关申请设备信息
      const _apply = {
        applyId: this.applyId
      }
      listApplyGoods(_apply).then(res => {
        this.data = res.data
      })
    },
    ok (type) {
      let _apply = {}
      switch (type) {
        case 'ok':
          _apply = {
            id: this.vacateId,
            currentState: 1
          }
          break
        case 'cancel':
          _apply = {
            id: this.applyId,
            currentState: 2
          }
          break
      }
      updateApplyInfo(_apply).then(res => {
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
