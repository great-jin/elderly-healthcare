<template>
  <div>
    <a-tabs type="card" :activeKey="tabActivity">
      <a-tab-pane key="1" tab="任务大屏">
        <a-button type="primary" @click="changeTab('2')">发布任务</a-button>
        <a-table :columns="columns" :data-source="data">
          <a slot="name" slot-scope="text">{{ text }}</a>
          <span slot="customTitle"><a-icon type="smile-o" /> Name</span>
          <span slot="tags" slot-scope="tags">
          <a-tag
            v-for="tag in tags"
            :key="tag"
            :color="tag === 'loser' ? 'volcano' : tag.length > 5 ? 'geekblue' : 'green'"
          >
            {{ tag.toUpperCase() }}
          </a-tag>
          </span>
          <span slot="action" slot-scope="text, record">
            <a>Delete</a>
            <a-divider type="vertical" />
            <a class="ant-dropdown-link"> More actions <a-icon type="down" /> </a>
          </span>
        </a-table>
      </a-tab-pane>
      <a-tab-pane key="2" tab="任务发布" :disabled="true">
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
                <a-button type="primary" :style="{ marginLeft: '8px' }" @click="PublishTask">保存</a-button>
              </template>
              <template v-if="type === 'add'">
                <a-button type="primary" :style="{ marginLeft: '8px' }" @click="PublishTask">发布</a-button>
              </template>
              <a-button type="primary" :style="{ marginLeft: '8px' }" @click="changeTab('1')">取消</a-button>
            </a-col>
          </a-row>
        </a-form>
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
import { tableColumns, tableData } from "./const"

export default {
  name: "index",
  data() {
    return {
      type: 'add',
      data: [],
      columns: [],
      tabActivity: '1',
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
  mounted() {
    this.data = tableData
    this.columns = tableColumns
  },
  methods: {
    changeTab(data) {
      this.tabActivity = data
    },
    PublishTask() {
      this.tabActivity = '1'
    }
  }
}
</script>

<style scoped>

</style>
