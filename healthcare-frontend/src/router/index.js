import Vue from 'vue'
import Router from 'vue-router'

//首页
import Login from '@/views/loginPage/index'
import Home from '@/views/homePage/index'

// 公共服务
import Service from '@/views/servicePage/index'
import DataChart from '@/views/servicePage/dataChart/index'
import DataMonitor from '@/views/servicePage/dataMonitor/index'
import DataAccess from '@/views/servicePage/dataAccess/index'
import Patient from '@/views/servicePage/patientManage/index'
import Task from '@/views/servicePage/taskManage/index'
import SysLog from '@/views/servicePage/SystemLog/index'

// 人力资源
import Human from '@/views/humanPage/index'
import Staff from '@/views/humanPage/staffManage/index'
import Doctor from '@/views/humanPage/DoctorManage/index'
import Vacate from '@/views/humanPage/vacateManage/index'

// 资产中心
import Property from '@/views/assetPage/index'
import Apply from '@/views/assetPage/applyManage/index'
import Salary from '@/views/assetPage/salaryManage/index'
import Payment from '@/views/assetPage/paymentManage/index'

// 仓储管理
import Store from '@/views/storePage/index'
import Storage from '@/views/storePage/storageManage/index'
import WareHouse from '@/views/storePage/wareHouse/index'
import Order from '@/views/storePage/orderManage/index'

// 设置
import Personal from '@/views/settingPage/personalSetting/index'
import Question from '@/views/settingPage/questionSetting/index'

// 异常页面
import UnAuth from '@/views/errorPage/403'
import NotFound from '@/views/errorPage/404'
import ServerFaild from '@/views/errorPage/500'

Vue.use(Router)

// 页面注册
const router = new Router({
  mode: 'history',
  routes: [
    {
      // 未定义页面重定向到 404
      path: '*',
      redirect: '/404'
    }, {
      path: '/',
      redirect: '/elderlyHealthcare/login'
    }, {
      path: '/elderlyHealthcare/login',
      name: 'Login',
      component: Login
    }, {
      path: '/elderlyHealthcare/home',
      name: 'Home',
      component: Home
    }, {
      // 公共服务
      path: '/elderlyHealthcare/service',
      name: 'Service',
      component: Service,
      children: [
        {
          path: '/elderlyHealthcare/service/chart',
          component: DataChart
        }, {
          path: '/elderlyHealthcare/service/monitor',
          component: DataMonitor
        }, {
          path: '/elderlyHealthcare/service/access',
          component: DataAccess
        }, {
          path: '/elderlyHealthcare/service/patient',
          component: Patient
        }, {
          path: '/elderlyHealthcare/service/task',
          component: Task
        }, {
          path: '/elderlyHealthcare/service/logs',
          component: SysLog
        }
      ]
    }, {
      // 人力资源
      path: '/elderlyHealthcare/humanResource',
      name: 'Human',
      component: Human,
      children: [
        {
          path: '/elderlyHealthcare/humanResource/staff',
          component: Staff
        }, {
          path: '/elderlyHealthcare/humanResource/doctor',
          component: Doctor
        }, {
          path: '/elderlyHealthcare/humanResource/vacate',
          component: Vacate
        }
      ]
    }, {
      // 资产中心
      path: '/elderlyHealthcare/asset',
      name: 'Property',
      component: Property,
      children: [
        {
          path: '/elderlyHealthcare/asset/apply',
          component: Apply
        }, {
          path: '/elderlyHealthcare/asset/payment',
          component: Payment
        }, {
          path: '/elderlyHealthcare/asset/salary',
          component: Salary
        }
      ]
    }, {
      // 仓库管理
      path: '/elderlyHealthcare/store',
      name: 'Store',
      component: Store,
      children: [
        {
          path: '/elderlyHealthcare/store/order',
          component: Order
        },
        {
          path: '/elderlyHealthcare/store/storage',
          component: Storage
        }, {
          path: '/elderlyHealthcare/store/warehouse',
          component: WareHouse
        }
      ]
    }, {
      path: '/elderlyHealthcare/setting/personal',
      name: 'Personal',
      component: Personal
    }, {
      path: '/elderlyHealthcare/setting/question',
      name: 'Question',
      component: Question
    }, {
      path: '/403',
      name: 'Unauthorized',
      component: UnAuth
    }, {
      path: '/404',
      name: 'NotFound',
      component: NotFound
    }, {
      path: '/500',
      name: 'ServerReject',
      component: ServerFaild
    }
  ]
})

// 过期时间为一天
let ExpiresTime = 86400000

// 登录过滤
router.beforeEach((to, from, next) => {
  let token, isLogin

  // 状态判断
  token = JSON.parse(localStorage.getItem('token'))
  isLogin = !(token == null || token.flag == null || token.flag === '')

  // 判断登录时长
  if(isLogin){
    let date = new Date().getTime();
    if (date - token.startTime > ExpiresTime) {
      // 登录时间超过一天需要重新登录
      localStorage.removeItem('token')
      isLogin = false
      this.$message.info('登录过期，请重新登录')
    }
  }

  // 1. 是否为登录页
  if(to.path === '/elderlyHealthcare/login') {
    // 2. 已登录则回首页，未登录放行
    isLogin ? next('/elderlyHealthcare/home') : next()
  } else {
    // 3. 已登录则放行，未登录转登录页
    isLogin ? next() : next('/elderlyHealthcare/login')
  }
})

// 路由重复处理
const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

export default router


