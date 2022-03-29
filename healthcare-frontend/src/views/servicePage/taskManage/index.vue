<template>
  <div style="padding: 10px 20px">
    <div style="margin-bottom: 20px; color: white">
      <b>任务名称：</b>
      <a-select :allowClear="true" placeholder="请选择负责人" class="task-search">
        <a-select-option
          v-for="staff in staffList"
          :key="staff.staffId"
          :value="staff.staffId"
        >{{ staff.staffName }}</a-select-option>
      </a-select>
      <b>负责人：</b>
      <a-select :allowClear="true" placeholder="请选择负责人" class="task-search">
        <a-select-option
          v-for="staff in staffList"
          :key="staff.staffId"
          :value="staff.staffId"
        >{{ staff.staffName }}</a-select-option>
      </a-select>
      <b>负责病人：</b>
      <a-select :allowClear="true" placeholder="请选择负责人" class="task-search">
        <a-select-option
          v-for="staff in staffList"
          :key="staff.staffId"
          :value="staff.staffId"
        >{{ staff.staffName }}</a-select-option>
      </a-select>
      <b>创建时间：</b>
      <a-date-picker
        class="task-search"
        placeholder="请选择创建时间"
      />
      <a-button @click="searchCancel" class="task-search-button">重置</a-button>
      <a-button @click="searchOk" type="primary" class="task-search-button">查询</a-button>
    </div>

    <a-button
      type="primary"
      @click="openClick('add', null)"
      style="margin-bottom: 20px"
    >新建任务</a-button>
    <a-table
      :columns="columns"
      :data-source="taskData"
      :pagination="{ pageSize: 5 }"
    >
      <a-button slot="action" slot-scope="record" type="link" @click="openClick('edit', record)">编辑</a-button>
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
      columns,
      taskData,
      staffList: [
        {
          staffId: '123',
          staffName: 'AA'
        }
      ]
    }
  },
  methods: {
    openClick (type, data) {
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
    width: 10%;
    margin-right: 30px;
    margin-bottom: 15px;
  }
  .task-search-button{
    float: right;
    z-index: 1;
    width: 100px;
    margin-right: 20px;
  }
</style>
