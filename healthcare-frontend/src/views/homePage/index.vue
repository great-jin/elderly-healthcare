<template>
  <div style="overflow-x: hidden">
    <a-row>
      <a-col class="head" :span="24">
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
      </a-col>
    </a-row>

    <a-row>
      <a-col class="task" :span="16">
        <div style="background-color: #ececec; padding: 20px;">
          <a-row :gutter="16">
            <a-col :span="8">
              <a-card title="每日任务" :bordered="false" size="small">
                <a-tag color="pink">未办{{ count.act + count.delay }}</a-tag>
                <a-tag color="pink">超时{{ count.delay }}</a-tag>
              </a-card>
            </a-col>
            <a-col :span="8">
              <a-card title="病人总数" :bordered="false" size="small">
                <a-tag color="green">健康{{ count.delay }}</a-tag>
                <a-tag color="orange">需检查{{ count.delay }}</a-tag>
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

        <div style="margin: 10px 0px; padding: 5px;">
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
              </a-list-item>
            </a-list>
          </a-card>
        </div>
      </a-col>

      <a-col class="calendar" :span="8">
        <a-calendar >
          <ul slot="dateCellRender" slot-scope="value" class="events">
            <li v-for="item in getListData(value)" :key="item.content">
              <a-badge :status="item.type" :text="item.content" />
            </li>
          </ul>
          <template slot="monthCellRender" slot-scope="value">
            <div v-if="getMonthData(value)" class="notes-month">
              <section>{{ getMonthData(value) }}</section>
              <span>Backlog number</span>
            </div>
          </template>
        </a-calendar>
      </a-col>
    </a-row>

    <taskModal ref="taskModal"/>
  </div>

</template>

<script>
import taskModal from './taskModal'
import { getStaffTask } from '@/api/dailyTask'

export default {
  name: 'Home',
  components: {
    taskModal
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
      taskData: []
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
        console.log('res', res.data)
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
      }
    },
    getListData (value) {
      let listData
      switch (value.date()) {
        case 8:
          listData = [
            { type: 'warning', content: 'This is warning event.' },
            { type: 'success', content: 'This is usual event.' }
          ]
          break
        default:
      }
      return listData || []
    },
    getMonthData (value) {
      if (value.month() === 8) {
        return 1394
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
  .head{
    margin: 0px 15px;
  }
  .task{
    padding: 15px;
    max-height: 40%;
    overflow: auto;
    /*border: brown 2px solid;*/
  }
  .task-list {
    height: 365px;
    overflow-y: auto;
  }
  .calendar{
    overflow: auto;
    padding: 15px;
    max-height: 700px;
    /*border: #1890ff 2px solid;*/
  }
  .events {
    list-style: none;
    margin: 0;
    padding: 0;
  }
  .events .ant-badge-status {
    overflow: hidden;
    white-space: nowrap;
    width: 100%;
    text-overflow: ellipsis;
    font-size: 12px;
  }
  .notes-month {
    text-align: center;
    font-size: 28px;
  }
  .notes-month section {
    font-size: 28px;
  }
</style>
