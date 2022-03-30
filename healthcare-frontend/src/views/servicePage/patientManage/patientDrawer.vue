<template>
  <a-drawer
    title="病人详情"
    width="55%"
    placement="right"
    :closable="true"
    :visible="visible"
    @close="cancel"
  >
    <a-form-model
      ref="ruleForm"
      :model="form"
    >
      <a-row v-if="!this.isMore" >
        <a-col :span="2">
          <a-button type="primary" @click="addBodyInfo">新增</a-button>
        </a-col>
        <a-col :span="22" :style="{ textAlign: 'right' }">
          <a-button type="primary" @click="save">保存</a-button>
        </a-col>
      </a-row>

      <a-divider orientation="center">
        身体状况
      </a-divider>
      <div
        v-for="(item, index) in form.patientBodyInfoList"
        :key="index"
        style="margin-bottom: 20px"
      >
        <a-row :gutter="2">
          <a-col :span="12">
            <a-form-model-item
              label="体温"
              :prop="`patientBodyInfoList.${index}.bodyTemper`"
              :rules="[{ required: true, message: '不能为空', trigger:['change', 'blur'] }]"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="item.bodyTemper"
                placeholder="请输入体温"
                suffix="℃"
                :allowClear="true"
                :disabled="isMore"
                style="width: 100%"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="心率"
              :prop="`patientBodyInfoList.${index}.heartBeat`"
              :rules="[{ required: true, message: '不能为空', trigger:['change', 'blur'] }]"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="item.heartBeat"
                placeholder="请输入心率"
                suffix="/min"
                :allowClear="true"
                :disabled="isMore"
                style="width: 100%"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row :gutter="2">
          <a-col :span="12">
            <a-form-model-item
              label="血压"
              :prop="`patientBodyInfoList.${index}.bloodPressure`"
              :rules="[{ required: true, message: '不能为空', trigger:['change', 'blur'] }]"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="item.bloodPressure"
                placeholder="请输入血压"
                suffix="mmHg"
                :maxLength="25"
                :allowClear="true"
                :disabled="isMore"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="血糖"
              :prop="`patientBodyInfoList.${index}.bloodGlucose`"
              :rules="[{ required: true, message: '不能为空', trigger:['change', 'blur'] }]"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="item.bloodGlucose"
                placeholder="请输入血糖"
                :allowClear="true"
                :disabled="isMore"
                :maxLength="25"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row :gutter="2">
          <a-col :span="12">
            <a-form-model-item
              label="血脂"
              :prop="`patientBodyInfoList.${index}.bloodFat`"
              :rules="[{ required: true, message: '不能为空', trigger:['change', 'blur'] }]"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="item.bloodFat"
                placeholder="请输入血脂"
                suffix="mmo/L"
                :maxLength="25"
                :allowClear="true"
                :disabled="isMore"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="12">
            <a-form-model-item
              label="登记时间"
              :prop="`patientBodyInfoList.${index}.inTime`"
              :rules="[{ required: true, message: '不能为空', trigger:['change', 'blur'] }]"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-date-picker
                v-model="item.inTime"
                placeholder="请选择登记时间"
                :disabled="isMore"
                style="width: 100%"
              />
            </a-form-model-item>
          </a-col>
        </a-row>
        <a-row>
          <a-col :span="18">
            <a-form-model-item
              label="详情"
              :prop="`patientBodyInfoList.${index}.bodyDetail`"
              :rules="[{ required: true, message: '不能为空', trigger:['change', 'blur'] }]"
              :labelCol="{ xs: { span: 20 }, sm: { span: 4 } }"
              :wrapperCol="{ xs: { span: 24 }, sm: { span: 16 } }"
              style="width: 116%"
            >
              <a-textarea
                v-model="item.bodyDetail"
                placeholder="请输入详情"
                type="text"
                :rows="4"
                :disabled="isMore"
              />
            </a-form-model-item>
          </a-col>
          <a-col
            v-if="!isMore"
            :span="2"
            style="display: inline-block; line-height: 98px; padding-left: 15%"
          >
            <a-icon
              type="minus-circle-o"
              @click="() => remove(item)"
              class="dynamic-delete-button"
            />
          </a-col>
        </a-row>
      </div>
    </a-form-model>
  </a-drawer>
</template>

<script>
import { listBodyInfo, addBatchInfo } from '@/api/patientBodyInfo'

export default {
  name: 'CaseInfo',
  data () {
    return {
      type: '',
      visible: false,
      isMore: false,
      isEdit: false,
      form: {
        patientId: '',
        patientBodyInfoList: []
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
      this.form.patientId = data.patientId
      this.type = type
      this.visible = true
      if (type === 'more') {
        this.isMore = true
        this.getData()
      }
      if (type === 'edit') {
        this.isEdit = true
      }
    },
    getData () {
      const patientId = this.form.patientId
      listBodyInfo(patientId).then(res => {
        this.form.patientBodyInfoList = res.data
      })
    },
    save () {
      this.$refs.ruleForm.validate(valid => {
        if (valid) {
          addBatchInfo(this.form).then(res => {
            if (res.data > 0) {
              this.$message.success('信息新增成功')
              this.cancel()
            } else {
              this.$message.success('信息新增失败')
            }
          })
        }
      })
    },
    cancel () {
      this.visible = false
      this.isMore = false
      this.isEdit = false
      this.$refs.ruleForm.resetFields()
      this.form.patientId = ''
      this.form.patientBodyInfoList = []
    },
    addBodyInfo () {
      this.form.patientBodyInfoList.push({
        uuid: this.guid(),
        bodyTemper: '',
        heartBeat: '',
        bloodPressure: '',
        bloodGlucose: '',
        bloodFat: '',
        inTime: '',
        bodyDetail: ''
      })
    },
    remove (item) {
      this.form.patientBodyInfoList = this.form.patientBodyInfoList.filter(op => (op.uuid !== item.uuid))
    },
    guid () {
      return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        const r = Math.random() * 16 | 0
        const v = c === 'x' ? r : (r & 0x3 | 0x8)
        return v.toString(16)
      })
    }
  }
}
</script>

<style scoped>
</style>
