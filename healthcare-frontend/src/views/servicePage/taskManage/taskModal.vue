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
      <a-divider orientation="center">
        任务信息
      </a-divider>
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
            label="负    责    人"
            prop="staffId"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-select
              v-model="form.staffId"
              :allowClear="true"
              placeholder="请选择负责人"
              style="width: 100%; min-width: 100px"
            >
              <a-select-option
                v-for="staff in staffList"
                :key="staff.staffId"
                :value="staff.staffId"
              >
                {{ staff.staffName }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="负责病人"
            prop="patientId"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-select
              v-model="form.patientId"
              :allowClear="true"
              placeholder="请选择病人"
              style="width: 100%; min-width: 100px"
            >
              <a-select-option
                v-for="patient in patientList"
                :key="patient.patientId"
                :value="patient.patientId"
              >
                {{ patient.patientName }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="创建时间"
            prop="createdTime"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-date-picker
              v-model="form.createdTime"
              placeholder="请选择创建时间"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item
            label="任务内容"
            prop="taskContent"
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
            label="任务备注"
            prop="comment"
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
export default {
  name: 'accessForm',
  data () {
    return {
      type: 'add',
      visible: false,
      form: {
        taskId: '',
        taskName: '',
        staffId: '',
        patientId: '',
        createdTime: '',
        taskContent: '',
        comment: ''
      },
      staffList: [
        {
          staffId: '123',
          staffName: 'AA'
        }
      ],
      patientList: [
        {
          patientId: '321',
          patientName: 'BB'
        }
      ],
      rules: {
        taskName: [
          { required: true, message: '请输入任务名', trigger: 'change' }
        ],
        staffId: [
          { required: true, message: '请选择负责人', trigger: 'change' }
        ],
        patientId: [
          { required: true, message: '请选择负责人', trigger: 'change' }
        ],
        createdTime: [
          { required: true, message: '请选择负责病人', trigger: 'change' }
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
      console.log(data)
    },
    ok () {
      this.$refs.taskForm.validate(valid => {
        if (valid) {
          console.log(this.form)
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
