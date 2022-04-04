<template>
  <div id="home">
    <a-layout id="top-banner">
      <a-layout-header>
        <router-link to="/elderlyHealthcare/home">
          <div class="logo">疗养治理平台</div>
        </router-link>
        <a-menu
          theme="dark"
          mode="horizontal"
          :default-selected-keys="['1']"
          :style="{ lineHeight: '64px' }"
        >
          <a-menu-item
            v-for="option in menuData.filter(item => item.menuType === 'top')"
            :key="option.menuKey"
            @click="routeMenu(option.routerName)"
          >{{ option.menuTitle }}</a-menu-item>
          <a-dropdown class="setting-menu">
            <a-avatar
              size="large"
              :src="imgUrl"
            />
            <a-menu slot="overlay">
              <a-menu-item
                v-for="option in menuData.filter(item => item.menuType === 'setting')"
                :key="option.menuKey"
                @click="openSetting(option.routerName)"
              >
                <a-icon :type="option.menuIcon" />
                <span>{{ option.menuTitle }}</span>
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
import { listHomeMenu } from '@/api/homeMenu'

export default {
  name: 'MainPage',
  data () {
    return {
      id: '',
      imgUrl: '',
      menuData: []
    }
  },
  provide () {
    return {
      reload: this.reload
    }
  },
  mounted () {
    this.getData()
    this.id = this.$route.query.id
    this.imgUrl = localStorage.getItem('avatar')
  },
  methods: {
    reload () {
      this.isRouterAlive = false
      this.$nextTick(function () {
        this.isRouterAlive = true
      })
    },
    getData () {
      listHomeMenu().then(res => {
        this.menuData = res.data
      })
    },
    openSetting (data) {
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
    routeMenu (data) {
      this.$router.push(`/elderlyHealthcare/${data}`)
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
