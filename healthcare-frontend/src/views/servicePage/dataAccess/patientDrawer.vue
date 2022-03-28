<template>
  <a-drawer
    title="入住详情"
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
      visible: false
    }
  },
  methods: {
    paramReceive (type, data) {
      this.visible = true
      console.log('data', data)
    },
    cancel () {
      this.visible = false
    }
  }
}
</script>

<style scoped>
</style>
