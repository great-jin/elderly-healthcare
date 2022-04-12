<template>
  <a-modal
    :title="type === 'edit' ? '编辑' : '详情'"
    :visible="visible"
    width="40%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="submit" type="primary" @click="ok">确定</a-button>
      <a-button key="back" @click="cancel">取消</a-button>
    </template>

    <a-form-model
      ref="modelForm"
      :model="formData"
      :rules="rules"
    >
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="类型"
            prop="menuType"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.menuType"
              placeholder="请选择联系人"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="图标"
            prop="menuIcon"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.menuIcon"
              placeholder="请选择图标"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="标题"
            prop="menuTitle"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.menuTitle"
              placeholder="请输入标题"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="路由地址"
            prop="routerName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.routerName"
              placeholder="请输入路由地址"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="是否展示"
            prop="isShow"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.isShow"
              placeholder="请输入联系方式"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
        </a-col>
      </a-row>
    </a-form-model>
  </a-modal>
</template>

<script>
export default {
  name: 'InfoModal',
  data () {
    return {
      type: '',
      visible: false,
      formData: {
        menuType: '',
        menuIcon: '',
        menuTitle: '',
        routerName: '',
        isShow: ''
      },
      rules: {
        menuType: [
          { required: true, message: '请输入联系人', trigger: 'change' }
        ],
        menuIcon: [
          { required: true, message: '请输入联系人', trigger: 'change' }
        ],
        menuTitle: [
          { required: true, message: '请输入联系人', trigger: 'change' }
        ],
        routerName: [
          { required: true, message: '请输入联系人', trigger: 'change' }
        ],
        isShow: [
          { required: true, message: '请输入联系人', trigger: 'change' }
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
    paramReceive (type, data) {
      this.type = type
      this.visible = true
      this.formData = data
      console.log(data)
    },
    cancel () {
      this.visible = false
      this.$refs.modelForm.resetFields()
    },
    ok () {
      this.$refs.modelForm.validate(valid => {
        if (valid) {
          this.visible = false
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
