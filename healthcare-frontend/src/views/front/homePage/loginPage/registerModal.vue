<template>
  <a-modal
    title="注册"
    :visible="visible"
    width="30%"
    @cancel="cancel()">

    <template slot="footer">
      <a-button key="back" @click="cancel()">取消</a-button>
      <a-button
        key="submit"
        type="primary"
        @click="ok()"
      >确定</a-button>
    </template>

    <a-spin :spinning="loading">
      <a-form :form="form">
        <a-form-item
          label="账号"
          :label-col="formItemLayout.labelCol"
          :wrapper-col="formItemLayout.wrapperCol"
        >
          <a-input
            placeholder="请输入账号"
            v-decorator="['staffId', { rules: [{ required: true, message: '账号不能为空!' }] }]"
          />
        </a-form-item>
        <a-form-item
          label="用户名"
          :label-col="formItemLayout.labelCol"
          :wrapper-col="formItemLayout.wrapperCol"
        >
          <a-input
            placeholder="请输入用户名"
            v-decorator="['userName', { rules: [{ required: true, message: '用户名不能为空!' }] }]"
          />
        </a-form-item>
        <a-form-item
          label="用户密码"
          :label-col="formItemLayout.labelCol"
          :wrapper-col="formItemLayout.wrapperCol"
        >
          <a-input-password
            placeholder="请输入密码"
            v-decorator="['userPwd', { rules: [{ required: true, message: '密码不能为空!' }] }]"
          />
        </a-form-item>
        <a-form-item
          label="确认密码"
          :label-col="formItemLayout.labelCol"
          :wrapper-col="formItemLayout.wrapperCol"
        >
          <a-input-password
            placeholder="请再次输入密码"
            v-decorator="['re_pwd', { rules: [{ required: true, message: '密码不能为空!' }] }]"
          />
        </a-form-item>
      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>
import { addUser } from '@/api/loginUser.js'
import { Encrypt } from '@/utils/AES.js'
export default {
  name: 'RegisterModal',
  data () {
    return {
      visible: false,
      loading: false,
      formItemLayout: {
        labelCol: { span: 7 },
        wrapperCol: { span: 14 }
      },
      form: this.$form.createForm(this)
    }
  },
  methods: {
    paramReceive () {
      this.visible = true
      this.loading = false
    },
    cancel () {
      this.visible = false
      this.form.resetFields()
    },
    ok () {
      this.form.validateFields((errors, values) => {
        if (!errors) {
          if (values.userPwd === values.re_pwd) {
            const params = values
            params.userPwd = Encrypt(values.userPwd)

            addUser(params).then(res => {
              switch (res) {
                case 1 :
                  this.$message.success('注册成功')
                  this.cancel()
                  break
                case 2 :
                  this.$message.error('账号已存在')
                  break
                case 0 :
                  this.$message.error('注册失败')
                  this.form.resetFields()
                  break
              }
            })
          } else {
            this.$message.error('两次密码不一致')
            this.form.setFieldsValue({
              userPwd: '',
              re_pwd: ''
            })
          }
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
