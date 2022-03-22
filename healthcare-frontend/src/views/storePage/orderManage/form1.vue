<template>
  <a-form :form="form">
    <a-form-item
      label="用户名1"
      :label-col="formItemLayout.labelCol"
      :wrapper-col="formItemLayout.wrapperCol"
    >
      <a-input
        placeholder="请输入用户名"
        v-decorator="['name', { rules: [{ required: true, message: '用户名不能为空!' }] }]"
      />
    </a-form-item>
    <a-form-item
      label="用户密码1"
      :label-col="formItemLayout.labelCol"
      :wrapper-col="formItemLayout.wrapperCol"
    >
      <a-input-password
        placeholder="请输入密码"
        v-decorator="['password', { rules: [{ required: true, message: '密码不能为空!' }] }]"
      />
    </a-form-item>
    <a-form-item>
      <a-button type="primary" @click="next">下一步</a-button>
    </a-form-item>
  </a-form>
</template>

<script>
export default {
  name: 'form1',
  data () {
    return {
      formItemLayout: {
        labelCol: { span: 7 },
        wrapperCol: { span: 14 }
      },
      form: this.$form.createForm(this)
    }
  },
  methods: {
    next () {
      this.$emit('changeData', 1)
    }
  }
}
</script>

<style scoped>
</style>
