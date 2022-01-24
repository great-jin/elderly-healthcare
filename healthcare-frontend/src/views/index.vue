<template>
  <div class="login-container">
    <h2 class="login-title">Elderly Healthcare</h2>
    <a-form class="login-form">
      <h2 class="title">登录</h2>
      <a-form-item>
        <a-input class="inputBox" v-model="user.accountID">
          <img src="src/assets/man.png" slot="prefix" alt="">
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-input-password class="inputBox" v-model="user.password">
          <img src="src/assets/lock.png" slot="prefix" alt="">
        </a-input-password>
      </a-form-item>

      <a-form-item>
        <a-button class="submit" type="primary" @click="onSubmit()">登录</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import { Login } from '@/api/user.js';
export default {
  data() {
    return {
      user:{
        accountID: '',
        userName: '',
        password: ''
      }
    }
  },
  methods: {
    onSubmit()  {
      const params = this.user
      console.log(params)
      if (params.accountID !== '' && params.userName !== '' && params.password !== '') {
        Login(params).then(res =>{
          console.log(res)
          if (res === 1){
            this.backResult = 'OK'
          } else {
            this.backResult = 'Faild'
          }
        })
      } else {
        this.$message.error('Please input the user info!')
      }
    }
  },
}
</script>

<style>
  .login-form {
    width: 565px;
    height: 372px;
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
    margin-bottom: 50px;
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


