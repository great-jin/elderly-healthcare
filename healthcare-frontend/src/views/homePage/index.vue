<template>
  <a-row id="home">
    <a-col class="head" :span="7">
      <a-card hoverable style="width: 300px">
        <img
          slot="cover"
          alt="example"
          src="http://47.100.200.104:9000/webtest/1.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=budai%2F20220313%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20220313T030754Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=0a2b92181917d684e483931a46cc81547eae9261145eccb19ed02b2d329f6c3f"
        />
        <template slot="actions" class="ant-card-actions">
          <span key="setting" @click="operationClick('person')">我的信息</span>
          <span key="edit" @click="operationClick('back')">进入后台</span>
          <span key="ellipsis" @click="operationClick('quit')">退出登录</span>
        </template>
        <a-card-meta :title="data[0].name" description="欢迎登录系统">
          <a-avatar
            slot="avatar"
            src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
          />
        </a-card-meta>
      </a-card>
    </a-col>

    <a-col class="task" :span="7">
      <sapan style="font-weight: bold">代办任务</sapan>
      <a-list
        class="demo-loadmore-list"
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
</template>
<script>
export default {data() {
    return {
      loading: true,
      loadingMore: false,
      showLoadingMore: true,
      data: [{
        'gender': 'female',
        'name':'Clement',
        'describe': 'This is a describe.',
      }]
    }
  },
  mounted() {
    this.loading = false
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
  #home{
    width: 100%;
    height: 100%;
    padding: 3% 1%;
    position: absolute;
    overflow: hidden;
  }
  .head{
    margin: auto 20px;
  }
  .task{
    height: 70%;
    margin: auto 20px;
    padding: 10px;
    overflow: auto;
    border: brown 2px solid;
  }
  .demo-loadmore-list {
    min-height: 350px;
  }
  .calendar{
    margin: auto 20px;
    height: 70%;
    overflow: auto;
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
