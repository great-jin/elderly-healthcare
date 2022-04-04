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
          :default-selected-keys="['2']"
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
    <a-layout class="side-bar">
      <a-layout-sider
        v-model="collapsed"
        :trigger="null"
        style="background-color: white"
        collapsible
      >
        <a-menu
          mode="inline"
          theme="light"
          :default-selected-keys="['1']"
        >
          <a-icon
            class="trigger"
            :type="collapsed ? 'menu-unfold' : 'menu-fold'"
            @click="() => (collapsed = !collapsed)"
          />
          <a-menu-item
            v-for="option in menuData.filter(item => item.menuType === 'human')"
            :key="option.menuKey"
            @click="routePage(option.routerName)"
          >
            <a-icon :type="option.menuIcon" />
            <span>{{ option.menuTitle }}</span>
          </a-menu-item>
        </a-menu>
      </a-layout-sider>

      <a-layout style="height: 94%">
        <div>
          <a-tabs
            v-model="activeKey"
            type="editable-card"
            @edit="onEdit"
            style="margin: 10px 10px 0px 15px"
            @change="tabChange"
            hide-add
          >
            <a-tab-pane
              v-for="pane in panes"
              :key="pane.key"
              :tab="pane.title"
              :closable="pane.closable"
              @click="tabChange(pane.key)"
            />
          </a-tabs>
        </div>
        <a-layout-content class="layout-content">
          <router-view v-if="isRouterAlive"/>
        </a-layout-content>
      </a-layout>
    </a-layout>
  </div>
</template>

<script>
import { listHomeMenu } from '@/api/homeMenu'
const panes = [
  { title: '人员管理', key: 'staff', closable: false }
]

export default {
  name: 'HumanResource',
  data () {
    return {
      id: '',
      imgUrl: '',
      menuData: [],
      collapsed: false,
      newTabIndex: 0,
      panes,
      activeKey: panes[0].key,
      isRouterAlive: true
    }
  },
  provide () {
    return {
      // 路由刷新方法
      reload: this.reload
    }
  },
  mounted () {
    this.getData()
    this.routePage('vacate')
    // 获取头像地址
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
    },
    routePage (data) {
      this.addTabs(data)
    },
    addTabs (data) {
      let flag = false
      // 遍历标签，重复不添加
      this.panes.forEach((pane) => {
        if (pane.key === data) {
          flag = true
          // 重新定位到对应的已添加标签
          this.activeKey = data
        }
      })
      if (flag === false) {
        const tabArr = this.menuData.filter(item => item.menuType === 'human')
        const tabTitle = (tabArr.filter(item => item.routerName === data))[0].menuTitle
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
    tabChange (data) {
      this.$router.push(`/elderlyHealthcare/humanResource/${data}`)
    },
    onEdit (targetKey, action) {
      this[action](targetKey)
    },
    remove (targetKey) {
      // 删除自身回到第一个标签
      if (targetKey === this.activeKey) {
        this.routePage('staff')
      }
      let activeKey = this.activeKey
      let lastIndex
      this.panes.forEach((pane, i) => {
        if (pane.key === targetKey) {
          lastIndex = i - 1
        }
      })
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
  .side-bar{
    height: 100%;
  }
  .side-bar .trigger {
    font-size: 18px;
    line-height: 64px;
    padding: 0 30px;
    cursor: pointer;
    transition: color 0.3s;
  }
  .side-bar .trigger:hover {
    color: #1890ff;
  }
  .layout-content {
    margin: 0px 16px 24px 16px;
    padding: 15px;
    background: #fff;
    overflow-y: auto;
    overflow-x: hidden
  }
</style>
