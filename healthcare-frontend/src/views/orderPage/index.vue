<template>
  <div id="home">
    <a-layout id="topBanner">
      <a-layout-header>
        <div class="logo" />
        <a-menu
          theme="dark"
          mode="horizontal"
          :default-selected-keys="['3']"
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
          <a-menu-item key="1" @click="routePage('medicine')">
            <a-icon type="area-chart" />
            <span>药品采购</span>
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
    const panes = [{ title: '药品采购', key: '药品采购', closable: false }]
    return{
      id: '',
      collapsed: false,
      newTabIndex: 0,
      panes,
      activeKey: panes[0].key
    }
  },
  mounted() {
    this.routePage('medicine')
  },
  methods:{
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
        case 'medicine':
          this.$router.push('/order/medicine')
          break
      }
    },
    onEdit(targetKey, action) {
      this[action](targetKey)
    },
    remove(targetKey) {
      // 删除自身回到第一个标签
      if(targetKey === this.activeKey){
        this.routePage('medicine')
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
          key: data
        })
        this.panes = panes
        this.activeKey = data
        this.flag = false
      }
    },
    tabChange(data) {
      switch (data){
        case '药品采购':
          this.$router.push('/order/medicine')
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
