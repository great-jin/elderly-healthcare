<template>
  <div id="home">
    <a-layout id="top-banner">
      <a-layout-header>
        <div class="logo">后台管理</div>
        <a-menu
          theme="dark"
          mode="horizontal"
          :default-selected-keys="['1']"
          :style="{ lineHeight: '64px' }"
        >
          <a-menu-item
            v-for="option in menuData.filter(item => item.menuType === 'root')"
            :key="option.menuKey"
            @click="routeMenu(option.routerName)"
          >{{ option.menuTitle }}</a-menu-item>
          <a-dropdown class="setting-menu">
            <a-avatar size="large" :src="imgUrl"/>
            <a-menu slot="overlay">
              <a-menu-item @click="quit">
                <span>退出登录</span>
              </a-menu-item>
            </a-menu>
          </a-dropdown>
        </a-menu>
      </a-layout-header>
    </a-layout>

    <router-view />
  </div>
</template>

<script>
export default {
  name: 'MainPage',
  data () {
    return {
      imgUrl: '',
      menuData: []
    }
  },
  created () {
    const _menu = JSON.parse(localStorage.getItem('routerInfo'))
    this.menuData = _menu.filter(item => item.isShow === 2)
    this.imgUrl = localStorage.getItem('avatar')
    this.$router.push('/elderlyHealthcare/service/chart')
  },
  methods: {
    routeMenu (data) {
      this.$router.push(data)
    },
    quit () {
      localStorage.removeItem('avatar')
      localStorage.removeItem('loginUser')
      localStorage.removeItem('routerInfo')
      this.$router.push('/elderlyHealthcare/login')
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
#top-banner .logo {
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
.setting-menu{
  float: right;
  z-index: 1;
  margin: 12px 0px;
}
</style>
