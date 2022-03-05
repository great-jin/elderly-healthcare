<template>
  <a-modal
    title="找回密码"
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

    <a-form :form="form">
      HHHHHHHH
    </a-form>
  </a-modal>
</template>

<script>
export default {
  name: "UserModal",
  data() {
    return {
      visible: false,
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
    },
    cancel() {
      this.visible = false
      this.form.resetFields()
    },
    ok() {
      this.form.validateFields((errors, values) => {
        if (!errors) {

        }
      })
    }
  }
}
</script>

<style scoped>
</style>
