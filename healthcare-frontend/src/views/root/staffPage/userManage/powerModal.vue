<template>
  <a-modal
    :title="type==='power' ? '账号开通' : '账号变更'"
    :visible="visible"
    width="40%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="submit" type="primary" @click="ok">确定</a-button>
      <a-button key="back" @click="cancel">取消</a-button>
    </template>
    <a-form-model
      ref="modelForm"
      :model="formData"
      :rules="rules"
    >
      <a-form-model-item
        label="用户账号"
        prop="staffId"
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
      >
        <a-input
          v-model="formData.staffId"
          :disabled="true"
          placeholder="请输入账号"
        />
      </a-form-model-item>
      <a-form-model-item
        label="用户名"
        prop="userName"
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
      >
        <a-input
          v-model="formData.userName"
          placeholder="请输入用户名"
        />
      </a-form-model-item>
      <a-form-model-item
        label="登录密码"
        prop="userPwd"
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
      >
        <a-input-password
          v-model="formData.userPwd"
          placeholder="请输入密码"
        />
      </a-form-model-item>
      <a-form-model-item
        label="确认密码"
        prop="userPwd1"
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
      >
        <a-input-password
          v-model="formData.userPwd1"
          placeholder="请再次输入密码"
        />
      </a-form-model-item>
      <a-form-model-item
        label="是否启用"
        prop="isDisabled"
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
      >
        <a-radio-group
          v-model="formData.isDisabled"
          :default-value="0"
        >
          <a-radio :value="0">否</a-radio>
          <a-radio :value="1">是</a-radio>
        </a-radio-group>
      </a-form-model-item>
      <a-form-model-item
        label="用户权限"
        prop="userPower"
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
      >
        <a-radio-group
          v-model="formData.userPower"
          :default-value="1"
        >
          <a-radio :value="1">用户</a-radio>
          <a-radio :value="0">管理员</a-radio>
        </a-radio-group>
      </a-form-model-item>
    </a-form-model>
  </a-modal>
</template>

<script>
import { Encrypt } from '@/utils/AES.js'
import { addUser, getUser } from '@/api/loginUser'

export default {
  name: 'AccountModal',
  data () {
    return {
      type: '',
      visible: false,
      formData: {
        staffId: '',
        userName: '',
        userPwd: '',
        userPwd1: '',
        userPower: '',
        isDisabled: ''
      },
      rules: {
        staffId: [
          { required: true, message: '请输入账号', trigger: 'change' }
        ],
        userName: [
          { required: true, message: '请输入用户名', trigger: 'change' }
        ],
        userPwd: [
          { required: true, message: '请输入密码', trigger: 'change' }
        ],
        userPwd1: [
          { required: true, message: '请再次输入密码', trigger: 'change' }
        ],
        userPower: [
          { required: true, message: '请选择用户权限', trigger: 'change' }
        ],
        isDisabled: [
          { required: true, message: '请选择用户启用状态', trigger: 'change' }
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
    paramReceive (type, data) {
      this.type = type
      this.visible = true
      if (type === 'power') {
        this.formData.staffId = data.staffId
        this.formData.userName = data.staffName
      }
      if (type === 'edit') {
        getUser(data.staffId).then(res => {
          this.formData = res.data
          this.formData.userPwd1 = res.data.userPwd
        })
      }
    },
    cancel () {
      this.visible = false
      this.$refs.modelForm.resetFields()
    },
    ok () {
      this.$refs.modelForm.validate(valid => {
        if (valid) {
          if (this.formData.userPwd === this.formData.userPwd1) {
            this.formData.userPwd = Encrypt(this.formData.userPwd)
            this.formData.userPwd1 = this.formData.userPwd
            addUser(this.formData).then(res => {
              if (res.data === 1) {
                this.$message.success('账号开通成功')
                this.cancel()
              }
            })
          } else {
            this.$message.error('密码不一致')
          }
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
