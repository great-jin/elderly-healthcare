<template>
  <div id="home">
    <a-layout class="sideBar">
      <a-layout-sider v-model="collapsed" :trigger="null" collapsible>
        <div class="logo" />
        <a-menu theme="dark" mode="inline" :default-selected-keys="['1']">
          <a-menu-item key="1">
            <a-icon type="user" />
            <span>nav 1</span>
          </a-menu-item>
          <a-menu-item key="2">
            <a-icon type="video-camera" />
            <span>nav 2</span>
          </a-menu-item>
          <a-menu-item key="3">
            <a-icon type="upload" />
            <span>nav 3</span>
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
          <a-dropdown
            type="primary"
            style="float: right; z-index: 1; margin: 15px"
          >
            <a-button type="primary" style="margin-left: 8px"><a-icon type="setting"/>设置</a-button>
            <a-menu slot="overlay">
              <a-menu-item key="1">
                <a-icon type="disconnect" />1st
              </a-menu-item>
              <a-menu-item key="2">
                <a-icon type="disconnect" />2nd
              </a-menu-item>
              <a-menu-item key="3" @click="exit">
                <a-icon type="disconnect" />退出
              </a-menu-item>
            </a-menu>
          </a-dropdown>
        </a-layout-header>
        <a-layout-content
          :style="{ margin: '24px 16px', padding: '24px', background: '#fff', minHeight: '280px' }"
        >
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
  created() {
    this.id = this.$route.query.id
  },
  methods:{
    exit(){
      this.$router.push('/')
      localStorage.setItem('token', '0')
    },
    handleMenuClick(e) {
      console.log('click', e);
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
