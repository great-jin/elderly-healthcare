<template>
  <div id="app">
    <div style="background: #ECECEC; padding: 30px">
      <a-row :gutter="16">
        <a-col :span="12">
          <a-card>
            <a-statistic
              title="Feedback"
              :value="11.28"
              :precision="2"
              suffix="%"
              :value-style="{ color: '#3f8600' }"
              style="margin-right: 50px"
            >
              <template #prefix>
                <a-icon type="arrow-up" />
              </template>
            </a-statistic>
          </a-card>
        </a-col>
        <a-col :span="12">
          <a-card>
            <a-statistic
              title="Idle"
              :value="9.3"
              :precision="2"
              suffix="%"
              class="demo-class"
              :value-style="{ color: '#cf1322' }"
            >
              <template #prefix>
                <a-icon type="arrow-down" />
              </template>
            </a-statistic>
          </a-card>
        </a-col>
      </a-row>
    </div>

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
    }
  }
}
</script>

<style scoped>
</style>
