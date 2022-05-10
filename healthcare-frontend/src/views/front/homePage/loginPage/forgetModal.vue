<template>
  <a-modal
    title="忘记密码"
    :visible="visible"
    width="35%"
    @cancel="cancel()"
  >
    <template slot="footer">
      <a-button key="back" @click="cancel">取消</a-button>
      <a-button key="submit" type="primary" @click="updatePwd">确定</a-button>
    </template>
    <a-form-model
      ref="modelForm"
      :model="formData"
      :rules="rules"
      labelAlign="left"
      :style="{paddingLeft:'10px'}"
    >
      <a-row>
        <a-col :span="24">
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
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="16">
          <a-form-model-item
            label="邮箱"
            prop="staffEmail"
            :labelCol="{
              sm: { span: 6 }
            }"
            :wrapperCol="{
              sm: { span: 18 }
            }"
          >
            <a-input
              v-model="formData.staffEmail"
              placeholder="请输入关联邮箱"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="2">
        </a-col>
        <a-col :span="4" style="line-height: 38px">
          <a-button @click="send">发送</a-button>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item
            label="验证码"
            prop="verifyCode"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.verifyCode"
              placeholder="请输入验证码"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item
            label="新密码"
            prop="userPwd"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input-password
              v-model="formData.userPwd"
              placeholder="请输入新密码"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
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
        </a-col>
      </a-row>
    </a-form-model>
  </a-modal>
</template>

<script>
import {Encrypt} from '@/utils/AES.js'
import {getInfo, sendMail, forgetPwd} from '@/api/loginUser'

export default {
  name: 'RegisterModal',
  data() {
    return {
      visible: false,
      emailCode: '',
      formData: {
        staffId: '',
        staffEmail: '',
        verifyCode: '',
        userPwd: '',
        userPwd1: ''
      },
      rules: {
        staffId: [
          {required: true, message: '账号不能为空', trigger: 'change'}
        ],
        staffEmail: [
          {required: true, message: '验证码不能为空', trigger: 'change'}
        ],
        verifyCode: [
          {required: true, message: '验证码不能为空', trigger: 'change'}
        ],
        userPwd: [
          {required: true, message: '密码不能为空', trigger: 'change'}
        ],
        userPwd1: [
          {required: true, message: '密码不能为空', trigger: 'change'}
        ]
      },
      labelCol: {
        xs: {span: 24},
        sm: {span: 4}
      },
      wrapperCol: {
        xs: {span: 24},
        sm: {span: 18}
      }
    }
  },
  methods: {
    paramReceive() {
      this.visible = true
      this.emailCode = ''
      this.formData = {}
    },

    cancel() {
      this.visible = false
      this.emailCode = ''
      this.formData = {}
    },
    send() {
      // 获取用户邮箱比对
      // 一致发送验证码
      const _email = this.formData.staffEmail
      if (_email !== '') {
        const _staffId = this.formData.staffId
        getInfo(_staffId).then(async res => {
          if (res.data.staffEmail === _email) {
            // 邮箱地址一致则发送验证码
            const _form = new FormData()
            _form.append('email', _email)
            await sendMail(_form).then(res => {
              console.log(res);
              this.emailCode = res.data
              this.$message.success('发送成功，请注意查收')
            })
          } else {
            this.$message.error('该邮箱未绑定账号')
          }
        })
      }
    },
    updatePwd() {
      // 修改用户密码
      console.log('11111111111')
      this.$refs.modelForm.validate(valid => {
        console.log(this.formData)
        if (valid) {
          // 比对验证码
          if (this.emailCode.toString() === this.formData.verifyCode) {
            // 比对两次密码
            const _pwd = this.formData.userPwd
            const _pwd1 = this.formData.userPwd1
            if (_pwd === _pwd1) {
              const _user = {
                staffId: this.formData.staffId,
                userPwd: Encrypt(_pwd)
              }
              console.log('update user', _user)
              forgetPwd(_user).then(res => {
                if (res.data) {
                  this.$message.success('密码修改成功')
                  this.cancel()
                } else {
                  this.$message.error('密码修改失败, 请稍后重试')
                }
              })
            }
          } else {
            this.$message.error('验证码不一致，请重试')
          }
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
