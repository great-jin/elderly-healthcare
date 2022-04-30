<template>
  <a-form-model
    ref="modelForm"
    :model="formData"
    :rules="rules"
  >
    <a-form-model-item
      label="采购人员"
      prop="userName"
      :labelCol="labelCol"
      :wrapperCol="wrapperCol"
    >
      <a-input
        v-model="formData.userName"
        placeholder="请输入姓名"
      />
    </a-form-model-item>
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
    <a-form-model-item
      label="详情备注"
      prop="comment"
      :labelCol="labelCol"
      :wrapperCol="wrapperCol"
    >
      <a-textarea
        v-model="formData.comment"
        type="text"
        :rows="6"
      />
    </a-form-model-item>
    <a-form-model-item>
      <a-button type="primary" @click="next">下一步</a-button>
    </a-form-model-item>
  </a-form-model>
</template>

<script>
export default {
  name: 'form1',
  data () {
    return {
      formData: {
        userName: '',
        telephone: '',
        comment: ''
      },
      rules: {},
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
    next () {
      this.$refs.modelForm.validate(valid => {
        if (valid) {
          this.$emit('changeData', 1)
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
