import Vue from 'vue'
import Router from 'vue-router'

import Login from '@/views/loginPage/index'

// 公共服务
import Service from '@/views/homepage/index'
import DataChart from '@/views/homepage/dataChart/index'
import DataMonitor from '@/views/homepage/dataMonitor/index'
import DataAccess from '@/views/homepage/dataAccess/index'
import Patient from '@/views/homepage/patientManage/index'
import SysLog from '@/views/homepage/SystemLog/index'

// 人力资源
import Human from '@/views/humanPage/index'
import Staff from '@/views/humanPage/staffManage/index'
import Doctor from '@/views/humanPage/DoctorManage/index'
import Vacate from '@/views/humanPage/vacateManage/index'

// 订单管理
import Order from '@/views/orderPage/index'

// 仓储管理
import Store from '@/views/storePage/index'
import Storage from '@/views/storePage/storageManage/index'
import WareHouse from '@/views/storePage/wareHouse/index'

// 设置
import Personal from '@/views/settingPage/personalSetting/index'
import Question from '@/views/settingPage/questionSetting/index'

Vue.use(Router)

const router =  new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    }, {
      path: '/service',
      name: 'Service',
      component: Service,
      children: [
        {
          path: '/service/chart',
          component: DataChart
        }, {
          path: '/service/monitor',
          component: DataMonitor
        }, {
          path: '/service/access',
          component: DataAccess
        }, {
          path: '/service/patient',
          component: Patient
        }, {
          path: '/service/logs',
          component: SysLog
        }
      ]
    }, {
      path: '/humansouce',
      name: 'Human',
      component: Human,
      children: [
        {
          path: '/humansouce/staff',
          component: Staff
        }, {
          path: '/humansouce/doctor',
          component: Doctor
        }, {
          path: '/humansouce/vacate',
          component: Vacate
        }
      ]
    }, {
      path: '/order',
      name: 'Order',
      component: Order
    }, {
      path: '/store',
      name: 'Store',
      component: Store,
      children: [
        {
          path: '/store/storage',
          component: Storage
        }, {
          path: '/store/warehouse',
          component: WareHouse
        }
      ]
    }, {
      path: '/setting/personal',
      name: 'Personal',
      component: Personal
    }, {
      path: '/setting/question',
      name: 'Question',
      component: Question
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
    token === '0' ? next('/') : next()
  }
})

const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

export default router


