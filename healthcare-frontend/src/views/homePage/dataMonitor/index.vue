<template>
  <div>
    <a-button @click="download">下载</a-button>
  </div>
</template>

<script>
import {download} from '@/api/files'

export default {
  name: "index",
  methods: {
    download() {
      download()
    }
  }
}
</script>

<style scoped>

</style>
