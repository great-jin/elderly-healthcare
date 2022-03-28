<template>
  <a-drawer
    title="病人详情"
    width="60%"
    height="100%"
    placement="right"
    :closable="true"
    :visible="visible"
    @close="onClose"
  >
    <h1>AAAAAAAAAAAAAA</h1>
    <h1>AAAAAAAAAAAAAA</h1>
    <h1>AAAAAAAAAAAAAA</h1>
    <h1>AAAAAAAAAAAAAA</h1>
    <h1>AAAAAAAAAAAAAA</h1>
    <h1>AAAAAAAAAAAAAA</h1>
    <h1>AAAAAAAAAAAAAA</h1>
    <h1>AAAAAAAAAAAAAA</h1>
  </a-drawer>
</template>

<script>
export default {
  name: 'UserModal',
  data () {
    return {
      type: '',
      visible: false,
      isDetail: false,
      isEdit: false,
      formItemLayout: {
        labelCol: { span: 7 },
        wrapperCol: { span: 14 }
      },
      form: this.$form.createForm(this)
    }
  },
  methods: {
    paramReceive (type, data) {
      this.type = type
      this.visible = true
      console.log('data', data)
    },
    cancel () {
      this.visible = false
      this.isDetail = false
      this.isEdit = false
      this.form.resetFields()
    },
    ok () {
      this.form.validateFields((errors, values) => {
        if (!errors) {
          const { type } = this
          switch (type) {
            case 'add':
              this.$message.success('添加用户')
              break
            case 'edit':
              this.$message.success('更新信息')
              break
            case 'detail':
              this.$message.success('更新信息')
              break
          }
          this.cancel()
        }
      })
    },
    onClose () {
      this.visible = false
    }
  }
}
</script>

<style scoped>
</style>
