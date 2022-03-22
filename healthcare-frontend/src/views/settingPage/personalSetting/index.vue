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
          <a-anchor-link href="#components-anchor-demo-basic" title="Basic demo" />
          <a-anchor-link href="#components-anchor-demo-static" title="Static demo" />
          <a-anchor-link
            href="#components-anchor-demo-basic"
            title="Basic demo with Target"
          />
          <!-- target="_blank"-->
          <a-anchor-link href="#API" title="API">
            <a-anchor-link href="#Anchor-Props" title="Anchor Props" />
          </a-anchor-link>
        </a-anchor>
      </a-affix>
    </a-col>

    <a-col :span="20" class="content">
      <div style="overflow-x: hidden">
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
                    { required: true, message: '不能为空' },
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
      </div>
    </a-col>
  </div>
</template>

<script>
export default {
  name: 'PersonalCenter',
  data () {
    return {
      staffInfo: {},
      form: this.$form.createForm(this),
      labelCol: {
        xs: { span: 24 },
        sm: { span: 7 }
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 13 }
      },
      top: 10
    }
  },
  mounted () {
    this.staffInfo = JSON.parse(localStorage.getItem('staffInfo'))
  },
  methods: {
    backHome () {
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
    /*border: #1890ff 2px solid;*/
  }
  .content{
    padding: 15px;
    /*border: #1890ff 2px solid;*/
  }

</style>
