<template>
  <div class="login-container">
    <h2 class="login-title">Elderly Healthcare</h2>
    <a-form class="login-form" :form="form">
      <h2 class="title">登录</h2>
      <a-form-item>
        <a-input
          class="inputBox"
          placeholder="请输入账号"
          v-decorator="['accountID', { rules: [{ required: true, message: '账号不能为空!' }] }]"
        >
          <img src="src/assets/man.png" slot="prefix" alt="">
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-input-password
          class="inputBox"
          placeholder="请输入密码"
          v-decorator="['password', { rules: [{ required: true, message: '密码不能为空!' }] }]"
        >
          <img src="src/assets/lock.png" slot="prefix" alt="">
        </a-input-password>
      </a-form-item>

      <a-form-item >
        <a-input
          style="width: 200px; margin-right: 20px;"
          placeholder="请输入验证码"
          v-decorator="['identifyInput', { rules: [{ required: true, message: '验证码不能为空!' }] }]"
        ></a-input>
        <div @click="refreshCode()" style="display: inline-block">
          <s-identify :identifyCode="identifyCode" ></s-identify>
        </div>
      </a-form-item>

      <a-form-item>
        <a-button class="submit" type="primary" @click="Login()">登录</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import {Encrypt,Decrypt} from '@/utils/AES.js';
import { Login } from '@/api/user.js';
import SIdentify  from "./identify";

export default {
  components: {
    's-identify': SIdentify
  },
  data() {
    return {
      makeCode: '',
      identifyCode: '',
      identifyInput: '',
      user: {
        accountID: '',
        userName: '',
        password: ''
      },
      form: this.$form.createForm(this)
    }
  },
  mounted () {
    this.makeIdentifyCode({ randomTypeLen: true })
    console.log(this.identifyCode)
  },
  methods: {
    Login() {
      this.form.validateFields((errors, values) => {
        if (!errors) {
          const _identity = values.identifyInput
          if (_identity === this.identifyCode) {
            const params = values
            params.password = Encrypt(values.password);
            console.log(params)

            Login(params).then(res =>{
              console.log('res：' + res)
              if (res === 1){
                this.$message.success('成功！')
              } else {
                this.$message.error('失败！')
                this.identifyCode = ''
                this.form.resetFields()
              }
            })
          } else {
            console.log('_identity：' + _identity)
            this.$message.error('验证码错误！')
            this.identifyCode = ''
            this.refreshCode()
          }
        }
      })
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
      this.identifyCode = [...str].sort(() => Math.random() - 0.5).join('')
      console.log(this.identifyCode)
    },
    refreshCode () {
      this.makeIdentifyCode({ randomTypeLen: true })
    }
  },
}
</script>

<style>
  .login-form {
    width: 565px;
    height: 380px;
    margin: 0 auto;
    background: url("../assets/bg.png");
    padding: 40px 110px;
  }
  /* 背景 */
  .login-container {
    position: absolute;
    width: 100%;
    height: 100%;
    background: url("../assets/bg.png");
  }
  /* Log */
  .login-title {
    color: #fff;
    text-align: center;
    margin: 150px 0;
    font-size: 48px;
    font-family: Microsoft Yahei;
  }
  /* 登陆按钮 */
  .submit{
    width: 100%;
    height: 45px;
    font-size: 16px;
  }
  /* 用户登陆标题 */
  .title{
    margin-bottom: 35px;
    color: #fff;
    font-weight: 700;
    font-size: 24px;
    font-family: Microsoft Yahei;
  }
  /* 输入框 */
  .inputBox{
    height: 35px;
  }
  /* 输入框内左边距50px */
  .ant-input-affix-wrapper .ant-input:not(:first-child) {
    padding-left: 50px;
  }
</style>


