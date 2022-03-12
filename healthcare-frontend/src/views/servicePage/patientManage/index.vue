<template>
  <div>
    <div style="margin: 10px">
      <a-button
        type="primary"
        @click="operationClick('add', null)"
      >新增</a-button>

      <a-input-search
        v-model="accountCode"
        placeholder="输入账号进行查询"
        style="width: 200px; float: right; z-index: 1"
        @search="onSearch()"
      />
    </div>

    <a-table
      :columns="columns"
      :data-source="data"
      :pagination="{ pageSize: 5 }"
      :bordered="false"
    >
      <template slot="operation" slot-scope="text, record, index">
        <a-button type="link" @click="operationClick('detail', record.key)">详情</a-button>
        <a-button type="link" @click="operationClick('edit', record.key)" >修改 </a-button>
      </template>
    </a-table>

    <patientModal ref="patientModal" />
  </div>
</template>

<script>
import { List, getUser } from '@/api/user.js';
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
      accountCode: ''
    }
  },
  mounted() {
    List().then(res =>{
      const _res = res.data
      for(let i in _res){
        this.data.push({
          key: _res[i].accountID,
          id: _res[i].id,
          password: _res[i].password,
          accountID: _res[i].accountID,
          userName: _res[i].userName,
        });
      }
    })
    this.columns = tableColumns
  },
  methods: {
    onSearch() {
      this.data = []
      const code = this.accountCode
      if (code !== ''){
        getUser(code).then(res =>{
          if(res.data.id != null){
            this.data.push(res)
          } else {
            this.$message.error('未查询到结果')
            this.reload()
          }
        })
      } else {
        this.reload()
      }
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
          this.$refs.patientModal.paramReceive(type, record)
          break
        case 'detail':
          this.$refs.patientModal.paramReceive(type, record)
          break
      }
    }
  }
}
</script>

<style scoped>
</style>
