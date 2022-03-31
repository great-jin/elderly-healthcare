<template>
  <a-modal
    :title="type === 'add' ? '新增病人' : '信息修改'"
    :visible="visible"
    width="40%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="back" @click="cancel">取消</a-button>
      <a-button key="submit" type="primary" @click="ok">确定</a-button>
    </template>

    <a-form-model
      ref="ruleForm"
      :model="form"
      :rules="rules"
    >
      <a-row>
        <a-col :span="12">
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
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="病人姓名"
            prop="patientName"
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
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
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
        </a-col>
        <a-col :span="12">
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
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
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
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="是否出院"
            prop="isLeave"
            :labelCol="formLayout.labelCol"
            :wrapperCol="formLayout.wrapperCol"
          >
            <a-radio-group
              v-model="form.isLeave"
              :default-value="0"
            >
              <a-radio :value="0">否</a-radio>
              <a-radio :value="1">是</a-radio>
            </a-radio-group>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
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
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item
            label="详情描述"
            prop="caseDescribe"
            :labelCol="{ xs: { span: 21 }, sm: { span: 3 } }"
            :wrapperCol="{ xs: { span: 24 }, sm: { span: 16 } }"
            style="width: 116%"
          >
            <a-textarea
              v-model="form.caseDescribe"
              placeholder="请输入详情描述"
              type="text"
              :rows="6"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
    </a-form-model>
  </a-modal>
</template>

<script>
import { listNurse } from '@/api/staffNurse.js'
import { listDoctor } from '@/api/staffDoctor.js'
import { listPatientInfo } from '@/api/patientInfo.js'
import { addCaseInfo, updateCaseInfo } from '@/api/patientCaseInfo'

export default {
  name: 'addPatient',
  data () {
    return {
      type: '',
      visible: false,
      isEdit: false,
      form: {
        patientId: '',
        patientName: undefined,
        chargeNurse: undefined,
        chargeDoctor: undefined,
        inTime: '',
        isLeave: 0,
        outTime: '',
        caseDescribe: ''
      },
      rules: {
        patientId: [
          { required: true, message: '请选择病人', trigger: 'change' }
        ],
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
        console.log(this.isEdit)
      }
      this.getData()
    },
    getData () {
      listNurse().then(res => {
        this.nurseList = res.data
      })
      listDoctor().then(res => {
        this.doctorList = res.data
      })
      listPatientInfo().then(res => {
        this.patientList = res.data
      })
    },
    cancel () {
      this.idEdit = false
      this.visible = false
      this.$refs.ruleForm.resetFields()
      this.form = {}
    },
    ok () {
      this.$refs.ruleForm.validate(valid => {
        if (valid) {
          switch (this.type) {
            case 'add':
              addCaseInfo(this.form).then(res => {
                if (res.data !== null) {
                  this.$message.success('添加成功')
                } else {
                  this.$message.error('新增失败')
                }
              })
              break
            case 'edit':
              updateCaseInfo(this.form).then(res => {
                if (res.data !== null) {
                  this.$message.success('修改成功')
                } else {
                  this.$message.error('修改失败')
                }
              })
              break
          }
          this.cancel()
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
