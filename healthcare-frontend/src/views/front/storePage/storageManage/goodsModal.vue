<template>
  <a-modal
    :title="type === 'more' ? '资产详情' : '更新资产'"
    :visible="visible"
    width="60%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="back" @click="cancel">取消</a-button>
      <a-button
        v-if="!isDisabled"
        key="submit"
        type="primary"
        @click="ok"
      >确定
      </a-button>
    </template>
    <a-form-model
      ref="modelForm"
      :model="formData"
      :rules="rules"
    >
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="资产编号"
            prop="goodsId"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.goodsId"
              :disabled="true"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="资产名称"
            prop="goodsName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.goodsName"
              placeholder="请输入资产名称"
              :disabled="isDisabled"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="资产类别"
            prop="goodsType"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.goodsType"
              placeholder="请输入资产类别"
              :disabled="isDisabled"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="资产单价"
            prop="goodsPrice"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.goodsPrice"
              placeholder="请输入资产单价"
              :disabled="isDisabled"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="库存数量"
            prop="goodsCount"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.goodsCount"
              placeholder="请输入库存数量"
              :disabled="isDisabled"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="预警线"
            prop="warnLine"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.warnLine"
              placeholder="请输入库存预警线"
              :disabled="isDisabled"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="生产日期"
            prop="produceTime"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-date-picker
              v-model="formData.produceTime"
              placeholder="请选择生产日期"
              :disabled="isDisabled"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="购买日期"
            prop="purchaseTime"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-date-picker
              v-model="formData.purchaseTime"
              placeholder="请选择购买日期"
              :disabled="isDisabled"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="购买人"
            prop="purchaseStaff"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-select
              v-model="formData.purchaseStaff"
              :allowClear="true"
              placeholder="请选择购买人"
              :disabled="isDisabled"
              style="width: 100%"
            >
              <a-select-option
                v-for="item in staffList"
                :key="item"
                :value="item"
              >{{ item }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="生产厂商"
            prop="produceVendor"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.produceVendor"
              placeholder="请输入生产厂商"
              :disabled="isDisabled"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item
            label="详情备注"
            prop="comment"
            :labelCol="{ xs: { span: 21 }, sm: { span: 3 } }"
            :wrapperCol="{ xs: { span: 24 }, sm: { span: 16 } }"
            style="width: 116%"
          >
            <a-textarea
              v-model="formData.comment"
              type="text"
              :disabled="isDisabled"
              :rows="4"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
    </a-form-model>
  </a-modal>
</template>

<script>
import {listOrganizeStaff} from '@/api/organizeStaff'
import {updateStorage} from '@/api/warehouseStorage'

export default {
  name: 'GoodsModal',
  data() {
    return {
      type: '',
      visible: false,
      isDisabled: false,
      staffList: [],
      formData: {
        goodsId: '',
        goodsName: '',
        goodsType: '',
        goodsPrice: '',
        goodsCount: '',
        warnLine: '',
        produceTime: '',
        purchaseTime: '',
        purchaseStaff: undefined,
        produceVendor: '',
        comment: ''
      },
      rules: {
        goodsId: [
          { required: true, message: '编号不能为空', trigger: 'change' }
        ],
        goodsName: [
          { required: true, message: '名称不能为空', trigger: 'change' }
        ],
        goodsType: [
          { required: true, message: '类别不能为空', trigger: 'change' }
        ],
        goodsPrice: [
          { required: true, message: '单价不能为空', trigger: 'change' }
        ],
        goodsCount: [
          { required: true, message: '库存不能为空', trigger: 'change' }
        ],
        warnLine: [
          { required: true, message: '预警线不能为空', trigger: 'change' }
        ],
        produceTime: [
          { required: true, message: '生产日期不能为空', trigger: 'change' }
        ],
        purchaseTime: [
          { required: true, message: '购买日期不能为空', trigger: 'change' }
        ],
        purchaseStaff: [
          { required: true, message: '购买人不能为空', trigger: 'change' }
        ],
        produceVendor: [
          { required: true, message: '生产厂商不能为空', trigger: 'change' }
        ]
      },
      labelCol: {
        xs: {span: 24},
        sm: {span: 7}
      },
      wrapperCol: {
        xs: {span: 24},
        sm: {span: 13}
      }
    }
  },
  methods: {
    paramReceive(type, data) {
      this.type = type
      this.visible = true
      if (type === 'more') {
        this.isDisabled = true
      }
      this.formData = data
      this.formData.goodsId = data.goodsId.substring(0, 8)
      this.getData()
    },
    async getData() {
      let _list = []
      await listOrganizeStaff().then(res => {
        _list = res.data
      })
      _list = _list.map(item => item.staffName)
      this.staffList = _list.filter(function (element, index, array) {
        return array.indexOf(element) === index
      })
    },
    cancel() {
      this.isDisabled = false
      this.visible = false
    },
    ok() {
      this.$refs.modelForm.validate(valid => {
        if (valid) {
          updateStorage(this.formData).then(res => {
            if (res.data) {
              this.$message.success('修改成功')
              this.cancel()
            } else {
              this.$message.error('编辑失败，请重试')
            }
          })
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
