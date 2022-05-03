<template>
  <a-modal
    title="忘记密码"
    :visible="visible"
    width="40%"
    @cancel="cancel()"
  >
    <template slot="footer">
      <a-button key="back" @click="cancel()">取消</a-button>
      <a-button key="submit" type="primary" @click="ok()">确定</a-button>
    </template>
    <a-form-model
      ref="modelForm"
      :model="formData"
      :rules="rules"
    >
      <a-form-model-item
        label="账号"
        prop="staffId"
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
      >
        <a-input
          v-model="formData.staffId"
          placeholder="请输入账号"
        />
      </a-form-model-item>
      <a-form-model-item
        label="邮箱地址"
        prop="staffEmail"
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
      >
        <a-input
          v-model="formData.staffEmail"
          :disabled="true"
        />
      </a-form-model-item>
      <a-form-model-item
        label="验证码"
        prop="verify"
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
      >
        <a-input
          v-model="formData.verify"
          placeholder="请输入验证码"
        />
      </a-form-model-item>
      <a-form-model-item
        label="新密码"
        prop="userPwd"
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
      >
        <a-input
          v-model="formData.userPwd"
          placeholder="请输入新密码"
        />
      </a-form-model-item>
      <a-form-model-item
        label="确认密码"
        prop="userPwd1"
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
      >
        <a-input
          v-model="formData.userPwd1"
          placeholder="请再次输入密码"
        />
      </a-form-model-item>
    </a-form-model>
  </a-modal>
</template>

<script>
// import { Encrypt } from '@/utils/AES.js'

export default {
  name: 'RegisterModal',
  data () {
    return {
      visible: false,
      formData: {
        userName: '',
        telephone: '',
        comment: ''
      },
      rules: {
        staffId: [
          { required: true, message: '账号不能为空', trigger: 'change' }
        ],
        verify: [
          { required: true, message: '验证码不能为空', trigger: 'change' }
        ],
        userPwd: [
          { required: true, message: '密码不能为空', trigger: 'change' }
        ],
        userPwd1: [
          { required: true, message: '密码不能为空', trigger: 'change' }
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
    },
    cancel () {
      this.visible = false
    },
    ok () {
      this.$refs.modelForm.validate(valid => {
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
