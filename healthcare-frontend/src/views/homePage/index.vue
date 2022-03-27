<template>
  <div style="overflow-x: hidden">
    <a-row>
      <a-col class="head-workspace" :span="16">
        <a-card
          title="工作台"
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
            <span key="setting" @click="operationClick('person', null)">个人信息</span>
            <span key="edit" @click="operationClick('back', null)">系统后台</span>
            <span key="ellipsis" @click="operationClick('quit', null)">退出登录</span>
          </template>
        </a-card>
        <div class="head-card">
          <a-row :gutter="16">
            <a-col :span="8">
              <a-card title="每日任务" :bordered="false" size="small">
                <a-tag color="pink">未办：{{ count.act + count.delay }}</a-tag>
                <a-tag color="pink">超时：{{ count.delay }}</a-tag>
              </a-card>
            </a-col>
            <a-col :span="8">
              <a-card title="病人总数" :bordered="false" size="small">
                <a-tag color="green">健康：{{ count.delay }}</a-tag>
                <a-tag color="orange">待检查：{{ count.delay }}</a-tag>
              </a-card>
            </a-col>
            <a-col :span="8">
              <a-card title="Card title" :bordered="false" size="small">
                <a-tag color="pink">pink</a-tag>
                <a-tag color="pink">pink</a-tag>
              </a-card>
            </a-col>
          </a-row>
        </div>
      </a-col>
      <a-col :span="7">
        <div class="calendar">
          <a-calendar :fullscreen="false" />
        </div>
      </a-col>
    </a-row>
    <a-row>
      <a-col class="task" :span="14">
        <a-card
          title="进行中流程"
          :style="{marginTop: '5px'}"
          :body-style="{padding: 0}"
        >
          <a slot="extra" href="#">全部流程</a>
          <a-card-grid
            style="width:33.33%; text-align:center"
            :key="i" v-for="(item, i) in processList.slice(0, 6)"
          >
            <a-card
              :bordered="false"
              :body-style="{padding: 0}"
              @click="operationClick('process', item)"
            >
              <a-card-meta
                :description="item.desc.length<30 ? item.desc : item.desc.substr(0,20).concat('...')"
              >
                <div slot="title" class="card-title">
                  <span>{{ item.title }}</span>
                </div>
              </a-card-meta>
            </a-card>
          </a-card-grid>
          <processModal ref="processModal"/>
        </a-card>

        <a-card
          title="待审批流程"
          :style="{marginTop: '5px'}"
          :body-style="{padding: 0}"
        >
          <a slot="extra" href="#">全部流程</a>
          <a-card-grid
            style="width:33.33%; text-align:center"
            :key="i" v-for="(item, i) in processList.slice(0, 6)"
          >
            <a-card
              :bordered="false"
              :body-style="{padding: 0}"
              @click="operationClick('process', item)"
            >
              <a-card-meta
                :description="item.desc.length<30 ? item.desc : item.desc.substr(0,20).concat('...')"
              >
                <div slot="title" class="card-title">
                  <span>{{ item.title }}</span>
                </div>
              </a-card-meta>
            </a-card>
          </a-card-grid>
          <processModal ref="processModal"/>
        </a-card>
      </a-col>

      <a-col class="task" :span="10">
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
              <a-list-item slot="renderItem" slot-scope="item, index" style="padding: 5px">
                <a-tooltip>
                  <template slot="title">
                    {{ item.taskName }} :  {{ item.taskContent }}
                  </template>
                  <a-list-item-meta
                    :description="item.taskContent.length<30 ? item.taskContent : item.taskContent.substr(0,30).concat('...')"
                    :data-tips="item.taskContent"
                  >
                    <a slot="title">{{ item.taskName }}</a>
                  </a-list-item-meta>
                </a-tooltip>
                <a slot="actions" @click="operationClick('more', item)">详情</a>
                <a slot="actions" @click="operationClick('edit', item)">编辑</a>

                <taskModal ref="taskModal"/>
              </a-list-item>
            </a-list>
          </a-card>
        </div>
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
import { getStaffTask } from '@/api/dailyTask'

export default {
  name: 'Home',
  components: {
    taskModal,
    processModal
  },
  data () {
    return {
      imgUrl: '',
      count: {
        act: '',
        delay: '',
        done: ''
      },
      loginUser: {},
      taskData: [],
      processList: [
        {
          title: 'title 1',
          desc: 'describe 1iusdd bsdbjsdd ihsd iusddib iuuiu iuusddiub'
        },
        {
          title: 'title 2',
          desc: 'describe 2'
        },
        {
          title: 'title 3',
          desc: 'describe 3'
        },
        {
          title: 'title 4',
          desc: 'describe 4'
        },
        {
          title: 'title 5',
          desc: 'describe 5'
        },
        {
          title: 'title 6',
          desc: 'describe 6'
        },
        {
          title: 'title 7',
          desc: 'describe 7'
        }
      ]
    }
  },
  mounted () {
    // 获取头像地址
    this.imgUrl = localStorage.getItem('avatar')
    this.loginUser = JSON.parse(localStorage.getItem('staffInfo'))
    this.taskCount()
    this.taskState('0')
  },
  methods: {
    taskCount () {
      this.count.act = 0
      this.count.done = 0
      this.count.delay = 0
      const _id = this.loginUser.staffId
      getStaffTask(_id).then(res => {
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
    taskState (state) {
      this.taskData = []
      const _id = this.loginUser.staffId
      getStaffTask(_id).then(res => {
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
            break
        }
      })
    },
    operationClick (type, data) {
      switch (type) {
        case 'person':
          this.$router.push('/elderlyHealthcare/setting/personal')
          break
        case 'back':
          this.$router.push('/elderlyHealthcare/service')
          break
        case 'quit':
          localStorage.removeItem('staffInfo')
          localStorage.removeItem('avatar')
          this.$router.push('/elderlyHealthcare/login')
          break
        case 'edit':
          this.$refs.taskModal.paramReceive('edit', data)
          break
        case 'more':
          this.$refs.taskModal.paramReceive('more', data)
          break
        case 'process':
          this.$refs.processModal.paramReceive('process', data)
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
    width: 0 !important;height: 0;
  }
  .head-workspace{
    margin: 10px 15px 0 15px;
  }
  .head-card{
    margin-top: 20px;
    padding: 10px;
    background-color: #ececec;
  }
  .card-title{
    vertical-align: middle;
    margin-left: 12px;
  }
  .calendar{
    width: 100%;
    border: 1px solid #d9d9d9;
    border-radius: 4px;
    margin-top: 10px;
    padding: 0 10px;
  }
  .task{
    margin-top: 5px;
    padding: 0px 10px;
    max-height: 40%;
    overflow: auto;
  }
  .task-list {
    height: 340px;
    overflow-y: auto;
  }
  .footer{
    height: 80px;
    line-height: 80px;
    text-align: center;
    font-size: 15px;
    background-color: #ECECEC;
  }
</style>
