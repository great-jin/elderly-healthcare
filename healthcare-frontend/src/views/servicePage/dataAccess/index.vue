<template>
  <div>
    <a-divider orientation="center">
     基本信息
    </a-divider>
    <a-form :form="form">
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-item
            label="账号1"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              placeholder="请输入账号"
              v-decorator="[
                'accountID',
                { rules: [{ required: true, message: '账号不能为空!' }] }
              ]"
            />
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item
            label="账号2"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input placeholder="请输入账号"/>
          </a-form-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-item
            style="width: 116%"
            label="详情描述"
            :labelCol="{ xs: { span: 21 }, sm: { span: 3 } }"
            :wrapperCol="{ xs: { span: 24 }, sm: { span: 16 } }"
          >
            <a-textarea
              type="text"
              :rows="6"
              v-decorator="[
                'systemDesc',
                {
                  rules: [
                    { required: true, message: text+'不能为空' },
                    { min: 1, max: 300, message: '长度在 1 到 300 个字符', trigger: 'blur' }
                  ]
                }
              ]"
            />
          </a-form-item>
        </a-col>
      </a-row>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-item
            label="账号1"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              placeholder="请输入账号"
              v-decorator="[
                'accountID',
                { rules: [{ required: true, message: '账号不能为空!' }] }
              ]"
            />
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item
            label="账号2"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input placeholder="请输入账号"/>
          </a-form-item>
        </a-col>
      </a-row>
    </a-form>

    <a-divider orientation="center">
      身体状况
    </a-divider>
    <a-form :form="form">
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-item
            label="账号1"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              placeholder="请输入账号"
              v-decorator="[
                'accountID',
                { rules: [{ required: true, message: '账号不能为空!' }] }
              ]"
            />
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item
            label="账号2"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input placeholder="请输入账号"/>
          </a-form-item>
        </a-col>
      </a-row>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-item
            label="账号1"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              placeholder="请输入账号"
              v-decorator="[
                'accountID',
                { rules: [{ required: true, message: '账号不能为空!' }] }
              ]"
            />
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item
            label="账号2"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input placeholder="请输入账号"/>
          </a-form-item>
        </a-col>
      </a-row>
    </a-form>
  </div>
</template>


<script>
export default {
  name: "index",
  data() {
    return {
      form: this.$form.createForm(this),
      labelCol: {
        xs: { span: 24 },
        sm: { span: 7 }
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 13 }
      }
    }
  }
}
</script>

<style scoped>

</style>
