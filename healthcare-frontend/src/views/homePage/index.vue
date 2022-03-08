<template>
  <div id="home">
    <a-layout id="topBanner">
      <a-layout-header class="header">
        <div class="logo" />
        <a-menu
          theme="dark"
          mode="horizontal"
          :default-selected-keys="['1']"
          :style="{ lineHeight: '64px' }"
        >
          <a-menu-item key="1">
            人员管理
          </a-menu-item>
          <a-menu-item key="2" @click="routePage('menu')">
            考勤管理
          </a-menu-item>
          <a-dropdown type="primary" class="settingMenu">
            <a-button><a-icon type="setting" /></a-button>
            <a-menu slot="overlay">
              <a-menu-item key="1">
                <a-icon type="smile" />
                <span @click="openSetting('self')">个人中心</span>
              </a-menu-item>
              <a-menu-item key="2">
                <a-icon type="question-circle" />
                <span @click="openSetting('question')">问题反馈</span>
              </a-menu-item>
              <a-menu-item key="3">
                <a-icon type="disconnect" />
                <span @click="openSetting('exit')">退出登录</span>
              </a-menu-item>
            </a-menu>
          </a-dropdown>
        </a-menu>
      </a-layout-header>
    </a-layout>

    <a-layout class="sideBar">
      <a-layout-sider v-model="collapsed" :trigger="null" collapsible>
        <a-icon
          class="trigger"
          :type="collapsed ? 'menu-unfold' : 'menu-fold'"
          @click="() => (collapsed = !collapsed)"
        />
        <a-menu theme="dark" mode="inline" :default-selected-keys="['1']">
          <a-menu-item key="1" @click="routePage('chart')">
            <a-icon type="area-chart" />
            <span>数据监控</span>
          </a-menu-item>
          <a-menu-item key="2" @click="routePage('user')">
            <a-icon type="form" />
            <span>病人管理</span>
          </a-menu-item>
          <a-menu-item key="3" @click="routePage('staff')">
            <a-icon type="team" />
            <span>员工管理</span>
          </a-menu-item>
          <a-menu-item key="4" @click="routePage('store')">
            <a-icon type="shop" />
            <span>仓库管理</span>
          </a-menu-item>
          <a-menu-item key="5" @click="routePage('warehouse')">
            <a-icon type="file-protect" />
            <span>后勤管理</span>
          </a-menu-item>
          <a-menu-item key="6" @click="routePage('warehouse')">
            <a-icon type="file-protect" />
            <span>日志监控</span>
          </a-menu-item>
        </a-menu>
      </a-layout-sider>

      <a-layout style="height: 94%">
        <!--
        <a-layout-header style="background: #fff; padding: 0">
          <a-tabs type="editable-card" hide-add style="margin: 10px 25px 10px 25px">
            <a-tab-pane
              v-for="pane in tabData"
              :key="pane.key"
              :tab="pane.title"
              :closable="pane.closable"
            />
          </a-tabs>
        </a-layout-header>
        -->
        <a-layout-content
          :style="{ margin: '16px 24px', padding: '24px', background: '#fff'}"
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
  name: "Home",
  inject: ['reload'],
  data() {
    return{
      id: '',
      collapsed: false,
      tabTitle: '',
      tabData: [],
      tabIndex: 0
    }
  },
  mounted() {
    this.id = this.$route.query.id
    this.routePage('staff')
    window.addEventListener('beforeunload', e => this.beforeunloadHandler(e))
  },
  methods:{
    beforeunloadHandler(e) {
      // 监控页面关闭
      // localStorage.setItem('token', '0')
    },
    openSetting(data){
      switch (data) {
        case 'self':
          this.$router.push('/')
          break
        case 'question':
          this.$router.push('/')
          break
        case 'exit':
          this.$router.push('/')
          localStorage.setItem('token', '0')
          break
      }
    },
    routePage(data) {
      const activeKey = this.tabIndex++;
      switch (data){
        case 'chart':
          this.tabData.push({
            title: `数据监控`,
            key: activeKey
          })
          this.$router.push('/home/chart')
          break
        case 'user':
          this.$router.push('/home/user')
          break
        case 'staff':
          this.tabTitle = '员工管理'
          this.$router.push('/home/staff')
          break
        case 'patient':
          this.tabTitle = '病人信息'
          this.$router.push('/home/user')
          break
        case 'store':
          this.tabTitle = '库存管理'
          this.$router.push('/home/store')
          break
        case 'warehouse':
          this.tabTitle = '仓库管理'
          this.$router.push('/home/warehouse')
          break
        case 'menu':
          this.$router.push('/home/menu')
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
