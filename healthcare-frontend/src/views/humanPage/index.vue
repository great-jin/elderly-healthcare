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
        <a-icon
          class="trigger"
          :type="collapsed ? 'menu-unfold' : 'menu-fold'"
          @click="() => (collapsed = !collapsed)"
        />
        <a-menu theme="light" mode="inline" :default-selected-keys="['1']">
          <a-menu-item key="1" @click="routePage('vacate')">
            <a-icon type="team" />
            <span>请假审批</span>
          </a-menu-item>
          <a-menu-item key="2" @click="routePage('vacate')">
            <a-icon type="shop" />
            <span>人员调度</span>
          </a-menu-item>
          <a-menu-item key="3" @click="routePage('doctor')">
            <a-icon type="form" />
            <span>医师信息</span>
          </a-menu-item>
          <a-menu-item key="4" @click="routePage('staff')">
            <a-icon type="area-chart" />
            <span>员工管理</span>
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
  name: "HumanResource",
  data() {
    const panes = [{ title: '人员管理', key: 'staff', closable: false }]
    return{
      id: '',
      imgUrl: '',
      collapsed: false,
      newTabIndex: 0,
      panes,
      activeKey: panes[0].key
    }
  },
  mounted() {
    this.routePage('staff')
    // 获取头像地址
    this.imgUrl = localStorage.getItem('avatar')
  },
  methods:{
    openSetting(data){
      switch (data) {
        case 'quit':
          localStorage.removeItem('token')
          localStorage.removeItem('avatar')
          localStorage.removeItem('staffInfo')
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
        switch (data){
          case 'staff':
            tabTitle = '人员管理'
            break
          case 'doctor':
            tabTitle = '医师信息'
            break
          case 'vacate':
            tabTitle = '请假审批'
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
    tabChange(data) {
      this.$router.push(`/elderlyHealthcare/humanResource/${data}`)
    },
    onEdit(targetKey, action) {
      this[action](targetKey)
    },
    remove(targetKey) {
      // 删除自身回到第一个标签
      if(targetKey === this.activeKey){
        this.routePage('staff')
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
