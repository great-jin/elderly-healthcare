import Vue from 'vue'
import Router from 'vue-router'

import Login from '@/views/login/index'
import Home from '@/views/home/index'

import User from '@/views/patientManage/index'
import Staff from '@/views/staffManage/index'
import Store from '@/views/storeManage/index'
import Monitor from '@/views/dataMonitor/index'
import WareHouse from '@/views/wareHouse/index'

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
      component: Home,
      children: [
        {
          path: '/home/user',
          component: User
        },{
          path: '/home/staff',
          component: Staff
        },{
          path: '/home/monitor',
          component: Monitor
        },{
          path: '/home/store',
          component: Store
        },{
          path: '/home/warehouse',
          component: WareHouse
        }
      ]
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

const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

export default router


