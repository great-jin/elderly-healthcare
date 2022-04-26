<template>
  <a-drawer
    title="登记详情"
    width="45%"
    placement="right"
    :closable="true"
    :visible="visible"
    @close="cancel"
  >
    <a-form-model
      ref="registerForm"
      :model="form"
      :rules="rules"
      :disabled="isMore"
      style="overflow-x: hidden"
    >
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="账号"
            prop="patientName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientName"
              placeholder="请输入姓名"
              :disabled="isMore"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="姓名"
            prop="patientGender"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientGender"
              placeholder="请选择性别"
              :disabled="isMore"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="部门"
            prop="patientName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientName"
              placeholder="请输入姓名"
              :disabled="isMore"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="职位"
            prop="patientGender"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientGender"
              placeholder="请选择性别"
              :disabled="isMore"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="性别"
            prop="patientName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientName"
              placeholder="请输入姓名"
              :disabled="isMore"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="年龄"
            prop="patientGender"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientGender"
              placeholder="请选择性别"
              :disabled="isMore"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="电话"
            prop="patientName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientName"
              placeholder="请输入姓名"
              :disabled="isMore"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="邮箱"
            prop="patientGender"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientGender"
              placeholder="请选择性别"
              :disabled="isMore"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="入职时间"
            prop="patientName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientName"
              placeholder="请输入姓名"
              :disabled="isMore"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="12">
          <a-form-model-item
            label="是否离职"
            prop="patientName"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientName"
              placeholder="请输入姓名"
              :disabled="isMore"
            />
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-form-model-item
            label="离职时间"
            prop="patientGender"
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
          >
            <a-input
              v-model="form.patientGender"
              placeholder="请选择性别"
              :disabled="isMore"
              style="width: 100%"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
      <a-row>
        <a-col :span="24">
          <a-form-model-item
            label="家庭住址"
            prop="comment"
            :labelCol="{ xs: { span: 21 }, sm: { span: 3 } }"
            :wrapperCol="{ xs: { span: 24 }, sm: { span: 16 } }"
            style="width: 116%"
          >
            <a-textarea
              v-model="form.comment"
              type="text"
              :disabled="isMore"
              :rows="1"
            />
          </a-form-model-item>
        </a-col>
      </a-row>
    </a-form-model>
  </a-drawer>
</template>

<script>
export default {
  name: 'InfoDrawer',
  data () {
    return {
      type: '',
      visible: false,
      isMore: false,
      form: {

      },
      rules: {
        patientName: [
          { required: true, message: '请输入姓名', trigger: 'change' }
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
        this.isMore = true
      }
      console.log(data)
    },
    getData () {
    },
    cancel () {
      this.visible = false
      this.isMore = false
    },
    ok () {
    }
  }
}
</script>

<style scoped>
</style>
