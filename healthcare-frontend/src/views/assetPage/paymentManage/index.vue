<template>
  <div>
    <a-form-model
      ref="unitForm"
      :model="formDate"
    >
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="用户名"
            prop="userName"
            :rules="[{ required: true, message: '用户名不能为空' }]"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formDate.userName"
              placeholder="请输入联系人"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="用户代理"
            prop="userAgent"
            :rules="[{ required: true, message: '用户代理不能为空' }]"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formDate.userAgent"
              placeholder="请输入用户代理"
            />
          </a-form-model-item>
        </a-col>
      </a-row>

      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="联系人"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
            class="required"
          >
            <a-button type="link" @click="addContact">新增</a-button>
            <a-button type="link" @click="ok">完成</a-button>
          </a-form-model-item>
        </a-col>
      </a-row>

      <a-row
        v-for="(item, index) in formDate.contactList"
        :key="index"
        style="margin-bottom: 15px"
      >
        <a-col :span="3" />
        <a-col :span="7">
          <a-form-model-item
            label="姓名"
            :prop="`contactList.${index}.contactName`"
            :rules="[{ required: true, message: '姓名不能为空' }]"
            :label-col="formItemLayout.labelCol"
            :wrapper-col="formItemLayout.wrapperCol"
          >
            <a-input
              placeholder="请输入姓名"
              v-model="item.contactName"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="7">
          <a-form-model-item
            label="联系电话"
            :prop="`contactList.${index}.telephone`"
            :rules="[{ required: true, message: '联系电话不能为空' }]"
            :label-col="formItemLayout.labelCol"
            :wrapper-col="formItemLayout.wrapperCol"
          >
            <a-input
              placeholder="请输入电话"
              v-model="item.telephone"
            />
          </a-form-model-item>
        </a-col>
        <a-icon
          type="minus-circle-o"
          @click="() => remove(item)"
          class="dynamic-delete-button"
        />
      </a-row>
    </a-form-model>
  </div>
</template>

<script>
export default {
  name: 'index',
  data () {
    return {
      formDate: {
        userName: '',
        userAgent: '',
        contactList: []
      },
      labelCol: {
        xs: { span: 24 },
        sm: { span: 7 }
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 13 }
      },
      formItemLayout: {
        labelCol: { span: 7 },
        wrapperCol: { span: 14 }
      }
    }
  },
  methods: {
    ok () {
      this.$refs.unitForm.validate(valid => {
        if (valid) {
          console.log(this.formDate)
        }
      })
    },
    cancel () {
      this.formDate.contactList = []
      this.$refs.unitForm.resetFields()
    },
    addContact () {
      this.formDate.contactList.push({
        uuid: this.guid(),
        contactName: '',
        telephone: ''
      })
    },
    remove (item) {
      this.formDate.contactList = this.formDate.contactList.filter(op => (op.uuid !== item.uuid))
    },
    guid () {
      return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        var r = Math.random() * 16 | 0
        var v = c === 'x' ? r : (r & 0x3 | 0x8)
        return v.toString(16)
      })
    }
  }
}
</script>

<style>
  .required .ant-form-item-label label::before {
    content: '*';
    line-height: 1;
    display: inline-block;
    margin-right: 4px;
    color: #f5222d;
    font-size: 14px;
    font-family: SimSun, sans-serif;
  }
</style>
