<template>
  <div>
    <a-tabs type="card" @change="callback">
      <a-tab-pane key="1" tab="信息填写">
        <a-descriptions title="资产申请" style="padding: 0px 10px" bordered>
          <a-descriptions-item label="申请部门" :span="2">
            <a-select placeholder="请选择部门" style="width: 100%; min-width: 100px">
              <a-select-option v-for="d in data" :key="d.value">
                {{ d.text }}
              </a-select-option>
            </a-select>
          </a-descriptions-item>
          <a-descriptions-item label="申请人" :span="2">
            <a-input placeholder="请输入姓名" />
          </a-descriptions-item>
          <a-descriptions-item label="请假类别" :span="24">
            <a-radio-group>
              <a-radio value="1" style="margin: 10px 25px">事假</a-radio>
              <a-radio value="2" style="margin: 10px 25px">调休</a-radio>
              <a-radio value="3" style="margin: 10px 25px">病假</a-radio>
              <a-radio value="4" style="margin: 10px 38px">丧假</a-radio>
              <br />
              <a-radio value="5" style="margin: 10px 25px">婚假</a-radio>
              <a-radio value="6" style="margin: 10px 25px">产假</a-radio>
              <a-radio value="7" style="margin: 10px 25px">探亲假</a-radio>
              <a-radio value="8" style="margin: 10px 25px">其他</a-radio>
            </a-radio-group>
          </a-descriptions-item>
          <a-descriptions-item label="申请原因" :span="24">
            <a-textarea
              type="text"
              :rows="4"
              placeholder="请输入申请原因"
            />
          </a-descriptions-item>
          <a-descriptions-item label="申请时间">
            <a-range-picker
              :disabled-date="disabledDate"
              @change="onChange"
            />
            <span style="padding-left: 50px">
            共&nbsp;&nbsp;&nbsp;&nbsp;{{countDay}}&nbsp;&nbsp;&nbsp;&nbsp;天
          </span>
          </a-descriptions-item>
        </a-descriptions>
        <a-row style="margin-top: 20px">
          <a-col :span="24" :style="{ textAlign: 'center' }">
            <a-button type="primary" >完成</a-button>
            <a-button type="primary" :style="{ marginLeft: '100px' }">取消</a-button>
          </a-col>
        </a-row>
      </a-tab-pane>

      <a-tab-pane key="2" tab="流程日志" style="padding: 20px 30px">
        <a-steps direction="vertical" :current="1">
          <a-step title="Finished" description="This is a description." />
          <a-step title="In Progress" description="This is a description." />
          <a-step title="Waiting" description="This is a description." />
        </a-steps>
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
import moment from 'moment'

export default {
  name: 'index',
  data () {
    return {
      data: [
        {
          value: '1',
          text: 'Alex'
        }
      ],
      countDay: '2',
      applyInfo: {

      }
    }
  },
  methods: {
    callback (key) {
      console.log(key)
    },
    onChange (date, dateString) {
      console.log(date, dateString)
    },
    disabledDate (current) {
      return current && current < moment().endOf('day')
    }
  }
}
</script>

<style scoped>

</style>
