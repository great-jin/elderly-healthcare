import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/index'
import Test from '@/views/test/index'

Vue.use(Router)

const router =  new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/test',
      name: 'Test',
      component: Test
    }
  ]
})

router.beforeEach((to, from, next) => {
  // 1. 判断是不是登录页面
  // 是登录页面
  if(to.path === '/') {
    next()
  } else {
    // 不是登录页面
    // 2. 判断 是否登录过
    let token = localStorage.getItem('token')
    token === '1' ? next() : next('/')
  }
})

export default router


