import Vue from 'vue'
import Router from 'vue-router'

import Login from '@/views/login/index'
import Home from '@/views/home/index'

Vue.use(Router)

const router =  new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    }, {
      path: '/home',
      name: 'Home',
      component: Home
    }
  ]
})

router.beforeEach((to, from, next) => {
  // 1. 判断是是否为登录页面
  if(to.path === '/') {
    next()
  } else {
    // 2. 判断是否登录过
    let token = localStorage.getItem('token')
    token === '1' ? next() : next('/')
  }
})

export default router


