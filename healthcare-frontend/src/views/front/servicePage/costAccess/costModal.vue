<template>
  <a-modal
    title="消费信息"
    :visible="visible"
    width="35%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="submit" type="primary" @click="ok">确定</a-button>
      <a-button key="back" @click="cancel">取消</a-button>
    </template>
    <a-form-model
      ref="modelForm"
      :model="costInfo"
      :rules="rules"
    >
      <a-form-model-item
        label="产品名称"
        prop="goodsName"
        :labelCol="formLayout.labelCol"
        :wrapperCol="formLayout.wrapperCol"
      >
        <a-input-number
          v-model="costInfo.goodsName"
          :disabled="true"
          style="width: 100%"
        />
      </a-form-model-item>
      <a-form-model-item
        label="产品单价"
        prop="goodsPrice"
        :labelCol="formLayout.labelCol"
        :wrapperCol="formLayout.wrapperCol"
      >
        <a-input-number
          v-model="costInfo.goodsPrice"
          :disabled="true"
          style="width: 100%"
        />
      </a-form-model-item>
      <a-form-model-item
        label="消费数量"
        prop="goodsNumber"
        :labelCol="formLayout.labelCol"
        :wrapperCol="formLayout.wrapperCol"
      >
        <a-input-number
          v-model="costInfo.goodsNumber"
          @change="changeCount"
          :min="0"
          style="width: 100%"
        />
      </a-form-model-item>
      <a-form-model-item
        label="合计金额"
        prop="costCount"
        :labelCol="formLayout.labelCol"
        :wrapperCol="formLayout.wrapperCol"
      >
        <a-input-number
          v-model="costInfo.costCount"
          :disabled="true"
          style="width: 100%"
        />
      </a-form-model-item>
    </a-form-model>
  </a-modal>
</template>

<script>
import { getCostDetail } from '@/api/patientCostDetail'

export default {
  name: 'CostModal',
  data () {
    return {
      type: '',
      visible: false,
      costInfo: {
        goodsName: '',
        goodsType: '',
        goodsPrice: '',
        goodsNumber: 0,
        costCount: 0
      },
      rules: {
        goodsName: [
          { required: true, message: '不能为空', trigger: 'change' }
        ],
        goodsPrice: [
          { required: true, message: '不能为空', trigger: 'change' }
        ],
        goodsNumber: [
          { required: true, message: '不能为空', trigger: 'change' }
        ],
        costCount: [
          { required: true, message: '不能为空', trigger: 'change' }
        ]
      },
      formLayout: {
        labelCol: { span: 7 },
        wrapperCol: { span: 14 }
      }
    }
  },
  methods: {
    paramReceive (data) {
      this.visible = true
      getCostDetail(data).then(res => {
        this.costInfo = res.data
      })
    },
    ok () {
      this.$refs.modelForm.validate(valid => {
        if (valid) {
          this.$message.success('ok')
        }
      })
    },
    cancel () {
      this.visible = false
    },
    changeCount (value) {
      this.costInfo.costCount = Number(this.costInfo.goodsPrice) * Number(value)
    }
  }
}
</script>

<style scoped>
</style>
