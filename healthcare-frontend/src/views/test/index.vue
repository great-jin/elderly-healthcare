<template>
  <div style="width: 50px; margin: 50px auto;">
    <a-button @click="exit">退出登录</a-button>
  </div>
</template>

<script>
export default {
  name: "index",
  methods:{
    exit(){
      this.$router.push('/')
      localStorage.setItem("token", 0)
    }
  }
}
</script>

<style scoped>

</style>
