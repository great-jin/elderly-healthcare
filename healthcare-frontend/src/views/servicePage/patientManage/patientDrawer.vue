<template>
  <a-drawer
    title="病人详情"
    width="60%"
    placement="right"
    :closable="true"
    :visible="visible"
    @close="cancel"
  >

  </a-drawer>
</template>

<script>
export default {
  name: 'UserModal',
  data () {
    return {
      type: '',
      visible: false,
      isEdit: false,
      isDetail: false
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
    }
  }
}
</script>

<style scoped>
</style>
