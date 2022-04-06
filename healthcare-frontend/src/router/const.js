// 首页
import Home from '@/views/homePage/dashBoard/index'
import Login from '@/views/homePage/loginPage/index'
import Main from '@/views/index'
// 公共服务
import Service from '@/views/servicePage/index'
import DataChart from '@/views/servicePage/dataChart/index'
import DataMonitor from '@/views/servicePage/dataMonitor/index'
import DataAccess from '@/views/servicePage/dataAccess/index'
import Patient from '@/views/servicePage/patientManage/index'
import Task from '@/views/servicePage/taskManage/index'
import SystemLog from '@/views/servicePage/systemLog/index'
// 人力资源
import Human from '@/views/humanPage/index'
import Staff from '@/views/humanPage/staffManage/index'
import Dispatch from '@/views/humanPage/dispatchManage/index'
import Vacate from '@/views/humanPage/vacateManage/index'
// 资产中心
import Property from '@/views/assetPage/index'
import Apply from '@/views/assetPage/applyManage/index'
import Salary from '@/views/assetPage/salaryManage/index'
import Payment from '@/views/assetPage/paymentManage/index'
// 仓储管理
import Store from '@/views/storePage/index'
import Storage from '@/views/storePage/storageManage/index'
import Medicine from '@/views/storePage/medicineManage/index'
import Order from '@/views/storePage/orderManage/index'
// 设置
import Personal from '@/views/settingPage/personalSetting/index'
import Question from '@/views/settingPage/questionSetting/index'
// 异常页面
import UnAuth from '@/views/errorPage/403'
import NotFound from '@/views/errorPage/404'
import ServerFaild from '@/views/errorPage/500'
// 系统管理

export const RouteInfo = [
  {
    // 未定义页面重定向到 404
    path: '*',
    redirect: '/404'
  }, {
    path: '',
    redirect: '/elderlyHealthcare/login'
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
    path: '/elderlyHealthcare/main',
    name: 'Main',
    component: Main,
    children: [
      {
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
            component: SystemLog
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
            path: '/elderlyHealthcare/humanResource/dispatch',
            component: Dispatch
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
            path: '/elderlyHealthcare/store/medicine',
            component: Medicine
          }
        ]
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
