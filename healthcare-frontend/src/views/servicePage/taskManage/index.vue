<template>
  <div>
    <a-tabs type="card" :activeKey="tabActivity">
      <a-tab-pane key="1" tab="任务大屏" style="padding: 10px 0px">
        <a-button
          type="primary"
          @click="changeTab('2')"
          style="margin-bottom: 20px"
        >
          发布任务
        </a-button>
        <a-table :columns="columns" :data-source="taskData">
          <a slot="name" slot-scope="text">{{ text }}</a>
          <span slot="customTitle"><a-icon type="smile-o" /> Name</span>
          <span slot="tags" slot-scope="tags">
          <a-tag
            v-for="tag in tags"
            :key="tag"
            :color="tag === 'loser' ? 'volcano' : tag.length > 5 ? 'geekblue' : 'green'"
          >
            {{ tag.toUpperCase() }}
          </a-tag>
          </span>
          <span slot="action" slot-scope="text, record">
            <a>Delete</a>
            <a-divider type="vertical" />
            <a class="ant-dropdown-link"> More actions <a-icon type="down" /> </a>
          </span>
        </a-table>
      </a-tab-pane>
      <a-tab-pane key="2" tab="任务发布">
        <taskForm @backTab="changeTab" />
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
import taskForm from './taskForm'
import { columns, taskData } from './const'

export default {
  name: 'index',
  components: {
    taskForm
  },
  data () {
    return {
      type: 'add',
      columns,
      taskData,
      tabActivity: '1'
    }
  },
  methods: {
    changeTab (data) {
      this.tabActivity = data
    }
  }
}
</script>

<style scoped>

</style>
