<template>
  <div style="padding: 10px">
    <a-row style="margin-bottom: 30px;">
      <a-col :span="6">
        <b>账号：</b>
        <a-select :allowClear="true" placeholder="请选择负责人" class="task-search">
          <a-select-option
            v-for="staff in staffList"
            :key="staff.staffId"
            :value="staff.staffId"
          >{{ staff.staffName }}</a-select-option>
        </a-select>
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
        <a-button @click="refresh" class="task-search-button">重置</a-button>
        <a-button @click="searchOk" type="primary" class="task-search-button" style="margin-right: 7px">查询</a-button>
      </a-col>
    </a-row>

    <a-table
      :columns="columns"
      :data-source="patientCaseData"
      :bordered="false"
      :scroll="{ x: 900 }"
      :pagination="{ pageSize: 5 }"
    >
      <template slot="action" slot-scope="record">
        <a-button type="link" @click="clickOption('more', record)">详情</a-button>
        <a-button type="link" @click="clickOption('edit', record)">更新</a-button>
        <patientDrawer ref="patientDrawer" />
      </template>
    </a-table>
  </div>
</template>

<script>
import { columns } from "./const";
import patientDrawer from "./patientDrawer";
import { listCaseInfo } from '@/api/patientCaseInfo.js';

export default {
  inject: ['reload'],
  components: {
    patientDrawer,
  },
  data() {
    return {
      dataSource: [],
      patientCaseData: [],
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
  mounted() {
    this.getData()
  },
  methods: {
    getData() {
      listCaseInfo().then(res =>{
        this.patientCaseData = res.data
      })
    },
    searchOk () {

    },
    async refresh () {
      await this.clickOption('reset')
    },
    async clickOption (type, data) {
      switch (type) {
        case 'reset':
          this.reload()
          break
        case 'edit':
          this.$refs.patientDrawer.paramReceive(type, data)
          break
        case 'more':
          this.$refs.patientDrawer.paramReceive(type, data)
          break
      }
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
