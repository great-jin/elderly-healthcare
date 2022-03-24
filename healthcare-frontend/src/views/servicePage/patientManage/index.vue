<template>
  <div>
    <div style="padding: 10px 25px">
      <a-button
        type="primary"
        @click="operationClick('add', null)"
      >新增</a-button>

      <a-auto-complete
        v-model="accountCode"
        placeholder="输入查询账号"
        :data-source="dataSource"
        :allowClear="true"
        style="width: 200px; float: right; z-index: 1"
        @search="onSearch"
        @select="onSelect"
      />
    </div>

    <a-table
      :columns="columns"
      :data-source="data"
      :pagination="{ pageSize: 5 }"
      :bordered="false"
      style="padding: 10px 25px"
    >
      <template slot="operation" slot-scope="text, record, index">
        <a-button type="link" @click="operationClick('detail', record)">详情</a-button>
        <a-button type="link" @click="operationClick('edit', record)" >修改 </a-button>
      </template>
    </a-table>

    <patientModal ref="patientModal" />
  </div>
</template>

<script>
import { List } from '@/api/user.js';
import { tableColumns } from "./const";
import patientModal from "./patientModal";

export default {
  inject: ['reload'],
  components: {
    patientModal
  },
  data() {
    return {
      data: [],
      tableData: [],
      columns: [],
      value: '',
      dataSource: [],
      accountCode: ''
    }
  },
  mounted() {
    List().then(res =>{
      this.data = res.data
    })
    this.columns = tableColumns
  },
  methods: {
    onSearch(searchText) {
      this.dataSource = []
      this.data.forEach((user) => {
        if((user.accountID).includes(searchText)) {
          this.dataSource.push(user.accountID)
        }
      })
      if(searchText === '' ) {
        this.reload()
      }
    },
    onSelect(value) {
      this.data.forEach((user) => {
        if(value === user.accountID ) {
          this.data = [user]
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
        case 'add':
          this.$refs.patientModal.paramReceive(type, record)
          break
        case 'edit':
          this.$refs.patientModal.paramReceive(type, record.accountID)
          break
        case 'detail':
          this.$refs.patientModal.paramReceive(type, record.accountID)
          break
      }
    }
  }
}
</script>

<style scoped>
</style>
