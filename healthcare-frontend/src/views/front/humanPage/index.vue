<template>
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
          v-for="option in menus"
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
</template>

<script>
const panes = [
  { title: '请假审批', key: 'vacate', closable: false }
]

export default {
  name: 'human',
  data () {
    return {
      menus: [],
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
  created () {
    const _menu = JSON.parse(localStorage.getItem('routerInfo'))
    this.menuData = _menu.filter(item => item.isShow === 1)
    this.menus = this.menuData.filter(item => item.menuType === 'human')
    this.routePage('/elderlyHealthcare/human/vacate')
  },
  methods: {
    reload () {
      this.isRouterAlive = false
      this.$nextTick(function () {
        this.isRouterAlive = true
      })
    },
    routePage (data) {
      this.addTabs(data)
    },
    tabChange (data) {
      this.$router.push(data)
    },
    addTabs (data) {
      const routerName = data.substring(data.lastIndexOf('/') + 1)
      let flag = false
      // 遍历标签，重复不添加
      this.panes.forEach((pane) => {
        if (pane.key === routerName) {
          flag = true
          // 重新定位到对应的已添加标签
          this.activeKey = routerName
        }
      })
      if (flag === false) {
        // 获取 Tab 标题
        const tabArr = this.menuData.filter(item => item.menuType === 'human')
        const tabTitle = (tabArr.filter(item => item.routerName === data))[0].menuTitle
        const panes = this.panes
        panes.push({
          key: routerName,
          title: tabTitle
        })
        this.panes = panes
        this.activeKey = routerName
        this.flag = false
      }
      this.tabChange(data)
    },
    onEdit (targetKey, action) {
      this[action](targetKey)
    },
    remove (targetKey) {
      // 删除自身回到第一个标签
      if (targetKey === this.activeKey) {
        this.routePage('/elderlyHealthcare/human/vacate')
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
