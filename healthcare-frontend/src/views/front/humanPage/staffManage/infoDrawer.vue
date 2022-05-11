<template>
  <a-drawer
    :title="type ==='add' ? '新增员工' : '员工信息'"
    width="50%"
    placement="right"
    :closable="true"
    :visible="visible"
    @close="cancel"
  >
    <template v-if="!isMore">
      <a-button type="primary" @click="ok" style="float: right; z-index: 1">保存</a-button>
    </template>
    <a-row>
      <a-form-model
        ref="registerForm"
        :model="form"
        :rules="rules"
        :disabled="isMore"
        style="overflow-x: hidden"
      >
        <a-row>
          <a-col :span="12">
            <a-form-model-item
              label="编号"
              prop="staffId"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="form.staffId"
                placeholder="请输入编号"
                :disabled="isMore"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="姓名"
              prop="staffName"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="form.staffName"
                placeholder="请选择姓名"
                :disabled="isMore"
                style="width: 100%"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item
              label="部门"
              prop="organizeId"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-select
                v-model="form.organizeId"
                placeholder="请输入部门"
                :disabled="isMore"
                :allowClear="true"
              >
                <a-select-option
                  v-for="cases in orgList"
                  :key="cases.organizeId"
                  :value="cases.organizeId"
                >{{ cases.organizeName }}
                </a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="职位"
              prop="staffPosition"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-select
                v-model="form.staffPosition"
                placeholder="请选择职位"
                :disabled="isMore"
                style="width: 100%"
              >
                <a-select-option value="护理员">护理员</a-select-option>
                <a-select-option value="监护医师">监护医师</a-select-option>
                <a-select-option value="普通员工">普通员工</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item
              label="性别"
              prop="staffGender"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-select
                v-model="form.staffGender"
                placeholder="请选择性别"
                :disabled="isMore"
                style="width: 100%"
              >
                <a-select-option value="男">男</a-select-option>
                <a-select-option value="女">女</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="年龄"
              prop="staffAge"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="form.staffAge"
                placeholder="请输入年龄"
                :disabled="isMore"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item
              label="电话"
              prop="staffPhone"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="form.staffPhone"
                placeholder="请输入电话"
                :disabled="isMore"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="邮箱"
              prop="staffEmail"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="form.staffEmail"
                placeholder="请输入邮箱"
                :disabled="isMore"
                style="width: 100%"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item
              label="入职时间"
              prop="entryTime"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-date-picker
                v-model="form.entryTime"
                placeholder="请选择入职时间"
                :disabled="isMore"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="是否离职"
              prop="isResigned"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-radio-group
                v-model="form.isResigned"
                :disabled="isMore"
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
              label="离职时间"
              prop="resignTime"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-date-picker
                v-model="form.resignTime"
                placeholder="请选择离职时间"
                :disabled="isMore"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="24">
            <a-form-model-item
              label="家庭住址"
              prop="staffAddress"
              :labelCol="{ xs: { span: 21 }, sm: { span: 3 } }"
              :wrapperCol="{ xs: { span: 24 }, sm: { span: 16 } }"
              style="width: 116%"
            >
              <a-textarea
                v-model="form.staffAddress"
                type="text"
                :disabled="isMore"
                :rows="2"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
      </a-form-model>
    </a-row>
  </a-drawer>
</template>

<script>
import { listNurse, addNurse, updateNurse } from '@/api/staffNurse'
import { listDoctor, addDoctor, updateDoctor } from '@/api/staffDoctor'
import { listOrganizeStaff, addOrganizeStaff, updateOrganizeStaff } from '@/api/organizeStaff'
import { listOrg } from '@/api/organizeInfo'

export default {
  name: 'InfoDrawer',
  data () {
    return {
      type: '',
      visible: false,
      isMore: false,
      staffType: '',
      orgList: [],
      form: {
        staffId: '',
        staffName: '',
        organizeId: undefined,
        staffPosition: undefined,
        staffGender: undefined,
        staffAge: '',
        staffPhone: '',
        staffEmail: '',
        entryTime: '',
        isResigned: '',
        resignTime: '',
        staffAddress: ''
      },
      rules: {
        staffId: [
          { required: true, message: '请输入姓名', trigger: 'change' }
        ],
        staffName: [
          { required: true, message: '请输入姓名', trigger: 'change' }
        ],
        organizeId: [
          { required: true, message: '请输入姓名', trigger: 'change' }
        ],
        staffPosition: [
          { required: true, message: '请输入姓名', trigger: 'change' }
        ],
        staffGender: [
          { required: true, message: '请输入姓名', trigger: 'change' }
        ],
        staffAge: [
          { required: true, message: '请输入姓名', trigger: 'change' }
        ],
        staffPhone: [
          { required: true, message: '请输入姓名', trigger: 'change' }
        ],
        staffEmail: [
          { required: true, message: '请输入姓名', trigger: 'change' }
        ],
        entryTime: [
          { required: true, message: '请输入姓名', trigger: 'change' }
        ],
        isResigned: [
          { required: true, message: '请输入姓名', trigger: 'change' }
        ],
        staffAddress: [
          { required: true, message: '请输入姓名', trigger: 'change' }
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
    paramReceive (type, staffType, data) {
      this.type = type
      this.visible = true
      if (type === 'more') {
        this.isMore = true
      }
      if (type !== 'add') {
        this.staffType = staffType
        this.getData(staffType, data)
      }
      if (type === 'add') {
        this.getOrgList()
      }
    },
    getOrgList () {
      listOrg().then(res => {
        this.orgList = res.data
      })
    },
    getData (staffType, data) {
      const _object = {
        staffId: data
      }
      switch (staffType) {
        case 'nurse':
          listNurse(_object).then(res => {
            this.form = res.data[0]
          })
          break
        case 'doctor':
          listDoctor(_object).then(res => {
            this.form = res.data[0]
          })
          break
        default:
          listOrganizeStaff(_object).then(res => {
            this.form = res.data[0]
          })
          break
      }
    },
    cancel () {
      this.visible = false
      this.isMore = false
      this.form = {}
    },
    ok () {
      const _type = this.type
      switch (this.form.organizeId) {
        case 'n01':
          if (_type === 'add') {
            addNurse(this.form).then(res => {
              if (res.data) {
                this.$message.success('保存成功')
              }
            })
          }
          if (_type === 'edit') {
            updateNurse(this.form).then(res => {
              if (res.data) {
                this.$message.success('保存成功')
              }
            })
          }
          break
        case 'd01':
          if (_type === 'add') {
            addDoctor(this.form).then(res => {
              if (res.data) {
                this.$message.success('保存成功')
              }
            })
          }
          if (_type === 'edit') {
            updateDoctor(this.form).then(res => {
              if (res.data) {
                this.$message.success('保存成功')
              }
            })
          }
          break
        default:
          if (_type === 'add') {
            addOrganizeStaff(this.form).then(res => {
              if (res.data) {
                this.$message.success('保存成功')
              }
            })
          }
          if (_type === 'edit') {
            updateOrganizeStaff(this.form).then(res => {
              if (res.data) {
                this.$message.success('保存成功')
              }
            })
          }
          break
      }
      this.cancel()
    }
  }
}
</script>

<style scoped>
</style>
