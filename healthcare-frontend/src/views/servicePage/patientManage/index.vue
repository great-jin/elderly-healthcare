<template>
  <div style="padding: 10px">
    <a-row style="margin-bottom: 30px;">
      <a-col :span="6">
        <b>账号：</b>
        <a-auto-complete
          v-model="accountCode"
          placeholder="输入查询账号"
          :data-source="dataSource"
          :allowClear="true"
          @search="onSearch"
          @select="onSelect"
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

    <a-table
      :columns="columns"
      :data-source="patientData"
      :pagination="{ pageSize: 5 }"
      :bordered="false"
    >
      <template slot="operation" slot-scope="record">
        <a-button type="link" @click="operationClick('detail', record)">详情</a-button>
        <a-button type="link" @click="operationClick('edit', record)" >更新 </a-button>
        <patientDrawer ref="patientDrawer" />
      </template>
    </a-table>
  </div>
</template>

<script>
import { List } from '@/api/test/user.js';
import { columns } from "./const";
import patientDrawer from "./patientDrawer";

export default {
  inject: ['reload'],
  components: {
    patientDrawer,
  },
  data() {
    return {
      value: '',
      columns,
      visible: false,
      patientData: [],
      dataSource: [],
      accountCode: '',
      staffList: [
        {
          staffId: '123',
          staffName: 'AA'
        }
      ]
    }
  },
  mounted() {
    List().then(res =>{
      this.patientData = res.data
    })
  },
  methods: {
    searchOk () {

    },
    searchCancel () {

    },
    onSearch(searchText) {
      this.dataSource = []
      this.patientData.forEach((user) => {
        if((user.accountID).includes(searchText)) {
          this.dataSource.push(user.accountID)
        }
      })
      if(searchText === '' ) {
        this.reload()
      }
    },
    onSelect(value) {
      this.patientData.forEach((user) => {
        if(value === user.accountID ) {
          this.patientData = [user]
          return;
        }
      })
    },
    async refresh () {
      await this.operationClick('reset')
    },
    async operationClick (type, record) {
      switch (type) {
        case 'reset':
          this.reload()
          break
        case 'edit':
          this.$refs.patientDrawer.paramReceive(type, record)
          break
        case 'detail':
          this.$refs.patientDrawer.paramReceive(type, record)
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
