<template>
  <div id="contain">
    <a-col :span="4" class="side">
      <a-button
        type="dashed"
        @click="backHome"
        style="width: 100%; margin-bottom: 30px"
      >
        <a-icon type="arrow-left" />
        返回
      </a-button>
      <a-affix :offset-top="top">
        <a-anchor>
          <a-anchor-link href="#1" title="1. 基本信息" />
          <a-anchor-link href="#2" title="2. 账号安全">
          </a-anchor-link>
        </a-anchor>
      </a-affix>
    </a-col>

    <a-col :span="20" class="content">
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
    </a-col>
  </div>
</template>

<script>
export default {
  name: 'PersonalCenter',
  data () {
    return {
      top: 10,
      type: 'add',
      staffInfo: {},
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
  mounted () {
    this.staffInfo = JSON.parse(localStorage.getItem('staffInfo'))
  },
  methods: {
    backHome () {
      this.$router.push('/elderlyHealthcare/home')
    },
    ok () {
      this.$refs.registerForm.validate(valid => {
        if (valid) {
          console.log(this.form)
        }
      })
    },
    cancel () {
      this.$refs.registerForm.resetFields()
    }
  }
}
</script>

<style scoped>
  #contain{
    padding: 20px;
  }
  .side{
    padding: 15px;
    margin: auto 0px;
    /*border: #1890ff 2px solid;*/
  }
  .content{
    padding: 15px;
    /*border: #1890ff 2px solid;*/
  }

</style>
