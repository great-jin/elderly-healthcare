<template>
  <a-modal
    :title="type === 'add' ? '新增病人' : '信息修改'"
    :visible="visible"
    width="40%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="submit" type="primary" @click="ok">确定</a-button>
      <a-button key="back" @click="cancel">取消</a-button>
    </template>

    <a-form-model
      ref="ruleForm"
      :model="form"
      :rules="rules"
    >
      <a-form-model-item
        label="病人编号"
        prop="patientId"
        :labelCol="formLayout.labelCol"
        :wrapperCol="formLayout.wrapperCol"
      >
        <a-input
          v-model="form.patientId"
          placeholder="自动生成"
          :disabled="true"
        />
      </a-form-model-item>
      <a-form-model-item
        label="病人姓名"
        prop="inTime"
        :labelCol="formLayout.labelCol"
        :wrapperCol="formLayout.wrapperCol"
      >
        <a-select
          v-model="form.patientName"
          placeholder="请选择病人"
          :allowClear="true"
          :disabled="isEdit"
        >
          <a-select-option
            v-for="cases in patientList"
            :key="cases.patientId"
            :value="cases.patientName"
          >{{ cases.patientName }}</a-select-option>
        </a-select>
      </a-form-model-item>
      <a-form-model-item
        label="护理人员"
        prop="chargeNurse"
        :labelCol="formLayout.labelCol"
        :wrapperCol="formLayout.wrapperCol"
      >
        <a-select
          v-model="form.chargeNurse"
          placeholder="请选择护理员"
          :allowClear="true"
        >
          <a-select-option
            v-for="cases in nurseList"
            :key="cases.staffId"
            :value="cases.staffId"
          >{{ cases.staffName }}</a-select-option>
        </a-select>
      </a-form-model-item>
      <a-form-model-item
        label="主治医师"
        prop="chargeDoctor"
        :labelCol="formLayout.labelCol"
        :wrapperCol="formLayout.wrapperCol"
      >
        <a-select
          v-model="form.chargeDoctor"
          placeholder="请选择主治医师"
          :allowClear="true"
        >
          <a-select-option
            v-for="cases in doctorList"
            :key="cases.staffId"
            :value="cases.staffId"
          >{{ cases.staffName }}</a-select-option>
        </a-select>
      </a-form-model-item>
      <a-form-model-item
        label="入住时间"
        prop="inTime"
        :labelCol="formLayout.labelCol"
        :wrapperCol="formLayout.wrapperCol"
      >
        <a-date-picker
          v-model="form.inTime"
          placeholder="请选择入住时间"
          :disabled="isEdit"
          style="width: 100%"
        />
      </a-form-model-item>
      <a-form-model-item
        label="是否出院"
        prop="isLeave"
        :labelCol="formLayout.labelCol"
        :wrapperCol="formLayout.wrapperCol"
      >
        <a-radio-group
          v-model="form.isLeave"
          default-value="1"
        >
          <a-radio value="1">是</a-radio>
          <a-radio value="0">否</a-radio>
        </a-radio-group>
      </a-form-model-item>
      <a-form-model-item
        label="出院时间"
        prop="outTime"
        :labelCol="formLayout.labelCol"
        :wrapperCol="formLayout.wrapperCol"
      >
        <a-date-picker
          v-model="form.outTime"
          placeholder="请选择出院时间"
          style="width: 100%"
        />
      </a-form-model-item>
    </a-form-model>
  </a-modal>
</template>

<script>
export default {
  name: 'addPatient',
  data () {
    return {
      type: '',
      visible: false,
      isEdit: false,
      form: {
        patientId: '',
        patientName: '',
        chargeNurse: '',
        chargeDoctor: '',
        inTime: '',
        isLeave: '',
        outTime: ''
      },
      rules: {
        patientName: [
          { required: true, message: '请选择病人', trigger: 'change' }
        ],
        chargeNurse: [
          { required: true, message: '请选择护理员', trigger: 'change' }
        ],
        chargeDoctor: [
          { required: true, message: '请输入主治医师', trigger: 'change' }
        ],
        inTime: [
          { required: true, message: '请选择入住时间', trigger: 'change' }
        ],
        isLeave: [
          { required: true, message: '请选择是否出院', trigger: 'change' }
        ]
      },
      patientList: [],
      nurseList: [],
      doctorList: [],
      formLayout: {
        labelCol: { span: 7 },
        wrapperCol: { span: 14 }
      }
    }
  },
  methods: {
    paramReceive (type, data) {
      this.type = type
      this.visible = true
      if (type === 'edit') {
        this.idEdit = true
        this.form = data
      }
    },
    cancel () {
      this.idEdit = false
      this.visible = false
      this.$refs.ruleForm.resetFields()
    },
    ok () {
      this.$refs.ruleForm.validate(valid => {
        if (valid) {
          console.log(this.form)
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
