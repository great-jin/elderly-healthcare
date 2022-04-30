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
        <a-form-model-item
          label="路由标题"
          prop="menuTitle"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
        >
          <a-input
            v-model="formData.menuTitle"
            placeholder="请输入标题"
          />
        </a-form-model-item>
      </a-row>
      <a-row>
        <a-form-model-item
          label="路由类型"
          prop="menuType"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
        >
          <a-input
            v-model="formData.menuType"
            placeholder="请选择类型"
          />
        </a-form-model-item>
      </a-row>
      <a-row>
        <a-form-model-item
          label="路由图标"
          prop="menuIcon"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
        >
          <a-select
            v-model="formData.menuIcon"
            placeholder="请选择图标"
            :allowClear="true"
            :style="{width: '100%'}"
          >
            <a-select-option
              v-for="icon in iconList"
              :key="icon"
              :value="icon"
            >
              <a-icon :type="icon" />
              &nbsp;
              <span>{{ icon }}</span>
            </a-select-option>
          </a-select>
        </a-form-model-item>
      </a-row>
      <a-row>
        <a-form-model-item
          label="是否展示"
          prop="isShow"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
        >
          <a-radio-group
            v-model="formData.isShow"
          >
            <a-radio :value="1">是</a-radio>
            <a-radio :value="2">否</a-radio>
          </a-radio-group>
        </a-form-model-item>
      </a-row>
      <a-row>
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
      iconList: ['question','plus-circle'],
      formData: {
        menuTitle: '',
        menuType: '',
        menuIcon: undefined,
        isShow: '',
        routerName: ''
      },
      rules: {
        menuTitle: [
          { required: true, message: '请输入标题', trigger: 'change' }
        ],
        menuType: [
          { required: true, message: '请输入类型', trigger: 'change' }
        ],
        routerName: [
          { required: true, message: '请输入路径', trigger: 'change' }
        ],
        isShow: [
          { required: true, message: '请选择是否展示', trigger: 'change' }
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
    },
    cancel () {
      this.visible = false
      this.$refs.modelForm.resetFields()
    },
    ok () {
      this.$refs.modelForm.validate(valid => {
        if (valid) {
          console.log(this.formData)
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
