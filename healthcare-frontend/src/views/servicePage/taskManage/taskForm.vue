<template>
  <div style="padding: 0px 15px">
    <a-form-model
      ref="registerForm"
      :model="form"
      :rules="rules"
    >
      <a-divider orientation="center">
        基本信息
      </a-divider>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="姓名"
            prop="userName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.userName"
              placeholder="请输入账号"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="性别"
            prop="gender"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.gender"
              placeholder="请输入账号"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item
            label="详情描述"
            prop="description"
            :labelCol="{ xs: { span: 21 }, sm: { span: 3 } }"
            :wrapperCol="{ xs: { span: 24 }, sm: { span: 16 } }"
            style="width: 116%"
          >
            <a-textarea
              v-model="form.description"
              type="text"
              :rows="6"
            />
          </a-form-model-item>
        </a-col>
      </a-row>

      <a-divider orientation="center">
        身体状况
      </a-divider>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="年龄"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.userName"
              placeholder="请输入账号"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="入住时间"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.gender"
              placeholder="请输入账号"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="姓名"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.userName"
              placeholder="请输入账号"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="性别"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.gender"
              placeholder="请输入账号"
            />
          </a-form-model-item>
        </a-col>
      </a-row>

      <a-row>
        <a-col :span="24" :style="{ textAlign: 'center' }">
          <a-button type="primary" @click="ok">完成</a-button>
          <a-button type="primary" @click="cancel" :style="{ marginLeft: '20px' }">取消</a-button>
        </a-col>
      </a-row>
    </a-form-model>
  </div>
</template>

<script>
export default {
  name: "accessForm",
  data() {
    return {
      type: 'add',
      form: {
        userName: '',
        gender: '',
        description: ''
      },
      rules: {
        userName: [
          { required: true, message: '请输入用户名', trigger: 'change' }
        ],
        gender: [
          { required: true, message: '请输入性别', trigger: 'change' }
        ],
        description: [
          { required: true, message: '请输入描述', trigger: 'blur' },
          { min: 3, max: 300, message: '长度在 1 到 300 个字符', trigger: 'blur' }
        ]
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
    ok() {
      this.$refs.registerForm.validate(valid => {
        if (valid) {
          console.log(this.form)
        }
      })
    },
    cancel(){
      this.$refs.registerForm.resetFields()
    }
  }
}
</script>

<style scoped>
</style>
