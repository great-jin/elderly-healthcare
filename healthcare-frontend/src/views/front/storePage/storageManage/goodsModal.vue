<template>
  <a-modal
    :title="type === 'add' ? '新增' : '详情'"
    :visible="visible"
    width="60%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="back" @click="cancel">取消</a-button>
      <a-button key="submit" type="primary" @click="ok">确定</a-button>
    </template>
    <a-form-model
      ref="modelForm"
      :model="formData"
      :rules="rules"
    >
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="联系人"
            prop="userName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.userName"
              placeholder="请输入联系人"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="联系方式"
            prop="telephone"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.telephone"
              placeholder="请输入联系方式"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="联系人"
            prop="userName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.userName"
              placeholder="请输入联系人"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="联系方式"
            prop="telephone"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.telephone"
              placeholder="请输入联系方式"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="联系人"
            prop="userName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.userName"
              placeholder="请输入联系人"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="联系方式"
            prop="telephone"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.telephone"
              placeholder="请输入联系方式"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="联系人"
            prop="userName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.userName"
              placeholder="请输入联系人"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="联系方式"
            prop="telephone"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.telephone"
              placeholder="请输入联系方式"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="联系人"
            prop="userName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.userName"
              placeholder="请输入联系人"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="联系方式"
            prop="telephone"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.telephone"
              placeholder="请输入联系方式"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="联系人"
            prop="userName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.userName"
              placeholder="请输入联系人"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="联系方式"
            prop="telephone"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.telephone"
              placeholder="请输入联系方式"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="联系人"
            prop="userName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.userName"
              placeholder="请输入联系人"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="联系方式"
            prop="telephone"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.telephone"
              placeholder="请输入联系方式"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="联系人"
            prop="userName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.userName"
              placeholder="请输入联系人"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="联系方式"
            prop="telephone"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.telephone"
              placeholder="请输入联系方式"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
    </a-form-model>
  </a-modal>
</template>

<script>
export default {
  name: 'GoodsModal',
  data () {
    return {
      type: '',
      visible: false,
      formData: {

      },
      rules: {

      },
      labelCol: {
        xs: { span: 24 },
        sm: { span: 7 }
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 13 }
      }
    }
  },
  methods: {
    paramReceive (type, data) {
      this.type = type
      this.visible = true
      console.log(data)
    },
    cancel () {
      this.visible = false
      this.$message.success('关闭页面')
    },
    ok () {
      this.visible = false
      this.$message.success('关闭页面')
    }
  }
}
</script>

<style scoped>
</style>
