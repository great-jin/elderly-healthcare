<template>
  <a-row style="overflow-x: hidden; overflow-y: auto">
    <a-col :span="6" style="background-color: white">
      <a-tree
        @select="onClick"
        :default-expanded-keys="['0']"
      >
        <a-tree-node
          key="0"
          title="资产名称"
        >
          <a-tree-node
            v-for="item in goodsList"
            :key="item.goodsId"
            :title="item.goodsName"
          />
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
              prop="goodsName"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="formData.goodsName"
                placeholder="商品名称"
                :disabled="true"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="商品类别"
              prop="goodsType"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="formData.goodsType"
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
              prop="goodsPrice"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="formData.goodsPrice"
                placeholder="商品单价"
                :disabled="true"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="采购数量"
              prop="orderCount"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input-number
                v-model="formData.orderCount"
                placeholder="采购数量"
                :min="0"
                style="width: 100%"
                @change="onChange"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="12">
            <a-form-model-item
              label="采购日期"
              prop="orderTime"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-date-picker
                v-model="formData.orderTime"
                placeholder="采购日期"
                style="width: 100%"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="商品总价"
              prop="costCount"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="formData.costCount"
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
import { listGoods, getStorage } from '@/api/warehouseStorage'

export default {
  name: 'form2',
  data () {
    return {
      formData: {
        goodsName: '',
        goodsType: '',
        goodsPrice: 0,
        orderCount: 0,
        orderTime: '',
        costCount: 0
      },
      goodsList: [],
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
  mounted () {
    listGoods().then(res => {
      this.goodsList = res.data
    })
  },
  methods: {
    next (data) {
      this.$refs.modelForm.validate(valid => {
        if (valid) {
          this.$emit('changeData', data)
        }
      })
    },
    onClick (keys) {
      getStorage(keys[0]).then(res => {
        this.formData = res.data
      })
    },
    onChange () {
      const _count = Number(this.formData.orderCount) * Number(this.formData.goodsPrice)
      this.formData.costCount = _count
    }
  }
}
</script>

<style scoped>
</style>
