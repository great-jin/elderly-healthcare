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
  // 1. 获取路由信息
  const routerInfo = JSON.parse(localStorage.getItem('routerInfo'))
  if (routerInfo == null || routerInfo.length === 0) {
    listHomeMenu().then(res => {
      localStorage.setItem('routerInfo', JSON.stringify(res.data))
    })
  }
  // 2. 登录状态判断
  const user = JSON.parse(localStorage.getItem('loginUser'))
  let isLogin = !(user == null || user.staffId == null || user.staffId === '')
  // 3. 判断登录时长
  if (isLogin) {
    const date = new Date().getTime()
    if (date - user.startTime > ExpiresTime) {
      // 3.1 登录时间超过一天需要重新登录
      localStorage.removeItem('loginUser')
      isLogin = false
      this.$message.info('登录过期，请重新登录')
    }
  }
  // 4. 访问登录页
  if (to.path === '/elderlyHealthcare/login') {
    // 4.1. 已登录则回首页，未登录放行
    isLogin ? next('/elderlyHealthcare/home') : next()
  } else {
    // 5. 访问其它页面
    if (isLogin) {
      // 5.1 已登录判断权限
      const power = user.userPower
      if (to.path.includes('root') && power !== 0) {
        // 非管理员用户访问后台重定向至登录页
        window.alert('很抱歉，您没有访问权限')
        next('/elderlyHealthcare/login')
      } else {
        next()
      }
    } else {
      // 5.2 未登录返回登录页
      next('/elderlyHealthcare/login')
    }
  }
})

// 路由重复处理
const originalPush = Router.prototype.push
Router.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

export default router
