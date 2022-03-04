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
        :loading="confirmLoading"
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
            placeholder="Account Code"
            v-decorator="['accountID', { rules: [{ required: true, message: '账号不能为空!' }] }]"
          />
        </a-form-item>

        <a-form-item
          label="用户名"
          :label-col="formItemLayout.labelCol"
          :wrapper-col="formItemLayout.wrapperCol"
        >
          <a-input
            placeholder="UserName"
            v-decorator="['userName', { rules: [{ required: true, message: '用户名不能为空!' }] }]"
          />
        </a-form-item>

        <a-form-item
          label="密码"
          :label-col="formItemLayout.labelCol"
          :wrapper-col="formItemLayout.wrapperCol"
        >
          <a-input
            placeholder="Password"
            v-decorator="['password', { rules: [{ required: true, message: '密码不能为空!' }] }]"
          />
        </a-form-item>
      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>
import { addUser } from '@/api/user.js';
import { Encrypt } from '@/utils/AES.js';
export default {
  name: "UserModal",
  data() {
    return {
      visible: false,
      confirmLoading: false,
      loading: false,
      form: this.$form.createForm(this),
      formItemLayout: {
        labelCol: { span: 7 },
        wrapperCol: { span: 14 }
      }
    }
  },
  methods: {
    paramReceive () {
      this.visible = true
      this.loading = false
    },
    cancel() {
      this.visible = false
      this.form.resetFields()
    },
    ok() {
      this.form.validateFields((errors, values) => {
        if (!errors) {
          const params = values
          params.password = Encrypt(values.password)
          addUser(params).then(res =>{
            console.log(res)
            if(res === 1) {
              this.$message.success('注册成功')
            } else {
              this.$message.error('注册失败')
            }
            this.cancel()
          })
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
