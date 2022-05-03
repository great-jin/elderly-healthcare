// 首页
import Home from '@/views/front/homePage/dashBoard/index'
import Login from '@/views/front/homePage/loginPage/index'
import Main from '@/views/front/index'
// 公共服务
import Service from '@/views/front/servicePage/index'
import DataChart from '@/views/front/servicePage/dataChart/index'
import DataMonitor from '@/views/front/servicePage/dataMonitor/index'
import DataAccess from '@/views/front/servicePage/dataAccess/index'
import PatientInfo from '@/views/front/servicePage/patientManage/index'
import CostAccess from '@/views/front/servicePage/costAccess/index'
// 人力资源
import Human from '@/views/front/humanPage/index'
import Staff from '@/views/front/humanPage/staffManage/index'
import Vacate from '@/views/front/humanPage/vacateManage/index'
// 资产中心
import Asset from '@/views/front/assetPage/index'
import Apply from '@/views/front/assetPage/applyManage/index'
import Payment from '@/views/front/assetPage/paymentManage/index'
// 仓储管理
import Store from '@/views/front/storePage/index'
import Storage from '@/views/front/storePage/storageManage/index'
import Medicine from '@/views/front/storePage/medicineManage/index'
import Order from '@/views/front/storePage/orderManage/index'
// 设置
import Personal from '@/views/front/settingPage/personalSetting/index'
import Question from '@/views/front/settingPage/questionSetting/index'
// 异常页面
import UnAuth from '@/views/front/errorPage/403'
import NotFound from '@/views/front/errorPage/404'
import ServerFaild from '@/views/front/errorPage/500'

// 后台管理
import Root from '@/views/root/index'
// 基本管理
import Process from '@/views/root/basisPage/index'
import Task from '@/views/root/basisPage/taskManage/index'
import Audit from '@/views/root/basisPage/auditManage/index'
// 人员管理
import Employee from '@/views/root/staffPage/index'
import User from '@/views/root/staffPage/userManage/index'
import Salary from '@/views/root/staffPage/salaryManage/index'
import Dispatch from '@/views/root/staffPage/dispatchManage/index'
// 系统管理
import System from '@/views/root/systemPage/index'
import SystemLog from '@/views/root/systemPage/systemLogs/index'
import Minio from '@/views/root/systemPage/minioConfig/index'
import Router from '@/views/root/systemPage/routerConfig/index'

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
            component: PatientInfo
          }, {
            path: '/elderlyHealthcare/service/cost',
            component: CostAccess
          }
        ]
      }, {
        // 人力资源
        path: '/elderlyHealthcare/human',
        name: 'Human',
        component: Human,
        children: [
          {
            path: '/elderlyHealthcare/human/staff',
            component: Staff
          }, {
            path: '/elderlyHealthcare/human/vacate',
            component: Vacate
          }
        ]
      }, {
        // 资产中心
        path: '/elderlyHealthcare/asset',
        name: 'Asset',
        component: Asset,
        children: [
          {
            path: '/elderlyHealthcare/asset/apply',
            component: Apply
          }, {
            path: '/elderlyHealthcare/asset/payment',
            component: Payment
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
  },
  {
    path: '/elderlyHealthcare/root',
    name: 'Root',
    component: Root,
    children: [
      {
        // 流程审批
        path: '/elderlyHealthcare/root/process',
        name: 'Process',
        component: Process,
        children: [
          {
            path: '/elderlyHealthcare/root/process/task',
            component: Task
          },
          {
            path: '/elderlyHealthcare/root/process/audit',
            component: Audit
          }
        ]
      },
      {
        // 流程审批
        path: '/elderlyHealthcare/root/staff',
        name: 'Employee',
        component: Employee,
        children: [
          {
            path: '/elderlyHealthcare/root/staff/user',
            component: User
          },
          {
            path: '/elderlyHealthcare/root/staff/dispatch',
            component: Dispatch
          },
          {
            path: '/elderlyHealthcare/root/staff/salary',
            component: Salary
          }
        ]
      },
      {
        // 系统管理
        path: '/elderlyHealthcare/root/system',
        name: 'System',
        component: System,
        children: [
          {
            path: '/elderlyHealthcare/root/system/minio',
            component: Minio
          },
          {
            path: '/elderlyHealthcare/root/system/logs',
            component: SystemLog
          },
          {
            path: '/elderlyHealthcare/root/system/router',
            component: Router
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
