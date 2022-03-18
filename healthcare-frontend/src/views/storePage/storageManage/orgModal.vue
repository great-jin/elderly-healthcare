<template>
  <a-modal
    title="上报单位选择"
    :visible="visible"
    width="40%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="back" @click="cancel()">取消</a-button>
      <a-button
        key="submit"
        type="primary"
        @click="ok"
      >确定</a-button>
    </template>
  </a-modal>
</template>

<script>
export default {
  name: 'OrgModal',
  data () {
    return {
      visible: false
    }
  },
  methods: {
    paramReceive (data) {
      this.visible = true
      console.log(data)
    },
    cancel () {
      this.visible = false
    },
    ok () {
      this.visible = false
      this.$emit('getOrg', '福州')
      this.orgName = ''
    }
  }
}
</script>

<style scoped>
</style>
