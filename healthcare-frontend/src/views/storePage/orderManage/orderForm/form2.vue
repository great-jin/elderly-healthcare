<template>
  <a-row style="overflow-x: hidden; overflow-y: auto">
    <a-col :span="6" style="background-color: white">
      <a-tree
        :show-line="showLine"
        :show-icon="showIcon"
        :default-expanded-keys="['0-0-0', '0-0-1', '0-0-2']"
      >
        <a-tree-node key="0-0">
          <span slot="title" style="color: #1890ff">parent 1</span>

          <a-tree-node key="0-0-0" title="parent 1-0">
            <a-tree-node key="0-0-0-0" title="leaf"/>
            <a-tree-node key="0-0-0-1" title="leaf"/>
            <a-tree-node key="0-0-0-2" title="leaf"/>
          </a-tree-node>

          <a-tree-node key="0-0-1" title="parent 1-1">
            <a-tree-node key="0-0-1-0" title="leaf"/>
          </a-tree-node>

          <a-tree-node key="0-0-2" title="parent 1-2">
            <a-tree-node key="0-0-2-0" title="leaf"/>
            <a-tree-node key="0-0-2-1" title="leaf"/>
          </a-tree-node>
        </a-tree-node>
      </a-tree>
    </a-col>
    <a-col :span="18">
      <a-form-model
        ref="modelForm"
        :model="formData"
        :rules="rules"
      >
        <a-row>
          <a-col :span="12">
            <a-form-model-item
              label="商品名称"
              prop="userName"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="formData.userName"
                placeholder="商品名称"
                :disabled="true"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="商品类别"
              prop="telephone"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="formData.telephone"
                placeholder="商品类别"
                :disabled="true"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item
              label="商品单价"
              prop="userName"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="formData.userName"
                placeholder="商品单价"
                :disabled="true"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="采购数量"
              prop="telephone"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input-number
                v-model="formData.telephone"
                placeholder="采购数量"
                :min="0"
                style="width: 100%"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item
              label="采购日期"
              prop="userName"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-date-picker
                v-model="formData.userName"
                placeholder="采购日期"
                style="width: 100%"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="商品总价"
              prop="telephone"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="formData.telephone"
                placeholder="商品总价"
                :disabled=true
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-button
          type="primary"
          @click="next(0)"
          style="margin-right: 10px"
        >上一步</a-button>
        <a-button
          type="primary"
          @click="next(2)"
        >提&nbsp;&nbsp;&nbsp;&nbsp;交</a-button>
      </a-form-model>
    </a-col>
  </a-row>
</template>

<script>
export default {
  name: 'form2',
  data () {
    return {
      showLine: true,
      showIcon: false,
      formData: {
        userName: '',
        telephone: '',
        comment: ''
      },
      rules: {},
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
    next (data) {
      this.$refs.modelForm.validate(valid => {
        if (valid) {
          this.$emit('changeData', data)
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
