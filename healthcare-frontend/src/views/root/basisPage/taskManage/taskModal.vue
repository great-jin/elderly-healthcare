<template>
  <a-modal
    :title="type === 'add' ? '新增' : '详情'"
    :visible="visible"
    width="60%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="back" @click="cancel">取消</a-button>
      <a-button key="submit" type="primary" @click="ok">确定</a-button>
    </template>
    <a-form-model
      :model="form"
      :rules="rules"
      ref="taskForm"
    >
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="任务编号"
            prop="taskId"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
            class="required"
          >
            <a-input
              v-model="form.taskId"
              :disabled="true"
              placeholder="自动生成"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="任务名称"
            prop="taskName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.taskName"
              :maxLength="20"
              :allowClear="true"
              placeholder="请输入任务名称"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="负责病人"
            prop="patientName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-select
              v-model="form.patientName"
              placeholder="请选择病人"
              :allowClear="true"
              style="width: 100%; min-width: 100px"
            >
              <a-select-option
                v-for="cases in patientList"
                :key="cases.patientId"
                :value="cases.patientName"
              >{{ cases.patientName }}</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="护理人员"
            prop="nurseName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-select
              v-model="form.nurseName"
              placeholder="请选择负责人"
              :allowClear="true"
              style="width: 100%; min-width: 100px"
            >
              <a-select-option
                v-for="cases in nurseList"
                :key="cases.staffId"
                :value="cases.staffName"
              >{{ cases.staffName }}</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="开始时间"
            prop="createdTime"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-date-picker
              v-model="form.createdTime"
              placeholder="请选择开始时间"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="是否完成"
            prop="isFinished"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-radio-group
              v-model="form.isFinished"
              :default-value="0"
            >
              <a-radio :value="0">否</a-radio>
              <a-radio :value="1">是</a-radio>
            </a-radio-group>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item
            label="任务内容"
            prop="taskContent"
            placeholder="请选择任务内容"
            :labelCol="{ xs: { span: 21 }, sm: { span: 3 } }"
            :wrapperCol="{ xs: { span: 24 }, sm: { span: 16 } }"
            style="width: 116%"
          >
            <a-textarea
              v-model="form.taskContent"
              type="text"
              :rows="5"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item
            label="详情备注"
            prop="comment"
            placeholder="详情备注"
            :labelCol="{ xs: { span: 21 }, sm: { span: 3 } }"
            :wrapperCol="{ xs: { span: 24 }, sm: { span: 16 } }"
            style="width: 116%"
          >
            <a-textarea
              v-model="form.comment"
              type="text"
              :rows="3"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
    </a-form-model>
  </a-modal>
</template>

<script>
import { addTask } from '@/api/dailyTask'
import { listNurse } from '@/api/staffNurse.js'
import { listCaseInfo } from '@/api/patientCaseInfo.js'

export default {
  name: 'accessForm',
  data () {
    return {
      type: 'add',
      visible: false,
      patientList: [],
      nurseList: [],
      form: {
        taskId: '',
        taskName: '',
        patientId: '',
        patientName: undefined,
        nurseId: '',
        nurseName: undefined,
        createdTime: '',
        isFinished: 0,
        taskContent: '',
        comment: ''
      },
      rules: {
        taskId: [
          { required: true, message: '任务编号', trigger: 'change' }
        ],
        taskName: [
          { required: true, message: '请输入任务名', trigger: 'change' }
        ],
        patientName: [
          { required: true, message: '请选择病人', trigger: 'change' }
        ],
        nurseName: [
          { required: true, message: '请选择负责人', trigger: 'change' }
        ],
        createdTime: [
          { required: true, message: '请选择开始时间', trigger: 'change' }
        ],
        isFinished: [
          { required: true, message: '请选择是否完成', trigger: 'change' }
        ],
        taskContent: [
          { required: true, message: '请输入任务内容', trigger: 'blur' },
          { min: 3, max: 300, message: '长度在 1 到 300 个字符', trigger: 'blur' }
        ]
      },
      labelCol: {
        xs: { span: 24 },
        sm: { span: 7 }
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 13 }
      }
    }
  },
  mounted () {
    this.form.taskId = this.guid().substr(0, 8)
  },
  methods: {
    paramReceive (type, data) {
      this.type = type
      this.visible = true
      if (type === 'edit') {
        this.form = data
        this.form.staffName = data.nurseName
        this.form.taskId = data.taskId.substr(0, 8)
      }
      this.getData()
    },
    getData () {
      listNurse().then(res => {
        this.nurseList = res.data
      })
      listCaseInfo().then(res => {
        this.patientList = res.data
      })
    },
    ok () {
      this.$refs.taskForm.validate(valid => {
        if (valid) {
          const _nurseId = (this.nurseList.filter(item => item.staffName === this.form.nurseName))[0].staffId
          this.form.nurseId = _nurseId
          const _patientId = (this.patientList.filter(item => item.patientName === this.form.patientName))[0].patientId
          this.form.patientId = _patientId
          addTask(this.form).then(res => {
            if (res.data) {
              this.$message.success('任务新增成功')
              this.cancel()
            } else {
              this.$message.error('新增失败，请稍后重试')
            }
          })
        }
      })
    },
    cancel () {
      this.visible = false
      this.$refs.taskForm.resetFields()
    },
    guid () {
      return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        const r = Math.random() * 16 | 0
        const v = c === 'x' ? r : (r & 0x3 | 0x8)
        return v.toString(16)
      })
    }
  }
}
</script>

<style scoped>
  .required .ant-form-item-label label::before {
    content: '*';
    line-height: 1;
    display: inline-block;
    margin-right: 4px;
    color: #f5222d;
    font-size: 14px;
    font-family: SimSun, sans-serif;
  }
</style>
