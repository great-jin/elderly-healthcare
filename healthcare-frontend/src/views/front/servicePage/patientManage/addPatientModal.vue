<template>
  <a-modal
    :title="type === 'add' ? '新增病人' : '信息修改'"
    :visible="visible"
    width="55%"
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
              placeholder="自动识别"
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
              @change="changeSelect('patient', form.patientName)"
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
            prop="nurseName"
            :labelCol="formLayout.labelCol"
            :wrapperCol="formLayout.wrapperCol"
          >
            <a-select
              v-model="form.nurseName"
              placeholder="请选择护理员"
              :allowClear="true"
              @change="changeSelect('nurse', form.nurseName)"
            >
              <a-select-option
                v-for="cases in nurseList"
                :key="cases.staffId"
                :value="cases.staffName"
              >{{ cases.staffName }}</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="主治医师"
            prop="doctorName"
            :labelCol="formLayout.labelCol"
            :wrapperCol="formLayout.wrapperCol"
          >
            <a-select
              v-model="form.doctorName"
              placeholder="请选择主治医师"
              :allowClear="true"
              @change="changeSelect('doctor', form.doctorName)"
            >
              <a-select-option
                v-for="cases in doctorList"
                :key="cases.staffId"
                :value="cases.staffName"
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
import { getAddedPatient } from '@/api/patientInfo'
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
        nurseId: '',
        nurseName: undefined,
        doctorId: '',
        doctorName: undefined,
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
        nurseId: [
          { required: true, message: '请选择护理员', trigger: 'change' }
        ],
        nurseName: [
          { required: true, message: '请选择护理员', trigger: 'change' }
        ],
        doctorId: [
          { required: true, message: '请输入主治医师', trigger: 'change' }
        ],
        doctorName: [
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
        this.form = data
        this.idEdit = true
      }
      this.getData()
    },
    getData () {
      getAddedPatient().then(res => {
        this.patientList = res.data
      })
      listNurse().then(res => {
        this.nurseList = res.data
      })
      listDoctor().then(res => {
        this.doctorList = res.data
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
                if (res.data) {
                  this.$message.success('添加成功')
                  this.cancel()
                } else {
                  this.$message.error('新增失败, 请重试')
                }
              })
              break
            case 'edit':
              updateCaseInfo(this.form).then(res => {
                if (res.data) {
                  this.$message.success('修改成功')
                  this.cancel()
                } else {
                  this.$message.error('修改失败, 请重试')
                }
              })
              break
          }
        }
      })
    },
    changeSelect (type, data) {
      switch (type) {
        case 'patient':
          this.form.patientId = (this.patientList.filter(item => item.patientName === data)[0]).patientId
          break
        case 'nurse':
          this.form.nurseId = (this.nurseList.filter(item => item.staffName === data)[0]).staffId
          break
        case 'doctor':
          this.form.doctorId = (this.doctorList.filter(item => item.staffName === data)[0]).staffId
          break
      }
    }
  }
}
</script>

<style scoped>
</style>
