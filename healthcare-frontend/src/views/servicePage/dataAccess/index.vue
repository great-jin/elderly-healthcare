<template>
  <div>
    <a-tabs type="card">
      <a-tab-pane key="1" tab="登记信息">
        <div style="margin: 15px 0; color: white">
          <b style="margin-left: 10px">任务名称：</b>
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

        <a-table
          :columns="columns"
          :data-source="accessData"
        >
          <template slot="action" slot-scope="record">
            <a-button type="link" @click="openDrawer('detail', record)">详情</a-button>
            <patientDrawer ref="patientDrawer" />
          </template>
        </a-table>
      </a-tab-pane>
      <a-tab-pane key="2" tab="入住登记">
        <accessForm />
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
import accessForm from './accessForm'
import patientDrawer from './patientDrawer'
import { columns, accessData } from './const'

export default {
  name: 'index',
  components: {
    accessForm,
    patientDrawer
  },
  data () {
    return {
      columns,
      accessData,
      staffList: [
        {
          staffId: '123',
          staffName: 'AA'
        }
      ]
    }
  },
  methods: {
    openDrawer (type, record) {
      this.$refs.patientDrawer.paramReceive(type, record)
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
