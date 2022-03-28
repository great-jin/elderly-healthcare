<template>
  <div>
    <a-auto-complete
      v-model="accountCode"
      placeholder="输入查询账号"
      :data-source="dataSource"
      :allowClear="true"
      @search="onSearch"
      @select="onSelect"
      class="auto-search"
    />

    <a-table
      :columns="columns"
      :data-source="patientData"
      :pagination="{ pageSize: 5 }"
      :bordered="false"
      style="padding: 10px"
    >
      <template slot="operation" slot-scope="record">
        <a-button type="link" @click="operationClick('detail', record)">详情</a-button>
        <a-button type="link" @click="operationClick('edit', record)" >修改 </a-button>
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
      accountCode: ''
    }
  },
  mounted() {
    List().then(res =>{
      this.patientData = res.data
    })
  },
  methods: {
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
  .auto-search{
    width: 200px;
    float: right;
    z-index: 1;
    margin-bottom: 20px;
  }
</style>
