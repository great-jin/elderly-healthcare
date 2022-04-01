<template>
  <a-drawer
    title="登记详情"
    width="55%"
    placement="right"
    :closable="true"
    :visible="visible"
    @close="cancel"
  >
    <a-form-model
      ref="registerForm"
      :model="form"
      :rules="rules"
    >
      <a-divider orientation="center">
        基本信息
      </a-divider>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="姓名"
            prop="patientName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientName"
              placeholder="请输入姓名"
              :maxLength="25"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="性别"
            prop="patientGender"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-select
              v-model="form.patientGender"
              placeholder="请选择性别"
              :default-value="undefined"
              :allowClear="true"
              style="width: 100%"
            >
              <a-select-option value="男">男</a-select-option>
              <a-select-option value="女">女</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="年龄"
            prop="patientAge"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input-number
              v-model="form.patientAge"
              placeholder="请输入年龄"
              :min="1"
              :max="100"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="身高"
            prop="patientHeight"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientHeight"
              placeholder="请输入身高"
              suffix="CM"
              :allowClear="true"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="体重"
            prop="patientWeight"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientWeight"
              placeholder="请输入体重"
              suffix="KG"
              :allowClear="true"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="登记时间"
            prop="inTime"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-date-picker
              v-model="form.inTime"
              placeholder="请选择登记时间"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="联系电话"
            prop="patientPhone"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientPhone"
              placeholder="请输入联系电话"
              :allowClear="true"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="家庭住址"
            prop="patientAddress"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientAddress"
              placeholder="请输入家庭住址"
              :allowClear="true"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item
            label="备注"
            prop="comment"
            :labelCol="{ xs: { span: 21 }, sm: { span: 3 } }"
            :wrapperCol="{ xs: { span: 24 }, sm: { span: 16 } }"
            style="width: 116%"
          >
            <a-textarea
              v-model="form.comment"
              type="text"
              :rows="4"
            />
          </a-form-model-item>
        </a-col>
      </a-row>

      <a-divider orientation="center">
        身体状况
      </a-divider>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="体温"
            prop="bodyTemper"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.bodyTemper"
              placeholder="请输入体温"
              suffix="℃"
              :allowClear="true"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="心率"
            prop="heartBeat"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.heartBeat"
              placeholder="请输入心率"
              suffix="/min"
              :allowClear="true"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="血压"
            prop="bloodPressure"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.bloodPressure"
              placeholder="请输入血压"
              suffix="mmHg"
              :maxLength="25"
              :allowClear="true"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="血糖"
            prop="bloodGlucose"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.bloodGlucose"
              placeholder="请输入血糖"
              :allowClear="true"
              :maxLength="25"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="血脂"
            prop="bloodFat"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.bloodFat"
              placeholder="请输入血脂"
              suffix="mmo/L"
              :maxLength="25"
              :allowClear="true"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="左眼视力"
            prop="eyeLeft"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input-number
              v-model="form.eyeLeft"
              placeholder="请输入左眼视力"
              :min="30"
              :max="200"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row :gutter="2">
        <a-col :span="12">
          <a-form-model-item
            label="右眼视力"
            prop="eyeRight"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input-number
              v-model="form.eyeRight"
              placeholder="请输入右眼视力"
              :min="30"
              :max="200"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item
            label="详情描述"
            prop="bodyDetail"
            :labelCol="{ xs: { span: 21 }, sm: { span: 3 } }"
            :wrapperCol="{ xs: { span: 24 }, sm: { span: 16 } }"
            style="width: 116%"
          >
            <a-textarea
              v-model="form.bodyDetail"
              placeholder="请输入详情描述"
              type="text"
              :rows="6"
            />
          </a-form-model-item>
        </a-col>
      </a-row>

      <a-divider orientation="center">
        紧急联系人
      </a-divider>
      <div>
        <a-row style="margin-bottom: 15px; margin-left: 5px">
          <a-col :span="12">
            <a-button type="primary" @click="addContact">新增</a-button>
          </a-col>
        </a-row>
        <a-row
          :gutter="2"
          v-for="(item, index) in form.contactList"
          :key="index"
          style="margin-bottom: 15px"
        >
          <a-col :span="11">
            <a-form-model-item
              label="联系人"
              :prop="`contactList.${index}.contactName`"
              :rules="[{ required: true, message: '联系人不能为空', trigger:['change', 'blur'] }]"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="item.contactName"
                placeholder="请输入联系人"
                :allowClear="true"
                :maxLength="25"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="11">
            <a-form-model-item
              label="联系方式"
              :prop="`contactList.${index}.contactPhone`"
              :rules="[{ required: true, message: '联系方式不能为空', trigger:['change', 'blur'] }]"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-input
                v-model="item.contactPhone"
                placeholder="请输入联系方式"
                :allowClear="true"
                :maxLength="25"
              />
            </a-form-model-item>
          </a-col>
          <a-col :span="2">
            <a-icon
              type="minus-circle-o"
              @click="() => remove(item)"
              class="dynamic-delete-button"
            />
          </a-col>
        </a-row>
      </div>
      <div :style="{ marginTop: '40px' }">
        <a-row>
          <a-col :span="24" :style="{ textAlign: 'center' }">
            <a-button type="primary" @click="ok">保存</a-button>
            <a-button type="primary" :style="{ marginLeft: '50px' }" @click="cancel">取消</a-button>
          </a-col>
        </a-row>
      </div>
    </a-form-model>
  </a-drawer>
</template>

<script>
import { listPatientInfo } from '@/api/patientInfo'
import { listPatientContact } from '@/api/patientContact'

export default {
  name: 'UserModal',
  data () {
    return {
      type: '',
      visible: false,
      form: {
        patientName: '',
        patientGender: undefined,
        patientAge: '',
        patientHeight: '',
        patientWeight: '',
        inTime: '',
        patientPhone: '',
        patientAddress: '',
        comment: '',

        bodyTemper: '',
        heartBeat: '',
        bloodPressure: '',
        bloodGlucose: '',
        bloodFat: '',
        eyeLeft: '',
        eyeRight: '',
        bodyDetail: '',
        contactList: []
      },
      rules: {
        patientName: [
          { required: true, message: '请输入姓名', trigger: 'change' }
        ],
        patientGender: [
          { required: true, message: '请输入性别', trigger: 'change' }
        ],
        patientAge: [
          { required: true, message: '请输入年龄', trigger: 'change' }
        ],
        patientHeight: [
          { required: true, message: '请输入身高', trigger: 'change' }
        ],
        patientWeight: [
          { required: true, message: '请输入体重', trigger: 'change' }
        ],
        inTime: [
          { required: true, message: '请输入体重', trigger: 'change' }
        ],
        patientPhone: [
          { required: true, message: '请输入联系电话', trigger: 'change' }
        ],
        patientAddress: [
          { required: true, message: '请输入籍贯住址', trigger: 'change' }
        ],
        bodyTemper: [
          { required: true, message: '请输入体温', trigger: 'change' }
        ],
        heartBeat: [
          { required: true, message: '请输入心率', trigger: 'change' }
        ],
        bloodPressure: [
          { required: true, message: '请输入血压', trigger: 'change' }
        ],
        bloodGlucose: [
          { required: true, message: '请输入血糖', trigger: 'change' }
        ],
        bloodFat: [
          { required: true, message: '请输入血脂', trigger: 'change' }
        ],
        eyeLeft: [
          { required: true, message: '请输入左眼视力', trigger: 'change' }
        ],
        eyeRight: [
          { required: true, message: '请输入右眼视力', trigger: 'change' }
        ],
        bodyDetail: [
          { required: true, message: '请输入身体状况', trigger: 'blur' },
          { min: 3, max: 300, message: '长度在 1 到 300 个字符', trigger: 'blur' }
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
      this.getData(data.patientId)
    },
    getData (data) {
      const object = {
        patientId: data
      }
      listPatientInfo(object).then(res => {
        this.form = res.data[0]
      })
      listPatientContact(object).then(res => {
        this.form.contactList = res.data
      })
    },
    cancel () {
      this.visible = false
      this.$refs.registerForm.resetFields()
    },
    ok () {
      const _len = this.form.contactList.length
      if (_len > 0) {
        this.$refs.registerForm.validate(valid => {
          if (valid) {
            console.log(this.form)
          }
        })
      } else {
        this.$message.error('至少添加一个紧急联系人')
      }
    },
    addContact () {
      this.form.contactList.push({
        uuid: this.guid(),
        contactName: '',
        contactPhone: ''
      })
    },
    remove (item) {
      this.form.contactList = this.form.contactList.filter(op => (op.uuid !== item.uuid))
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
