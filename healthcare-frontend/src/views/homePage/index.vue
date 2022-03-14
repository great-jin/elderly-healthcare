<template>
  <div>
    <a-row>
      <a-col class="head" :span="24">
        <a-card
          title="工作台"
          style="width: 100%"
          :bordered="false"
          hoverable
        >
          <a-card-meta :title="userName" description="欢迎登录系统">
            <a-avatar
              size="large"
              slot="avatar"
              :src="imgUrl"
            />
          </a-card-meta>
          <template slot="actions" class="ant-card-actions">
            <span key="setting" @click="operationClick('person')">个人信息</span>
            <span key="edit" @click="operationClick('back')">系统后台</span>
            <span key="ellipsis" @click="operationClick('quit')">退出登录</span>
          </template>
        </a-card>
      </a-col>
    </a-row>

    <a-row>
      <a-col class="task" :span="16">
        <div style="background-color: #ececec; padding: 20px;">
          <a-row :gutter="16">
            <a-col :span="8">
              <a-card title="Card title" :bordered="false">
                <p>card content</p>
              </a-card>
            </a-col>
            <a-col :span="8">
              <a-card title="Card title" :bordered="false">
                <p>card content</p>
              </a-card>
            </a-col>
            <a-col :span="8">
              <a-card title="Card title" :bordered="false">
                <p>card content</p>
              </a-card>
            </a-col>
          </a-row>
        </div>

        <div style="margin: 10px 0px; padding: 5px">
          <a-card title="代办任务" style="width: 100%">
            <a-list
              class="task-list"
              :loading="loading"
              item-layout="horizontal"
              :data-source="data"
            >
              <div
                v-if="showLoadingMore"
                slot="loadMore"
                :style="{ textAlign: 'center', marginTop: '12px', height: '32px', lineHeight: '32px' }"
              >
                <a-spin v-if="loadingMore" />
                <a-button v-else @click="onLoadMore">
                  loading more
                </a-button>
              </div>
              <a-list-item slot="renderItem" slot-scope="item, index">
                <a-list-item-meta
                  :description="item.describe"
                >
                  <a slot="title" href="#">{{ item.name }}</a>
                </a-list-item-meta>
                <a slot="actions" @click="operationClick('edit')">编辑</a>
                <a slot="actions" @click="operationClick('more')">详情</a>
              </a-list-item>
            </a-list>
          </a-card>
        </div>
      </a-col>

      <a-col class="calendar" :span="7">
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
  </div>

</template>

<script>
export default {
  name: 'Home',
  data() {
    return {
      loading: true,
      loadingMore: false,
      showLoadingMore: true,
      imgUrl: '',
      userName: '',
      data: [{
        'gender': 'female',
        'name':'Clement',
        'describe': 'This is a describe.',
      }]
    }
  },
  mounted() {
    this.loading = false
    // 获取头像地址
    this.imgUrl = localStorage.getItem('avatar')
    this.userName = JSON.parse(localStorage.getItem('staffInfo')).userName
  },
  methods: {
    getData() {
      this.loadingMore = false
    },
    onLoadMore() {
      this.loadingMore = true;
      this.data = this.data.concat();
      this.loadingMore = false;
      this.$nextTick(() => {
        window.dispatchEvent(new Event('resize'));
      })
    },
    operationClick(data) {
      switch (data) {
        case 'person':
          this.$router.push('/elderlyHealthcare/setting/personal')
          break;
        case 'back':
          this.$router.push('/elderlyHealthcare/service')
          break;
        case 'quit':
          localStorage.removeItem('token')
          this.$router.push('/elderlyHealthcare/login')
          break;
        case 'edit':
          this.$message.info('edit')
          break;
        case 'more':
          this.$message.info('more')
          break;
      }
    },
    getListData(value) {
      let listData
      switch (value.date()) {
        case 8:
          listData = [
            { type: 'warning', content: 'This is warning event.' },
            { type: 'success', content: 'This is usual event.' },
          ]
          break
        default:
      }
      return listData || [];
    },
    getMonthData(value) {
      if (value.month() === 8) {
        return 1394;
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
    margin: 15px;
    padding: 15px;
    height: 40%;
    overflow: auto;
    border: brown 2px solid;
  }
  .task-list {
    min-height: 350px;
  }
  .calendar{
    margin: 15px;
    overflow: auto;
    max-height: 700px;
    border: #1890ff 2px solid;
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
