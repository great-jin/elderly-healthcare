<template>
  <div id="container">
    <a-row style="margin-right: 15px">
      <a-col class="head-workspace" :span="17">
        <a-card
          title="我的工作台"
          style="width: 100%"
          :bordered="false"
          hoverable
        >
          <a-card-meta :title="loginUser.userName" description="欢迎登录系统">
            <a-avatar
              size="large"
              slot="avatar"
              :src="imgUrl"
            />
          </a-card-meta>
          <template slot="actions" class="ant-card-actions">
            <span key="setting" @click="clickOption('person', null)">个人信息</span>
            <span key="edit" @click="clickOption('back', null)">更多功能</span>
            <span key="ellipsis" @click="clickOption('quit', null)">退出登录</span>
          </template>
        </a-card>
        <div class="head-card">
          <a-row :gutter="16">
            <a-col :span="6">
              <a-card title="代办任务" :bordered="false" size="small">
                <a-tag color="pink">代办：{{ count.act + count.delay }}</a-tag>
              </a-card>
            </a-col>
            <a-col :span="6">
              <a-card title="超时任务" :bordered="false" size="small">
                <a-tag color="pink">超时：{{ count.delay }}</a-tag>
              </a-card>
            </a-col>
            <a-col :span="6">
              <a-card title="入住总人数" :bordered="false" size="small">
                <a-tag color="green">健康：{{ count.delay }}</a-tag>
              </a-card>
            </a-col>
            <a-col :span="6">
              <a-card title="待检测人员" :bordered="false" size="small">
                <a-tag color="orange">待检查：{{ count.delay }}</a-tag>
              </a-card>
            </a-col>
          </a-row>
        </div>
      </a-col>
      <a-col :span="7" class="calendar">
        <a-calendar :fullscreen="false"/>
      </a-col>
    </a-row>
    <a-row>
      <a-col class="task" :span="13">
        <div style="padding: 5px;">
          <a-card title="代办任务" size="default" style="width: 100%">
            <a-radio-group
              default-value="代办"
              style="margin-bottom: 10px"
              defaultValue="0"
            >
              <a-radio-button value="0" @click="taskState('0')">
                代办({{ count.act }})
              </a-radio-button>
              <a-radio-button value="1" @click="taskState('1')">
                超时({{ count.delay }})
              </a-radio-button>
              <a-radio-button value="2" @click="taskState('2')">
                已办({{ count.done }})
              </a-radio-button>
            </a-radio-group>
            <a-list
              class="task-list"
              item-layout="horizontal"
              :data-source="taskData"
            >
              <a-list-item slot="renderItem" slot-scope="item" style="padding: 5px">
                <a-tooltip>
                  <template slot="title">
                    {{ item.taskName }} : {{ item.taskContent }}
                  </template>
                  <a-list-item-meta
                    :description="item.taskContent.length"
                    :data-tips="item.taskContent"
                  >
                    <a slot="title">{{ item.taskName }}</a>
                  </a-list-item-meta>
                </a-tooltip>
                <template slot="actions">
                  <a-button type="link" @click="clickOption('detail', item)">查看</a-button>
                  <a-popconfirm
                    title="确认关闭任务"
                    ok-text="是"
                    cancel-text="否"
                    @confirm="clickOption('done', item)"
                  >
                    <a-button type="link">完成</a-button>
                  </a-popconfirm>
                </template>
                <taskModal ref="taskModal"/>
              </a-list-item>
            </a-list>
          </a-card>
        </div>
      </a-col>
      <a-col class="process" :span="11">
        <template v-if="isRoot">
          <a-card
            title="待审批流程"
            :body-style="{padding: 0}"
            :style="{marginTop: '5px', minHeight: '250px'}"
          >
            <a-button slot="extra" type="link" @click="jump('unAudit')">全部流程</a-button>
            <a-card-grid
              style="width:33.33%; text-align:center"
              v-for="(item, i) in unAuditProcess"
              :key="i"
            >
              <a-card
                :bordered="false"
                :body-style="{padding: 0}"
                @click="clickOption('process', item, '1')"
              >
                <a-card-meta :description="item.vacateReason">
                  <div slot="title">
                    <span>{{ item.vacateType }} 申请</span>
                  </div>
                </a-card-meta>
              </a-card>
            </a-card-grid>
            <processModal ref="processModal"/>
          </a-card>
          <a-card
            title="进行中流程"
            :body-style="{padding: 0}"
            :style="{marginTop: '15px', minHeight: '250px'}"
          >
            <a-button slot="extra" type="link" @click="jump('unFinish')">全部流程</a-button>
            <a-card-grid
              style="width:33.33%; text-align:center"
              v-for="(item, i) in acticityProcess"
              :key="i"
            >
              <a-card
                :bordered="false"
                :body-style="{padding: 0}"
                @click="clickOption('process', item, '0')"
              >
                <a-card-meta :description="item.vacateReason">
                  <div slot="title">
                    <span>{{ item.vacateType }} 申请</span>
                  </div>
                </a-card-meta>
              </a-card>
            </a-card-grid>
            <processModal ref="processModal"/>
          </a-card>
        </template>
        <template v-else>
          <a-card
            title="进行中流程"
            :body-style="{padding: 0}"
            :style="{marginTop: '5px', minHeight: '510px'}"
          >
            <a-button slot="extra" type="link" @click="jump('unFinish')">全部流程</a-button>
            <a-card-grid
              style="width:33.33%; text-align:center"
              v-for="(item, i) in acticityProcess"
              :key="i"
            >
              <a-card
                :bordered="false"
                :body-style="{padding: 0}"
                @click="clickOption('process', item, '0')"
              >
                <a-card-meta :description="item.vacateReason">
                  <div slot="title">
                    <span>{{ item.vacateType }} 申请</span>
                  </div>
                </a-card-meta>
              </a-card>
            </a-card-grid>
            <processModal ref="processModal"/>
          </a-card>
        </template>
      </a-col>
    </a-row>
    <a-row :span="24">
      <div class="footer">
        <span><b>Copyright @布袋青年</b></span>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <span><b>Email: great__jin@163.com</b></span>
      </div>
    </a-row>
  </div>
</template>

<script>
import taskModal from './taskModal'
import processModal from './processModal'
import {listTask} from '@/api/dailyTask'
import {listVacateInfo} from '@/api/vacateInfo'

export default {
  name: 'HomePage',
  components: {
    taskModal,
    processModal
  },
  data() {
    return {
      imgUrl: '',
      count: {
        act: '',
        delay: '',
        done: ''
      },
      isRoot: false,
      loginUser: {},
      taskData: [],
      acticityProcess:[],
      unAuditProcess: []
    }
  },
  mounted() {
    // 获取头像地址
    this.imgUrl = localStorage.getItem('avatar')
    const _loginUser = JSON.parse(localStorage.getItem('loginUser'))
    // 根用户显示审批
    if (_loginUser.userPower === 0) {
      this.isRoot = true
    }
    this.loginUser = _loginUser
    this.getData()
    this.taskCount()
    this.taskState('0')
  },
  methods: {
    async getData() {
      const _data = {
        staffId: this.loginUser.staffId
      }
      let _unDone = []
      // 当前用户未审核流程
      await listVacateInfo(_data).then(res => {
        _unDone = res.data
      })
      this.acticityProcess = (_unDone.filter(item => item.isApprove === 0)).slice(0, 6)
      // 所有待审批流程
      let _unAudit = []
      await listVacateInfo().then(res => {
        _unAudit = res.data
      })
      this.unAuditProcess = (_unAudit.filter(item => item.isApprove === 0)).slice(0, 6)
    },
    taskCount() {
      this.count.act = 0
      this.count.done = 0
      this.count.delay = 0
      const staff = {
        nurseId: this.loginUser.staffId
      }
      listTask(staff).then(res => {
        res.data.forEach((task) => {
          if (task.isFinished !== 1 && task.isDelay !== 1) {
            this.count.act++
          } else if (task.isDelay === 1) {
            this.count.delay++
          } else if (task.isFinished === 1) {
            this.count.done++
          }
        })
      })
    },
    jump(data) {
      switch (data) {
        case 'unFinish' :
          this.$router.push('/elderlyHealthcare/service/task')
          break
        case 'unAudit' :
          this.$router.push('/elderlyHealthcare/human/vacate')
          break
      }
    },
    taskState(state) {
      this.taskData = []
      const staff = {
        nurseId: this.loginUser.staffId
      }
      listTask(staff).then(res => {
        switch (state) {
          case '0':
            res.data.forEach((task) => {
              if (task.isFinished !== 1 && task.isDelay !== 1) {
                this.taskData.push(task)
              }
            })
            break
          case '1':
            res.data.forEach((task) => {
              if (task.isDelay === 1) {
                this.taskData.push(task)
              }
            })
            break
          case '2':
            res.data.forEach((task) => {
              if (task.isFinished === 1) {
                this.taskData.push(task)
              }
            })
            this.taskData = this.taskData.slice(0, 10)
            break
        }
      })
    },
    clickOption(type, data, topic) {
      switch (type) {
        case 'person':
          this.$router.push('/elderlyHealthcare/setting/personal')
          break
        case 'back':
          this.$router.push('/elderlyHealthcare/main')
          break
        case 'quit':
          localStorage.removeItem('avatar')
          localStorage.removeItem('loginUser')
          this.$router.push('/elderlyHealthcare/login')
          break
        case 'done':
          this.$message.success('完成')
          break
        case 'detail':
          this.$refs.taskModal.paramReceive(data)
          break
        case 'process':
          this.$refs.processModal.paramReceive('process', data, topic)
          break
      }
    }
  }
}
</script>

<style scoped>
::-webkit-scrollbar {
  width: 0 !important;
}

::-webkit-scrollbar {
  width: 0 !important;
  height: 0;
}

#container {
  padding: 7px 3px;
  height: 100%;
  overflow-x: hidden;
  overflow-y: auto;
  background-color: #ECECEC;
}

.head-workspace {
  padding: 10px 15px 0 10px;
}

.head-card {
  margin-top: 20px;
  padding: 5px;
  background-color: #ececec;
}

.calendar {
  background-color: white;
}

.process {
  margin-top: 5px;
  padding: 0px 10px;
  overflow: auto;
  /*max-height: 40%;*/
}

.task {
  margin-top: 5px;
  padding: 0px 10px;
  /*max-height: 40%;*/
  overflow: auto;
}

.task-list {
  min-height: 365px;
  overflow-y: auto;
}

.footer {
  height: 80px;
  line-height: 80px;
  text-align: center;
  font-size: 15px;
  background-color: #ECECEC;
}
</style>
