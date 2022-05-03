<template>
  <a-modal
    :title="type === 'more' ? '资产详情' : '更新药品'"
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
            label="药品编号"
            prop="drugId"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.drugId"
              :disabled="true"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="药品名称"
            prop="drugName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.drugName"
              placeholder="请输入药品名称"
              :disabled="isDisabled"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="药品类别"
            prop="drugType"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.drugType"
              placeholder="请输入药品类别"
              :disabled="isDisabled"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="药品单价"
            prop="drugPrice"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="formData.drugPrice"
              placeholder="请输入药品单价"
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
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="过期时间"
            prop="overdueTime"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-date-picker
              v-model="formData.overdueTime"
              placeholder="过期时间"
              :disabled="isDisabled"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="是否过期"
            prop="isOverdue"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-date-picker
              v-model="formData.isOverdue"
              placeholder="请选择是否过期"
              :disabled="isDisabled"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
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
import { updateMedicineCatalog } from '@/api/medicineCatalog'

export default {
  name: 'drugModal',
  data () {
    return {
      type: '',
      visible: false,
      isDisabled: false,
      staffList: [],
      formData: {
        drugId: '',
        drugName: '',
        drugType: '',
        drugPrice: '',
        goodsCount: '',
        warnLine: '',
        produceTime: '',
        overdueTime: '',
        isOverdue: 0,
        produceVendor: '',
        comment: ''
      },
      rules: {
        drugId: [
          { required: true, message: '编号不能为空', trigger: 'change' }
        ],
        drugName: [
          { required: true, message: '名称不能为空', trigger: 'change' }
        ],
        drugType: [
          { required: true, message: '类别不能为空', trigger: 'change' }
        ],
        drugPrice: [
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
        overdueTime: [
          { required: true, message: '购买日期不能为空', trigger: 'change' }
        ],
        isOverdue: [
          { required: true, message: '购买人不能为空', trigger: 'change' }
        ],
        produceVendor: [
          { required: true, message: '生产厂商不能为空', trigger: 'change' }
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
      if (type === 'more') {
        this.isDisabled = true
      }
      this.formData = data
      this.formData.drugId = data.drugId.substring(0, 8)
    },
    cancel () {
      this.isDisabled = false
      this.visible = false
    },
    ok () {
      this.$refs.modelForm.validate(valid => {
        if (valid) {
          updateMedicineCatalog(this.formData).then(res => {
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
