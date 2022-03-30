<template>
  <div style="padding: 10px 20px">
    <a-row style="margin-bottom: 30px;">
      <a-col :span="6">
        <b>账号：</b>
        <a-auto-complete
          placeholder="输入查询账号"
          :allowClear="true"
          class="task-search"
        />
      </a-col>
      <a-col :span="6">
        <b>任务名：</b>
        <a-select :allowClear="true" placeholder="请选择负责人" class="task-search">
          <a-select-option
            v-for="staff in staffList"
            :key="staff.staffId"
            :value="staff.staffId"
          >{{ staff.staffName }}</a-select-option>
        </a-select>
      </a-col>
      <a-col :span="6">
        <b>负责人：</b>
        <a-select :allowClear="true" placeholder="请选择负责人" class="task-search">
          <a-select-option
            v-for="staff in staffList"
            :key="staff.staffId"
            :value="staff.staffId"
          >{{ staff.staffName }}</a-select-option>
        </a-select>
      </a-col>
      <a-col :span="6">
        <a-button @click="searchCancel" class="task-search-button">重置</a-button>
        <a-button @click="searchOk" type="primary" class="task-search-button" style="margin-right: 7px">查询</a-button>
      </a-col>
    </a-row>

    <a-button
      type="primary"
      @click="clickOption('add', null)"
      style="margin-bottom: 20px"
    >新建任务</a-button>
    <a-table
      :columns="columns"
      :data-source="taskData"
      :pagination="{ pageSize: 5 }"
    >
      <a-button slot="action" slot-scope="record" type="link" @click="clickOption('edit', record)">编辑</a-button>
      <span slot="expandedRowRender" slot-scope="record" style="margin: 0">{{ record.taskContent }}</span>
    </a-table>

    <taskModal ref="taskModal" />
  </div>
</template>

<script>
import taskModal from './taskModal'
import { columns, taskData } from './const'

export default {
  name: 'index',
  components: {
    taskModal
  },
  data () {
    return {
      taskData,
      staffList: [
        {
          staffId: '123',
          staffName: 'AA'
        }
      ]
    }
  },
  computed: {
    columns () {
      return columns(this)
    }
  },
  methods: {
    clickOption (type, data) {
      switch (type) {
        case 'add':
          this.$refs.taskModal.paramReceive(type, data)
          break
        case 'edit':
          this.$refs.taskModal.paramReceive(type, data)
          break
      }
    },
    searchOk () {

    },
    searchCancel () {

    }
  }
}
</script>

<style scoped>
  .task-search{
    width: 65%;
    margin-right: 5px;
  }
  .task-search-button{
    float: right;
    z-index: 1;
  }
</style>
