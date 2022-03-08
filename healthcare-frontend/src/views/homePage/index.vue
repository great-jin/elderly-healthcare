<template>
  <div id="home">
    <div style="height: 60px; width: 100%; background: blueviolet">
      <span>上标题</span>
    </div>
    <div style="height: 100%; width: 60px; background: #14C6CC; float: left">
      <span>左标题</span>
    </div>

    <a-layout class="sideBar">
      <a-layout-sider v-model="collapsed" :trigger="null" collapsible>
        <div class="logo" />
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
        </a-menu>
      </a-layout-sider>
      <a-layout>
        <a-layout-header style="background: #fff; padding: 0">
          <a-icon
            class="trigger"
            :type="collapsed ? 'menu-unfold' : 'menu-fold'"
            @click="() => (collapsed = !collapsed)"
          />
          <a-dropdown type="primary" style="float: right; z-index: 1; margin: 15px" >
            <a-button  style="margin-left: 8px">
              <a-icon type="setting" />
            </a-button>
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
        </a-layout-header>
        <a-layout-content :style="{ margin: '24px 16px', padding: '24px', background: '#fff', minHeight: '280px' }">
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
    this.routePage('chart')
    this.id = this.$route.query.id
    window.addEventListener('beforeunload', e => this.beforeunloadHandler(e))
  },
  methods:{
    beforeunloadHandler(e) {
      // 监控页面关闭
      // localStorage.setItem('token', '0')
    },
    routePage(data) {
      switch (data){
        case 'chart':
          this.$router.push('/home/chart')
          break
        case 'user':
          this.$router.push('/home/user')
          break
        case 'staff':
          this.$router.push('/home/staff')
          break
        case 'patient':
          this.$router.push('/home/user')
          break
        case 'store':
          this.$router.push('/home/store')
          break
        case 'warehouse':
          this.$router.push('/home/warehouse')
          break
      }
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
    }
  }
}
</script>

<style scoped>
  #home{
    height: 100%;
    position: absolute;
    top: 0px;
    left: 0px;
    width: 100%;
  }
  .sideBar{
    height: 100%;
  }
  .sideBar .trigger {
    font-size: 18px;
    line-height: 64px;
    padding: 0 24px;
    cursor: pointer;
    transition: color 0.3s;
  }
  .sideBar .trigger:hover {
    color: #1890ff;
  }
  .sideBar .logo {
    height: 32px;
    background: rgba(255, 255, 255, 0.2);
    margin: 16px;
  }
</style>
