<template>
  <div class="login-container">
<!--    <h2 class="login-title">Elderly Healthcare</h2>-->

    <a-form class="login-form" :form="form">
<!--      <h3 class="title">欢迎登录</h3>-->

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
          v-decorator="[
            'password',
            { rules: [{ required: true, message: '密码不能为空!' }] }
          ]"
        >
          <a-icon slot="prefix" type="lock" />
        </a-input-password>
      </a-form-item>
      <a-form-item style="margin: 15px 10px" >
        <a-input
          style="width: 62%;"
          placeholder="请输入验证码"
          v-decorator="[
            'authCode',
            { rules: [{ required: true, message: '验证码不能为空!' }] }
          ]"
        >
          <a-icon slot="prefix" type="lock" />
        </a-input>
        <span @click="refreshCode()">
          <s-identify :identifyCode="generateCode" ></s-identify>
        </span>
      </a-form-item>
      <a-form-item style="margin: 15px 10px 15px 10px" >
        <a-button class="submit" type="primary" @click="submit">登录</a-button>
      </a-form-item>
      <a-form-item>
        <a-button type="link"
                  style="float: left; z-index: 1;"
                  @click="register"
        >注册</a-button>
        <a-button type="link"
                  style="float: right; z-index: 1;"
                  @click="forget"
        >忘记密码</a-button>
      </a-form-item>
    </a-form>

    <registerModal ref="registerModal"></registerModal>
    <forgetModal ref="forgetModal"></forgetModal>
  </div>
</template>

<script>
import registerModal from "./registerModal";
import forgetModal from "./forgetModal";
import { Encrypt } from '@/utils/AES.js';
import { Login } from '@/api/user.js';
import SIdentify  from "@/views/utils/identify";

export default {
  name: 'Login',
  components: {
    's-identify': SIdentify,
    registerModal,
    forgetModal
  },
  data() {
    return {
      makeCode: '',
      generateCode: '',
      form: this.$form.createForm(this)
    }
  },
  mounted () {
    this.makeIdentifyCode({ randomTypeLen: true })
    console.log(this.generateCode)
  },
  methods: {
    submit() {
      this.form.validateFields((errors, values) => {
        if (!errors) {
          const _identity = values.authCode
          if (_identity === this.generateCode) {
            values.password = Encrypt(values.password)

            Login(values).then(res =>{
              if (res.data === 1){
                // 设置登录状态为 true
                localStorage.setItem('token', values.accountID)
                this.$router.push({
                  path:'/service',
                  query: {
                    id: values.accountID
                  }
                })
              } else {
                this.$message.error('失败！')
                this.form.resetFields()
              }
            })
          } else {
            this.$message.error('验证码错误！')
            this.form.setFieldsValue({
              authCode: '',
            })
            this.refreshCode()
          }
        }
      })
    },
    register() {
      this.$refs.registerModal.paramReceive()
    },
    forget() {
      this.$refs.forgetModal.paramReceive()
    },
    randomNum () {
      return Math.floor(Math.random() * 10)
    },
    randomAlphabet ({ isUupper = false } = {}) {
      // a的Unicode值为97,z的Unicode值为123
      const alphabet = String.fromCharCode(Math.floor(Math.random() * 25) + 97)
      if (!isUupper) {
        return alphabet
      } else {
        return alphabet.toUpperCase()
      }
    },
    makeIdentifyCode ({ length = 4, typeMix = true, pureNumber = 'alphabet', randomTypeLen = false, capsLookMix = false, numLength = 2, uupperLength = 1 } = {}) {
      this.makeCode = ''
      // 数字和字母混合
      if (typeMix) {
        if (randomTypeLen) {
          // 字母大小写混合
          if (capsLookMix) {
            const numLength = Math.floor(Math.random() * length) + 1
            const uupperLength = numLength === length ? 0 : Math.floor(Math.random() * (length - numLength)) + 1
            for (let i = 0; i < numLength; i++) {
              this.makeCode += this.randomNum()
            }
            for (let i = 0; i < uupperLength; i++) {
              this.makeCode += this.randomAlphabet({ isUupper: true })
            }
            if (numLength + uupperLength < length) {
              for (let i = 0; i < length - numLength - uupperLength; i++) {
                this.makeCode += this.randomAlphabet()
              }
            }
          } else {
            const numLength = Math.floor(Math.random() * length) + 1
            for (let i = 0; i < numLength; i++) {
              this.makeCode += this.randomNum()
            }
            if (numLength < length) {
              for (let i = 0; i < length - numLength; i++) {
                this.makeCode += this.randomAlphabet()
              }
            }
          }
        } else {
          // 字母大小写混合
          if (capsLookMix) {
            const tempNumLength = numLength < 0 ? 2 : numLength > length ? 2 : numLength
            const tempUupperLength = uupperLength < 0 ? 1 : uupperLength > length - tempNumLength ? 1 : uupperLength
            for (let i = 0; i < tempNumLength; i++) {
              this.makeCode += this.randomNum()
            }
            for (let i = 0; i < tempUupperLength; i++) {
              this.makeCode += this.randomAlphabet({ isUupper: true })
            }
            if (tempNumLength + tempUupperLength < length) {
              for (let i = 0; i < length - tempNumLength - tempUupperLength; i++) {
                this.makeCode += this.randomAlphabet()
              }
            }
          } else {
            const tempNumLength = numLength < 0 ? 2 : numLength > length ? 2 : numLength
            for (let i = 0; i < tempNumLength; i++) {
              this.makeCode += this.randomNum()
            }
            if (tempNumLength < length) {
              for (let i = 0; i < length - tempNumLength; i++) {
                this.makeCode += this.randomAlphabet()
              }
            }
          }
        }
      } else {
        // 纯数字('number')
        if (pureNumber === 'number') {
          for (let i = 0; i < length; i++) {
            this.makeCode += this.randomNum()
          }
        }
        // 纯字母('alphabet')
        if (pureNumber === 'alphabet') {
          // 字母大小写混合
          if (capsLookMix) {
            const tempUupperLength = uupperLength < 0 ? 1 : uupperLength > length ? 1 : uupperLength
            for (let i = 0; i < tempUupperLength; i++) {
              this.makeCode += this.randomAlphabet({ isUupper: true })
            }
            if (tempUupperLength < length) {
              for (let i = 0; i < length - tempUupperLength; i++) {
                this.makeCode += this.randomAlphabet()
              }
            }
          } else {
            for (let i = 0; i < length; i++) {
              this.makeCode += this.randomAlphabet()
            }
          }
        }
      }
      this.shuffle(this.makeCode)
    },
    shuffle (str) {
      this.generateCode = [...str].sort(() => Math.random() - 0.5).join('')
      console.log(this.generateCode)
    },
    refreshCode () {
      this.makeIdentifyCode({ randomTypeLen: true })
    }
  },
}
</script>

<style scoped>
  /* 页面背景 */
  .login-form {
    width: 25%;
    margin: 5% auto;
    border-radius: 25px;
    /*background: url("../../assets/log.png") no-repeat;*/
  }
  /* 登录背景 */
  .login-container {
    position: absolute;
    width: 100%;
    height: 100%;
    /*background: url("../../assets/back.png") no-repeat;*/
    /*background-size: 100% 100%;*/
  }
  /* 标题 */
  .login-title {
    color: #fff;
    margin-top: 5%;
    text-align: center;
    font-size: 40px;
    font-family: Microsoft Yahei;
  }
  /* 登陆按钮 */
  .submit{
    width: 100%;
    height: 45px;
    font-size: 16px;
  }
  /* 登陆标题 */
  .title{
    width: 32%;
    margin: 10px auto;
    color: #14C6CC;
    font-weight: 700;
    font-size: 24px;
    font-family: Microsoft Yahei;
  }
</style>
