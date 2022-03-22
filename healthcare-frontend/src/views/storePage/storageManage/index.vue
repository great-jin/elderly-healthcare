<template>
  <div>
    <a-input v-model="values" style="margin: 20px"></a-input>
    <a-button @click="ok" style="margin: 20px">完成</a-button>
  </div>
</template>

<script>
export default {
  name: 'index',
  data () {
    return {
      values: ''
    }
  },
  mounted () {
    window.addEventListener("keydown", this.keyDown);
  },
  destroyed() {
    // 一定要销毁事件!!!
    window.removeEventListener("keydown", this.keyDown, false);
  },
  methods: {
    keyDown(e) {
      // 回车则执行登录方法 enter键的ASCII是13
      if (e.keyCode === 13) {
        this.ok();
      }
    },
    ok(){
      this.$message.info('okkkkkk' + this.values)
    }
  }
}
</script>

<style>
</style>
