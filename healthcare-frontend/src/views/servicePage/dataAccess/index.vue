<template>
  <div>
    <a-tabs type="card" @change="callback">
      <a-tab-pane key="1" tab="入住登记">
        <a-form :form="form">
          <a-divider orientation="center">
            基本信息
          </a-divider>
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
          <a-divider orientation="center">
            身体状况
          </a-divider>
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
            <a-col :span="24" :style="{ textAlign: 'center' }">
              <template v-if="type === 'edit'">
                <a-button type="primary" :style="{ marginLeft: '8px' }">保存 </a-button>
              </template>
              <template v-if="type === 'add'">
                <a-button
                  type="primary"
                  :style="{ marginLeft: '8px' }"
                >下一步
                </a-button>
                <a-button type="primary" :style="{ marginLeft: '8px' }">保存 </a-button>
              </template>
              <a-button type="primary" :style="{ marginLeft: '8px' }">取消 </a-button>
            </a-col>
          </a-row>
        </a-form>
      </a-tab-pane>
      <a-tab-pane key="2" tab="登记信息">
        Content of Tab Pane 2
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      type: 'add',
      labelCol: {
        xs: { span: 24 },
        sm: { span: 7 }
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 13 }
      },
      form: this.$form.createForm(this)
    }
  },
  methods: {
    callback(key) {
      console.log(key);
    },
  }
}
</script>

<style scoped>

</style>
