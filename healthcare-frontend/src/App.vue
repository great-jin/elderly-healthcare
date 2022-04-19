<template>
  <a-config-provider :locale="zhCN">
    <router-view/>
  </a-config-provider>
</template>

<script>
import zhCN from 'ant-design-vue/lib/locale-provider/zh_CN'

export default {
  name: 'App',
  data () {
    return {
      zhCN
    }
  },
  mounted () {
    this.$router.push('/')
  }
}
</script>

<style scoped>
</style>
