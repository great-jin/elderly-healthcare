<template>
  <div id="app">
    <div class="upload">
      <a-button @click="showUpload()">上传</a-button>
      <uploadModal ref="uploadModal"></uploadModal>
    </div>

<!--    <div style="margin-top: 50px">
      <a-input
        v-model="fileBucket"
        style="width: 15%"
        placeholder="请输入桶名"
      />
      <a-input
        v-model="fileName"
        style="width: 15%"
        placeholder="请输入文件名"
      />
      <a-button @click="download()">下载</a-button>
    </div>-->

    <div style="margin-top: 20px">
      <a-button @click="download()">下载</a-button>
    </div>

  </div>
</template>

<script>
import uploadModal from './uploadModal'
import { download } from '@/api/files.js';
export default {
  components: {
    uploadModal
  },
  data() {
    return {
      fileName: '',
      fileBucket: '',
      fileList: [],
      uploading: false,
    }
  },
  methods: {
    showUpload(){
      this.$refs.uploadModal.paramReceive()
    },
    download(){
      const formData = new FormData();
      const token = JSON.parse(localStorage.getItem('token'))
      formData.append('accountCode', token.flag)
      download(formData)

      /*if(this.fileName !== '' && this.fileBucket !== '') {
        const formData = new FormData()
        formData.append("fileName", this.fileName)
        formData.append("bucketName", this.fileBucket)
        download(formData)
      } else {
        this.$message.error('文件信息不能为空！')
      }*/
    }
  }
}
</script>

<style scoped>
</style>
