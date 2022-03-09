<template>
  <div id="home">
    <a-layout id="topBanner">
      <a-layout-header>
        <div class="logo" />
        <a-menu
          theme="dark"
          mode="horizontal"
          :default-selected-keys="['1']"
          :style="{ lineHeight: '64px' }"
        >
          <a-menu-item key="1" @click="routeMenu('service')">
            公共服务
          </a-menu-item>
          <a-menu-item key="2" @click="routeMenu('human')">
            人力资源
          </a-menu-item>
          <a-menu-item key="3" @click="routeMenu('order')">
            订单采购
          </a-menu-item>
          <a-menu-item key="4" @click="routeMenu('store')">
            仓储管理
          </a-menu-item>
          <a-dropdown class="settingMenu">
            <a-button type="primary"><a-icon type="setting" /></a-button>
            <a-menu slot="overlay">
              <a-menu-item key="1">
                <a-icon type="smile" />
                <span @click="openSetting('personal')">个人中心</span>
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
            <a-icon type="area-chart" />
            <span>数据监控</span>
          </a-menu-item>
          <a-menu-item key="2" @click="routePage('chart')">
            <a-icon type="form" />
            <span>数据展示</span>
          </a-menu-item>
          <a-menu-item key="3" @click="routePage('access')">
            <a-icon type="team" />
            <span>入住登记</span>
          </a-menu-item>
          <a-menu-item key="4" @click="routePage('patient')">
            <a-icon type="shop" />
            <span>病人管理</span>
          </a-menu-item>
          <a-menu-item key="5" @click="routePage('logs')">
            <a-icon type="file-protect" />
            <span>系统日志</span>
          </a-menu-item>
        </a-menu>
      </a-layout-sider>

      <a-layout style="height: 94%">
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
          >
          </a-tab-pane>
        </a-tabs>
        <a-layout-content
          :style="{ margin: '0px 16px 24px 16px', padding: '24px', background: '#fff'}"
          style="overflow: auto;"
        >
          <router-view />
        </a-layout-content>
      </a-layout>
    </a-layout>
  </div>
</template>

<script>
export default {
  name: "Service",
  data() {
    const panes = [{ title: '数据监控', content: 'Content of 数据监控', key: '数据监控', closable: false }]
    return{
      id: '',
      collapsed: false,
      newTabIndex: 0,
      panes,
      activeKey: panes[0].key,
    }
  },
  mounted() {
    this.id = this.$route.query.id
    this.routePage('monitor')
    // 监控页面关闭
    // window.addEventListener('beforeunload', e => this.beforeunloadHandler(e))
  },
  methods:{
    beforeunloadHandler(e) {
      // 监控页面关闭
      // localStorage.setItem('token', '0')
    },
    openSetting(data){
      switch (data) {
        case 'quit':
          localStorage.setItem('token', '0')
          this.$router.push('/')
          break
        case 'personal':
          this.$router.push('/setting/personal')
          break
        case 'question':
          this.$router.push('/setting/question')
          break
      }
    },
    routeMenu(data){
      switch (data) {
        case 'service':
          this.$router.push('/service')
          break
        case 'human':
          this.$router.push('/humansouce')
          break
        case 'order':
          this.$router.push('/order')
          break
        case 'store':
          this.$router.push('/store')
          break
      }
    },
    routePage(data) {
      switch (data){
        case 'monitor':
          this.tabEstimate('数据监控')
          this.$router.push('/service/monitor')
          break
        case 'chart':
          this.tabEstimate('数据展示')
          this.$router.push('/service/chart')
          break
        case 'access':
          this.tabEstimate('入住登记')
          this.$router.push('/service/access')
          break
        case 'patient':
          this.tabEstimate('病人管理')
          this.$router.push('/service/patient')
          break
        case 'logs':
          this.tabEstimate('系统日志')
          this.$router.push('/service/logs')
          break
      }
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
    },
    tabEstimate(data) {
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
        const panes = this.panes
        panes.push({
          title: data,
          content: `${<router-view />}`,
          key: data
        })
        this.panes = panes
        this.activeKey = data
        this.flag = false
      }
    },
    tabChange(data) {
      switch (data){
        case '数据监控':
          this.$router.push('/service/monitor')
          break
        case '数据展示':
          this.$router.push('/service/chart')
          break
        case '入住登记':
          this.$router.push('/service/access')
          break
        case '病人管理':
          this.$router.push('/service/patient')
          break
        case '系统日志':
          this.$router.push('/service/logs')
          break
      }
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
    background: rgba(255, 255, 255, 0.2);
    margin: 16px 28px 16px 0;
    float: left;
  }
  .settingMenu{
    float: right;
    z-index: 1;
    margin: 17px 0px;
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
