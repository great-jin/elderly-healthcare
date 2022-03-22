<template>
  <div>
    <a-tabs type="card" @change="callback">
      <a-tab-pane key="1" tab="信息填写">
        <a-descriptions title="资产申请" style="padding: 0px 10px" bordered>
          <a-descriptions-item label="申请单位">
            <a-select placeholder="请选择单位" style="width: 100%; min-width: 100px">
              <a-select-option v-for="d in data" :key="d.value">
                {{ d.text }}
              </a-select-option>
            </a-select>
          </a-descriptions-item>
          <a-descriptions-item label="申请部门">
            <a-select placeholder="请选择部门" style="width: 100%; min-width: 100px">
              <a-select-option v-for="d in data" :key="d.value">
                {{ d.text }}
              </a-select-option>
            </a-select>
          </a-descriptions-item>
          <a-descriptions-item label="申请人">
            <a-input placeholder="请输入姓名" />
          </a-descriptions-item>
          <a-descriptions-item label="申请时间">
            <a-date-picker
              :disabled-date="disabledDate"
              @change="onChange"
            />
          </a-descriptions-item>
          <a-descriptions-item label="是否专业设备">
            <a-radio-group>
              <a-radio value="1">是</a-radio>
              <a-radio value="0">否</a-radio>
            </a-radio-group>
          </a-descriptions-item>
          <a-descriptions-item>
          </a-descriptions-item>
          <a-descriptions-item label="申请原因" :span="24">
            <a-textarea
              type="text"
              :rows="4"
              placeholder="请输入申请原因"
            />
          </a-descriptions-item>

          <a-descriptions-item label="设备信息" :span="24">
            <a-row>
              <a-col :span="5" style="padding: 0px 10px">
                <a-select placeholder="请选择单位" style="width: 100%">
                  <a-select-option v-for="d in data" :key="d.value">
                    {{ d.text }}
                  </a-select-option>
                </a-select>
              </a-col>
              <a-col :span="5" style="padding: 0px 10px">
                <a-input placeholder="请选择规格" />
              </a-col>
              <a-col :span="5" style="padding: 0px 10px">
                <a-input placeholder="请输入单价" />
              </a-col>
              <a-col :span="4" style="padding: 0px 10px">
                <a-input placeholder="请输入数量" />
              </a-col>
              <a-col :span="5" style="padding: 0px 10px">
                <a-input placeholder="备注"    />
              </a-col>
            </a-row>
          </a-descriptions-item>

          <a-descriptions-item label="收件人">
            <a-input placeholder="请输入收件人" />
          </a-descriptions-item>
          <a-descriptions-item label="收件电话">
            <a-input placeholder="请输入收件电话" />
          </a-descriptions-item>
          <a-descriptions-item label="收件地址">
            <a-input placeholder="请输入收件地址" />
          </a-descriptions-item>
          <a-descriptions-item label="总金额" :span="24">
            1000
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
