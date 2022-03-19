<template>
  <div id="home">
    <a-layout id="topBanner">
      <a-layout-header>
        <div class="logo">疗养治理平台</div>
        <a-menu
          theme="dark"
          mode="horizontal"
          :default-selected-keys="['1']"
          :style="{ lineHeight: '64px' }"
        >
          <a-menu-item key="1" @click="routeMenu('service')">
            公共服务
          </a-menu-item>
          <a-menu-item key="2" @click="routeMenu('humanResource')">
            人力资源
          </a-menu-item>
          <a-menu-item key="3" @click="routeMenu('asset')">
            资产中心
          </a-menu-item>
          <a-menu-item key="4" @click="routeMenu('store')">
            仓储管理
          </a-menu-item>
          <a-dropdown class="settingMenu">
            <a-avatar
              size="large"
              :src="imgUrl"
            />
            <a-menu slot="overlay">
              <a-menu-item key="1">
                <a-icon type="smile" />
                <span @click="openSetting('personal')">我的首页</span>
              </a-menu-item>
              <a-menu-item key="2">
                <a-icon type="question-circle" />
                <span @click="openSetting('question')">问题反馈</span>
              </a-menu-item>
              <a-menu-item key="3">
                <a-icon type="disconnect" />
                <span @click="openSetting('quit')">退出登录</span>
              </a-menu-item>
            </a-menu>
          </a-dropdown>
        </a-menu>
      </a-layout-header>
    </a-layout>

    <a-layout class="sideBar">
      <a-layout-sider
        v-model="collapsed"
        :trigger="null"
        style="background-color: white"
        collapsible
      >
        <a-menu theme="light" mode="inline" :default-selected-keys="['1']">
          <a-icon
            class="trigger"
            :type="collapsed ? 'menu-unfold' : 'menu-fold'"
            @click="() => (collapsed = !collapsed)"
          />
          <a-menu-item key="1" @click="routePage('monitor')">
            <a-icon type="line-chart" />
            <span>数据监控</span>
          </a-menu-item>
          <a-menu-item key="2" @click="routePage('chart')">
            <a-icon type="dot-chart" />
            <span>数据大屏</span>
          </a-menu-item>
          <a-menu-item key="3" @click="routePage('access')">
            <a-icon type="user-add" />
            <span>入住登记</span>
          </a-menu-item>
          <a-menu-item key="4" @click="routePage('patient')">
            <a-icon type="idcard" />
            <span>病人管理</span>
          </a-menu-item>
          <a-menu-item key="5" @click="routePage('task')">
            <a-icon type="calendar" />
            <span>任务发布</span>
          </a-menu-item>
          <a-menu-item key="6" @click="routePage('logs')">
            <a-icon type="warning" />
            <span>系统日志</span>
          </a-menu-item>
        </a-menu>
      </a-layout-sider>

      <a-layout style="height: 94%">
        <div>
          <a-tabs v-model="activeKey"
                  type="editable-card"
                  @edit="onEdit"
                  style="margin: 10px 10px 0px 15px"
                  @change="tabChange"
                  hide-add
          >
            <a-tab-pane v-for="pane in panes"
                        :key="pane.key"
                        :tab="pane.title"
                        :closable="pane.closable"
                        @click="tabChange(pane.key)"
            />
          </a-tabs>
        </div>
        <a-layout-content
          :style="{ margin: '0px 16px 24px 16px', padding: '24px', background: '#fff'}"
          style="overflow: auto;"
        >
          <router-view v-if="isRouterAlive"/>
        </a-layout-content>
      </a-layout>
    </a-layout>
  </div>
</template>

<script>
export default {
  name: "Service",
  data() {
    const panes = [{ title: '数据监控', key: 'monitor', closable: false }]
    return{
      id: '',
      imgUrl: '',
      collapsed: false,
      newTabIndex: 0,
      panes,
      activeKey: panes[0].key,
      isRouterAlive: true
    }
  },
  provide() {
    return {
      // 路由刷新方法
      reload: this.reload
    }
  },
  mounted() {
    this.id = this.$route.query.id
    this.routePage('monitor')
    // 监控页面关闭
    // window.addEventListener('beforeunload', e => this.beforeunloadHandler(e))
    // 获取头像地址
    this.imgUrl = localStorage.getItem('avatar')
  },
  methods:{
    reload() {
      this.isRouterAlive = false
      this.$nextTick(function () {
        this.isRouterAlive = true
      })
    },
    beforeunloadHandler(e) {
      // 监控页面关闭
      // localStorage.removeItem('token')
    },
    openSetting(data){
      switch (data) {
        case 'quit':
          localStorage.removeItem('staffInfo')
          localStorage.removeItem('avatar')
          this.$router.push('/elderlyHealthcare/login')
          break
        case 'personal':
          this.$router.push('/elderlyHealthcare/home')
          break
        case 'question':
          this.$router.push('/elderlyHealthcare/setting/question')
          break
      }
    },
    routeMenu(data){
      this.$router.push(`/elderlyHealthcare/${data}`)
    },
    routePage(data) {
      this.addTabs(data)
    },
    tabChange(data) {
      this.$router.push(`/elderlyHealthcare/service/${data}`)
    },
    addTabs(data) {
      let flag = false
      // 遍历标签，重复不添加
      this.panes.forEach((pane) => {
        if (pane.key === data) {
          flag = true
          // 重新定位到对应的已添加标签
          this.activeKey = data
          return;
        }
      })
      if(flag === false) {
        let tabTitle
        // 判断 Tab 标题
        switch (data){
          case 'monitor':
            tabTitle = '数据监控'
            break
          case 'chart':
            tabTitle = '数据大屏'
            break
          case 'access':
            tabTitle = '入住登记'
            break
          case 'patient':
            tabTitle = '病人管理'
            break
          case 'task':
            tabTitle = '任务发布'
            break
          case 'logs':
            tabTitle = '系统日志'
            break
        }
        const panes = this.panes
        panes.push({
          title: tabTitle,
          key: data
        })
        this.panes = panes
        this.activeKey = data
        this.flag = false
      }
      this.tabChange(data)
    },
    onEdit(targetKey, action) {
      this[action](targetKey)
    },
    remove(targetKey) {
      // 删除自身回到第一个标签
      if(targetKey === this.activeKey){
        this.routePage('monitor')
      }
      let activeKey = this.activeKey
      let lastIndex
      this.panes.forEach((pane, i) => {
        if (pane.key === targetKey) {
          lastIndex = i - 1
        }
      });
      const panes = this.panes.filter(pane => pane.key !== targetKey)
      if (panes.length && activeKey === targetKey) {
        if (lastIndex >= 0) {
          activeKey = panes[lastIndex].key
        } else {
          activeKey = panes[0].key
        }
      }
      this.panes = panes
      this.activeKey = activeKey
    }
  }
}
</script>

<style scoped>
  #home{
    width: 100%;
    height: 100%;
    position: absolute;
    overflow: hidden;
  }
  #topBanner .logo {
    width: 120px;
    height: 31px;
    line-height: 31px;
    font-weight: bold;
    color: lightgray;
    font-size: 18px;
    background: rgba(255, 255, 255, 0.2);
    margin: 16px 28px 16px 0;
    padding-left: 7px;
    float: left;
  }
  .settingMenu{
    float: right;
    z-index: 1;
    margin: 12px 0px;
  }
  .sideBar{
    height: 100%;
  }
  .sideBar .trigger {
    font-size: 18px;
    line-height: 64px;
    padding: 0 30px;
    cursor: pointer;
    transition: color 0.3s;
  }
  .sideBar .trigger:hover {
    color: #1890ff;
  }
</style>
