<template>
  <a-modal
    title="账号开通"
    :visible="visible"
    width="40%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="submit" type="primary" @click="ok">确定</a-button>
      <a-button key="back" @click="cancel">取消</a-button>
    </template>
    <div>
      Put content in here
    </div>
  </a-modal>
</template>

<script>
export default {
  name: 'InfoModal',
  data () {
    return {
      type: '',
      visible: false
    }
  },
  methods: {
    paramReceive (type, data) {
      this.type = type
      this.visible = true
      console.log(data)
    },
    cancel () {
      this.visible = false
      this.$message.success('关闭页面')
    },
    ok () {
      this.visible = false
      this.$message.success('关闭页面')
    }
  }
}
</script>

<style scoped>

</style>
