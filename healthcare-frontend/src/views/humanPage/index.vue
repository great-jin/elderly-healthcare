<template>
  <div id="home">
    <a-layout id="topBanner">
      <a-layout-header>
        <div class="logo" />
        <a-menu
          theme="dark"
          mode="horizontal"
          :default-selected-keys="['2']"
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
        <a-icon
          class="trigger"
          :type="collapsed ? 'menu-unfold' : 'menu-fold'"
          @click="() => (collapsed = !collapsed)"
        />
        <a-menu theme="light" mode="inline" :default-selected-keys="['1']">
          <a-menu-item key="1" @click="routePage('staff')">
            <a-icon type="area-chart" />
            <span>员工管理</span>
          </a-menu-item>
          <a-menu-item key="2" @click="routePage('doctor')">
            <a-icon type="form" />
            <span>医师信息</span>
          </a-menu-item>
          <a-menu-item key="3" @click="routePage('vacate')">
            <a-icon type="team" />
            <span>请假审批</span>
          </a-menu-item>
          <a-menu-item key="4" @click="routePage('dispatch')">
            <a-icon type="shop" />
            <span>人员调度</span>
          </a-menu-item>
        </a-menu>
      </a-layout-sider>

      <a-layout style="height: 94%">
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
      collapsed: false
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
    routePage(data) {
      switch (data){
        case 'staff':
          this.$router.push('/humansouce/staff')
          break
        case 'doctor':
          this.$router.push('/humansouce/doctor')
          break
        case 'vacate':
          this.$router.push('/humansouce/vacate')
          break
        case 'dispatch':
          this.$router.push('/humansouce/vacate')
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
