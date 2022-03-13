<template>
  <div>
    <a-divider orientation="center">
     基本信息
    </a-divider>
    <a-form :form="form">
      <a-form-item style="margin: 15px 10px" >
        <a-input
          placeholder="请输入账号"
          v-decorator="[
            'accountID',
            { rules: [{ required: true, message: '账号不能为空!' }] }
          ]"
        >
          <a-icon slot="prefix" type="user" />
        </a-input>
      </a-form-item>
      <a-form-item style="margin: 15px 10px" >
        <a-input-password
          placeholder="请输入密码"
        >
          <a-icon slot="prefix" type="lock" />
        </a-input-password>
      </a-form-item>
      <a-form-item style="margin: 15px 10px" >
        <a-input
          placeholder="请输入验证码"
        />
      </a-form-item>
    </a-form>

    <a-divider orientation="center">
      身体状况
    </a-divider>
    <a-form :form="form">
      <a-form-item style="margin: 15px 10px" >
        <a-input
          placeholder="请输入账号"
        >
          <a-icon slot="prefix" type="user" />
        </a-input>
      </a-form-item>
      <a-form-item style="margin: 15px 10px" >
        <a-input-password
          placeholder="请输入密码"
        >
          <a-icon slot="prefix" type="lock" />
        </a-input-password>
      </a-form-item>
      <a-form-item style="margin: 15px 10px" >
        <a-input
          placeholder="请输入验证码"
        />
      </a-form-item>
    </a-form>
  </div>
</template>


<script>
export default {
  name: "index",
  data() {
    return {
      form: this.$form.createForm(this)
    }
  }
}
</script>

<style scoped>

</style>
