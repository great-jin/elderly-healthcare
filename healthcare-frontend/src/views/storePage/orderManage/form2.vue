<template>
  <a-form :form="form">
    <a-form-item
      label="用户名3"
      :label-col="formItemLayout.labelCol"
      :wrapper-col="formItemLayout.wrapperCol"
    >
      <a-input
        placeholder="请输入用户名"
        v-decorator="['userName', { rules: [{ required: true, message: '用户名不能为空!' }] }]"
      />
    </a-form-item>
    <a-form-item
      label="用户密码2"
      :label-col="formItemLayout.labelCol"
      :wrapper-col="formItemLayout.wrapperCol"
    >
      <a-input-password
        placeholder="请输入密码"
        v-decorator="['userPwd', { rules: [{ required: true, message: '密码不能为空!' }] }]"
      />
    </a-form-item>
    <a-form-item>
      <a-button type="primary" @click="next(0)" style="margin-right: 10px">上一步</a-button>
      <a-button type="primary" @click="next(2)">完成</a-button>
    </a-form-item>
  </a-form>
</template>

<script>
export default {
  name: "form2",
  data() {
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
    next(data) {
      this.$emit("changeData", data)
    }
  }
}
</script>

<style scoped>

</style>
