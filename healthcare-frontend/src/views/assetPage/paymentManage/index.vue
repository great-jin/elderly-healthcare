<template>
  <div>
    <a-form
      :form="form"
      :label-col="labelCol"
      :wrapper-col="wrapperCol"
    >
      <a-form-item label="联系人" class="required">
        <a-button type="link" style="margin-right: 30px" @click="addReport">新增</a-button>
        <a-button type="link" style="margin-right: 30px" @click="ok">完成</a-button>
      </a-form-item>
      <div
        v-for="(item, index) in dynamicInfo"
        :key="index"
        style="margin-bottom: 15px; margin-left: 50px"
      >
        <a-row>
          <a-col :span="2" />
          <a-col :span="7">
            <a-form-item
              label="姓名"
              :label-col="formItemLayout.labelCol"
              :wrapper-col="formItemLayout.wrapperCol"
              :prop="`dynamicInfo.${index}.userName`"
              class="required"
            >
              <a-input
                placeholder="请输入姓名"
                v-decorator="[
                    `${index}.userName`,
                    { rules: [{ required: false, message: '姓名不能为空' }] }
                  ]"
              />
            </a-form-item>
          </a-col>
          <a-col :span="7">
            <a-form-item
              label="联系电话"
              :label-col="formItemLayout.labelCol"
              :wrapper-col="formItemLayout.wrapperCol"
              :prop="`dynamicInfo.${index}.telephone`"
              class="required"
            >
              <a-input
                placeholder="请输入电话"
                v-decorator="[
                    `${index}.telephone`,
                    { rules: [{ required: false, message: '电话不能为空' }] }
                  ]"
                class="required"
              />
            </a-form-item>
          </a-col>
          <a-icon
            class="dynamic-delete-button"
            type="minus-circle-o"
            @click="() => remove(item)"
          />
        </a-row>
      </div>
    </a-form>
  </div>
</template>

<script>
export default {
  name: 'index',
  data () {
    return {
      dynamicInfo: [
        {
          userName: '',
          telephone: ''
        }
      ],
      labelCol: { span: 4 },
      wrapperCol: { span: 14 },
      formItemLayout: {
        labelCol: { span: 7 },
        wrapperCol: { span: 14 }
      },
      form: this.$form.createForm(this)
    }
  },
  methods: {
    ok () {
      this.form.validateFields((errors, values) => {
        if (!errors) {
          console.log(values)
        }
      })
    },
    cancel () {
      this.dynamicInfo = []
      this.form.resetFields()
    },
    guid () {
      return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        var r = Math.random() * 16 | 0
        var v = c === 'x' ? r : (r & 0x3 | 0x8)
        return v.toString(16)
      })
    },
    addReport () {
      this.dynamicInfo.push({
        uuid: this.guid(),
        userName: '',
        telephone: ''
      })
    },
    remove (item) {
      console.log('item', item)
      this.dynamicInfo = this.dynamicInfo.filter(op => (op.uuid !== item.uuid))
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
