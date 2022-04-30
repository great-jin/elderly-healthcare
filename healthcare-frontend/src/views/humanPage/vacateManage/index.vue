<template>
  <div>
    <a-tabs type="card">
      <a-tab-pane key="1" tab="我的流程" style="padding: 0px 10px">
        <vacateList ref="vacateList" />
      </a-tab-pane>
      <a-tab-pane key="2" tab="信息填写" style="padding: 5px 10px">
        <a-descriptions bordered>
          <a-descriptions-item label="申请部门">
            <a-select
              v-model="applyInfo.organizeName"
              placeholder="请选择部门"
              style="width: 100%; min-width: 100px"
            >
              <a-select-option
                v-for="org in organize"
                :key="org.organizeId"
                :value="org.organizeName"
              >
                {{ org.organizeName }}
              </a-select-option>
            </a-select>
          </a-descriptions-item>
          <a-descriptions-item label="员工编号">
            <a-input
              v-model="applyInfo.staffId"
              placeholder="请输入姓名"
            />
          </a-descriptions-item>
          <a-descriptions-item label="申请人">
            <a-input
              v-model="applyInfo.staffName"
              placeholder="请输入姓名"
            />
          </a-descriptions-item>
          <a-descriptions-item label="请假类别" :span="24">
            <a-radio-group
              v-model="applyInfo.vacateType"
            >
              <a-radio value="事假" style="margin: 10px 25px">事假</a-radio>
              <a-radio value="调休" style="margin: 10px 25px">调休</a-radio>
              <a-radio value="病假" style="margin: 10px 25px">病假</a-radio>
              <a-radio value="丧假" style="margin: 10px 38px">丧假</a-radio>
              <br />
              <a-radio value="婚假" style="margin: 10px 25px">婚假</a-radio>
              <a-radio value="产假" style="margin: 10px 25px">产假</a-radio>
              <a-radio value="探亲假" style="margin: 10px 25px">探亲假</a-radio>
              <a-radio value="其他" style="margin: 10px 25px">其他</a-radio>
            </a-radio-group>
          </a-descriptions-item>
          <a-descriptions-item label="申请原因" :span="24">
            <a-textarea
              v-model="applyInfo.vacateReason"
              type="text"
              :rows="6"
              placeholder="请输入申请原因"
            />
          </a-descriptions-item>
          <a-descriptions-item label="申请时间">
            <a-range-picker
              :disabled-date="disabledDate"
              @change="onChange"
            />
            <span style="padding-left: 50px">
            共&nbsp;&nbsp;&nbsp;&nbsp;{{dayCount}}&nbsp;&nbsp;&nbsp;&nbsp;天
          </span>
          </a-descriptions-item>
        </a-descriptions>
        <a-row style="margin-top: 20px">
          <a-col :span="24" :style="{ textAlign: 'center' }">
            <a-button type="primary" @click="ok">完成</a-button>
            <a-button type="primary" :style="{ marginLeft: '100px' }">取消</a-button>
          </a-col>
        </a-row>
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
import moment from 'moment'
import vacateList from './vacateList'
import { listOrg } from '@/api/organizeInfo'
import { addVacateInfo } from '@/api/vacateInfo'

export default {
  name: 'index',
  components: {
    vacateList
  },
  data () {
    return {
      dayCount: '',
      organize: [],
      applyInfo: {}
    }
  },
  created () {
    this.getData()
  },
  methods: {
    getData () {
      listOrg().then(res => {
        this.organize = res.data
      })
    },
    ok () {
      addVacateInfo(this.applyInfo).then(res => {
        if (res.data) {
          this.$message.success('提交成功')
          this.applyInfo = {}
        } else {
          this.$message.error('提交失败，请重试')
        }
      })
    },
    onChange (date) {
      this.applyInfo.startTime = date[0]._d
      this.applyInfo.endTime = date[1]._d
      this.dayCount = (date[1]._d - date[0]._d) / 86400000
      this.applyInfo.countTime = this.dayCount
    },
    disabledDate (current) {
      return current && current < moment().endOf('day')
    }
  }
}
</script>

<style scoped>
</style>
