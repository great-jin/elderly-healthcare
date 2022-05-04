<template>
  <a-modal
    title="新增信息"
    :visible="visible"
    width="50%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="back" @click="cancel">取消</a-button>
      <a-button key="submit" type="primary" @click="ok">确定</a-button>
    </template>
    <a-form-model
      ref="modelForm"
      :model="formData"
      :rules="rules"
    >
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="员工编号"
            prop="staffId"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.staffId"
              :disabled="true"
              placeholder="请选择员工"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="员工姓名"
            prop="staffName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-select
              v-model="formData.staffName"
              :allowClear="true"
              placeholder="请选择员工"
              style="padding: 0 5px"
              @change="onChange('staff')"
            >
              <a-select-option
                v-for="option in staffList"
                :key="option.staffId"
                :value="option.staffName"
              >{{ option.staffName }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="部门编号"
            prop="organizeId"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.organizeId"
              :disabled="true"
              placeholder="请选择部门"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="部门名称"
            prop="organizeName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-select
              v-model="formData.organizeName"
              :allowClear="true"
              placeholder="请选择部门"
              style="padding: 0 5px"
              @change="onChange('org')"
            >
              <a-select-option
                v-for="option in orgList"
                :key="option.organizeId"
                :value="option.organizeName"
              >{{ option.organizeName }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="工作月份"
            prop="workDate"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-month-picker
              v-model="formData.workDate"
              placeholder="请选择工作月份"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="工作天数"
            prop="workDays"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input-number
              v-model="formData.workDays"
              placeholder="请输入工作天数"
              :min="0"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="请假天数"
            prop="offDays"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input-number
              v-model="formData.offDays"
              placeholder="请输入请假天数"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="罚款金额"
            prop="deductCount"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.deductCount"
              placeholder="请输入罚款金额"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="保险金额"
            prop="insuranceCount"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.insuranceCount"
              placeholder="请输入保险金额"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="补贴金额"
            prop="allowanceCount"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.allowanceCount"
              placeholder="请输入补贴金额"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="合计金额"
            prop="salaryCount"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.salaryCount"
              placeholder="合计金额"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
    </a-form-model>
  </a-modal>
</template>

<script>
import { listOrg } from '@/api/organizeInfo'
import { getAllStaff } from '@/api/organizeStaff'
import { addEmployeeSalary } from '@/api/employeeSalary'

export default {
  name: 'AccountModal',
  data () {
    return {
      visible: false,
      staffList: [],
      orgList: [],
      formData: {
        staffId: '',
        staffName: undefined,
        organizeId: '',
        organizeName: undefined,
        workDate: '',
        workDays: '',
        offDays: '',
        deductCount: '',
        insuranceCount: '',
        allowanceCount: '',
        salaryCount: ''
      },
      rules: {
        staffId: [
          { required: true, message: '不能为空', trigger: 'change' }
        ],
        staffName: [
          { required: true, message: '不能为空', trigger: 'change' }
        ],
        organizeId: [
          { required: true, message: '不能为空', trigger: 'change' }
        ],
        organizeName: [
          { required: true, message: '不能为空', trigger: 'change' }
        ],
        workDate: [
          { required: true, message: '不能为空', trigger: 'change' }
        ],
        workDays: [
          { required: true, message: '不能为空', trigger: 'change' }
        ],
        offDays: [
          { required: true, message: '不能为空', trigger: 'change' }
        ],
        deductCount: [
          { required: true, message: '不能为空', trigger: 'change' }
        ],
        insuranceCount: [
          { required: true, message: '不能为空', trigger: 'change' }
        ],
        allowanceCount: [
          { required: true, message: '不能为空', trigger: 'change' }
        ],
        salaryCount: [
          { required: true, message: '不能为空', trigger: 'change' }
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
  methods: {
    paramReceive () {
      this.visible = true
      this.getData()
    },
    getData () {
      listOrg().then(res => {
        this.orgList = res.data
      })
      getAllStaff().then(res => {
        this.staffList = res.data
      })
    },
    onChange (type) {
      switch (type) {
        case 'org':
          const _org = this.formData.organizeName
          const _orgId = this.orgList.filter(item => item.organizeName === _org)[0]
          this.formData.organizeId = _orgId.organizeId
          break
        case 'staff':
          const _staff = this.formData.staffName
          const _staffId = this.staffList.filter(item => item.staffName === _staff)[0]
          this.formData.staffId = _staffId.staffId
          break
      }
    },
    cancel () {
      this.visible = false
      this.$refs.modelForm.resetFields()
    },
    ok () {
      this.$refs.modelForm.validate(valid => {
        if (valid) {
          addEmployeeSalary(this.formData).then(res => {
            if (res.data) {
              this.$message.success('添加成功')
              this.cancel()
            } else {
              this.$message.error('添加失败，请稍后重试')
            }
          })
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
