<template>
  <div id="contain">
    <a-col :span="4" class="side">
      <a-button
        type="dashed"
        @click="quit"
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
        <a-divider orientation="left">
          基本信息
        </a-divider>
        <a-row :gutter="2" :style="{textAlign: 'center'}">
          <a-col :span="24">
            <a-avatar :size="64" :src="imgUrl" @click="uploadAvatar"/>
            <UploadModal ref="uploadModal"/>
          </a-col>
        </a-row>
        <a-row :gutter="2" :style="{marginTop: '15px'}">
          <a-col :span="12">
            <a-form-model-item
              label="账号"
              prop="staffId"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="form.staffId"
                placeholder="请输入账号"
                :disabled="true"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="姓名"
              prop="staffName"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="form.staffName"
                placeholder="请输入姓名"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row :gutter="2" :style="{marginTop: '15px'}">
          <a-col :span="12">
            <a-form-model-item
              label="性别"
              prop="staffGender"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-select
                v-model="form.staffGender"
                default-value="男"
                style="width: 100%"
              >
                <a-select-option value="男">男</a-select-option>
                <a-select-option value="女">女</a-select-option>
              </a-select>
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="年龄"
              prop="staffAge"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input-number
                v-model="form.staffAge"
                placeholder="请输入年龄"
                :min="0"
                style="width: 100%"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row :gutter="2" :style="{marginTop: '15px'}">
          <a-col :span="12">
            <a-form-model-item
              label="电话"
              prop="staffPhone"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="form.staffPhone"
                placeholder="请输入联系电话"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="邮箱"
              prop="staffEmail"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="form.staffEmail"
                placeholder="请输入邮箱"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="24">
            <a-form-model-item
              label="家庭住址"
              prop="staffAddress"
              :labelCol="{ xs: { span: 21 }, sm: { span: 3 } }"
              :wrapperCol="{ xs: { span: 24 }, sm: { span: 16 } }"
              style="width: 116%"
            >
              <a-textarea
                v-model="form.staffAddress"
                type="text"
                :rows="3"
              />
            </a-form-model-item>
          </a-col>
        </a-row>

        <a-divider orientation="center">
          账号安全
        </a-divider>
        <a-row :gutter="2">
          <a-col :span="12">
            <a-form-model-item
              label="用户名"
              prop="userName"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="form.userName"
                placeholder="请输入用户名"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item
              label="新密码"
              prop="userPwd"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input-password
                v-model="form.userPwd"
                placeholder="请输入密码"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="确认密码"
              prop="userPwd1"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input-password
                v-model="form.userPwd1"
                placeholder="请输入确认密码"
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
import UploadModal from './uploadModal'
import { getInfo } from '@/api/loginUser'

export default {
  name: 'PersonalCenter',
  components: {
    UploadModal
  },
  data () {
    return {
      top: 10,
      type: 'add',
      imgUrl: '',
      form: {
        staffId: '',
        staffName: '',
        staffGender: '',
        staffAge: '',
        staffPhone: '',
        staffEmail: '',
        staffAddress: '',
        userName: '',
        userPwd: '',
        userPwd1: ''
      },
      rules: {
        staffId: [
          { required: true, message: '请输入账号', trigger: 'change' }
        ],
        staffName: [
          { required: true, message: '请输入姓名', trigger: 'change' }
        ],
        staffGender: [
          { required: true, message: '请输入性别', trigger: 'change' }
        ],
        staffAge: [
          { required: true, message: '请输入年龄', trigger: 'change' }
        ],
        staffPhone: [
          { required: true, message: '请输入联系电话', trigger: 'change' }
        ],
        staffEmail: [
          { required: true, message: '请输入邮箱', trigger: 'change' }
        ],
        staffAddress: [
          { required: true, message: '请输入地址', trigger: 'change' }
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
  created () {
    this.getData()
  },
  methods: {
    async getData () {
      this.imgUrl = localStorage.getItem('avatar')
      const loginUser = JSON.parse(localStorage.getItem('loginUser'))
      await getInfo(loginUser.staffId).then(res => {
        console.log(res.data)
        this.form = res.data
        this.form.userPwd = ''
      })
    },
    uploadAvatar () {
      this.$refs.uploadModal.paramReceive()
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
    },
    quit () {
      this.$router.push('/elderlyHealthcare/home')
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
  }
  .content{
    padding: 15px;
  }
</style>
