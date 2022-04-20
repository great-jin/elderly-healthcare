import Vue from 'vue'
import Router from 'vue-router'
// 页面路由信息
import { RouteInfo } from './const'
import { listHomeMenu } from '@/api/homeMenu'

Vue.use(Router)

// 页面注册
const router = new Router({
  mode: 'history',
  routes: RouteInfo
})

// 过期时间为一天
const ExpiresTime = 86400000

router.beforeEach((to, from, next) => {
  const routerInfo = JSON.parse(localStorage.getItem('routerInfo'))
  if (routerInfo.length === 0) {
    listHomeMenu().then(res => {
      localStorage.setItem('routerInfo', JSON.stringify(res.data))
    })
  }
  // 1. 状态判断
  const token = JSON.parse(localStorage.getItem('loginUser'))
  let isLogin = !(token == null || token.staffId == null || token.staffId === '')
  // 2. 判断登录时长
  if (isLogin) {
    const date = new Date().getTime()
    if (date - token.startTime > ExpiresTime) {
      // 登录时间超过一天需要重新登录
      localStorage.removeItem('loginUser')
      isLogin = false
      this.$message.info('登录过期，请重新登录')
    }
  }
  // 3. 是否为登录页
  if (to.path === '/elderlyHealthcare/login') {
    // 3.1. 已登录则回首页，未登录放行
    isLogin ? next('/elderlyHealthcare/home') : next()
  } else {
    // 3.2 已登录则放行，未登录转登录页
    isLogin ? next() : next('/elderlyHealthcare/login')
  }
})

// 路由重复处理
const originalPush = Router.prototype.push
Router.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

export default router
