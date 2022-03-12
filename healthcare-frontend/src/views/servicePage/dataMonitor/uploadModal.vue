<template>
  <a-modal
    title="上传"
    :visible="visible"
    width="40%"
    @cancel="cancel()">

    <template slot="footer">
      <a-button key="back" @click="cancel()">取消</a-button>
      <a-button
        key="submit"
        type="primary"
        :loading="uploading"
        :disabled="fileList.length === 0"
        @click="handleUpload"
      >{{ uploading ? '上传中' : '上传' }}</a-button>
    </template>

    <a-spin :spinning="loading">
      <a-input
        v-model="userID"
        placeholder="请输入用户编号"
      />
      <a-upload
        :file-list="fileList"
        :remove="handleRemove"
        :before-upload="beforeUpload">
        <a-button> <a-icon type="upload" /> 选择文件 </a-button>
      </a-upload>
    </a-spin>
  </a-modal>
</template>

<script>
import { UploadFile } from '@/api/files.js';
export default {
  name: "UploadModal",
  data() {
    return {
      visible: false,
      loading: false,
      uploading: false,
      userID: '',
      fileList: []
    }
  },
  methods: {
    paramReceive () {
      this.visible = true
      this.loading = false
    },
    cancel() {
      this.visible = false
      this.fileList = []
    },
    handleRemove(file) {
      const index = this.fileList.indexOf(file);
      const newFileList = this.fileList.slice();
      newFileList.splice(index, 1);
      this.fileList = newFileList;
    },
    beforeUpload(file) {
      this.fileList = [...this.fileList, file];
      return false;
    },
    handleUpload() {
      if (this.userID !== ''){
        const { fileList } = this;
        const formData = new FormData();
        fileList.forEach(file => {
          formData.append('files', file);
        });
        formData.append('ID', this.userID)
        this.uploading = true;

        /*UploadFile(formData).then(res => {
          if (res) {
            this.fileList = [];
            this.uploading = false;
            this.$message.success('上传成功');
          } else {
            this.uploading = false;
            this.$message.error('上传失败');
          }
        })*/
        this.cancel()
      } else {
        this.$message.error('ID 不能为空')
      }
    }
  }
}
</script>

<style scoped>
</style>
