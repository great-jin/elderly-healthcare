<template>
  <div id="app">
    <div class="upload">
      <a-button @click="showUpload()">上传</a-button>
      <uploadModal ref="uploadModal"></uploadModal>
    </div>

    <div style="margin-top: 20px">
      <a-button @click="download()">下载</a-button>
    </div>

  </div>
</template>

<script>
import uploadModal from './uploadModal'
import { download } from '@/api/files.js'
export default {
  components: {
    uploadModal
  },
  data () {
    return {
      fileName: '',
      fileBucket: '',
      fileList: [],
      uploading: false
    }
  },
  methods: {
    showUpload () {
      this.$refs.uploadModal.paramReceive()
    },
    download () {
      const formData = new FormData()
      const token = JSON.parse(localStorage.getItem('staffInfo'))
      formData.append('staffId', token.staffId)
      download(formData)
    }
  }
}
</script>

<style scoped>
</style>
