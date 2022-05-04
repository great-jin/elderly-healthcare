<template>
  <div>
    <a-row>
      <a-col :span="3" :style="{paddingLeft: '10px'}">
        <a-directory-tree
          @select="treeSelect"
          default-expand-all
        >
          <a-tree-node key="0" title="部门">
            <a-tree-node key="doctor" title="医生" is-leaf/>
            <a-tree-node key="nurse" title="护士" is-leaf/>
            <a-tree-node key="human" title="人事" is-leaf/>
            <a-tree-node key="logistics" title="后勤" is-leaf/>
            <a-tree-node key="other" title="全部" is-leaf/>
          </a-tree-node>
        </a-directory-tree>
      </a-col>
      <a-col :span="1">
      </a-col>
      <a-col :span="20" :style="{paddingLeft: '15px'}">
        <a-button
          type="primary"
          @click="addSalary"
          style="margin: 10px"
        >登记</a-button>
        <a-auto-complete
          placeholder="输入员工编号"
          :allowClear="true"
          style="width: 200px; float: right; z-index: 1; margin: 10px"
        />
        <a-table
          :columns="columns"
          :data-source="data"
          :pagination="pagination"
          :scroll="{ x: 1300}"
        >
          <template slot="action" slot-scope="text, record">
            <a-button type="link" @click="exportFile(record)">导出</a-button>
          </template>
        </a-table>
      </a-col>
    </a-row>

    <SalaryModal ref="salaryModal" />
  </div>
</template>

<script>
import {columns} from './const'
import {download} from "@/api/employeeSalary";
import SalaryModal from "./salaryModal";
import {listEmployeeSalary} from "@/api/employeeSalary";

export default {
  name: 'SalaryManage',
  components: {
    SalaryModal
  },
  data() {
    return {
      data: [],
      salaryList: [],
      pagination: {
        total: 0,
        defaultPageSize: 5,
        showSizeChanger: true,
        pageSizeOptions: ['5', '10', '20', '30'],
        showTotal: total => `共 ${total} 条数据`,
        onShowSizeChange: (current, pageSize) => this.pageSize = pageSize
      }
    }
  },
  computed: {
    columns() {
      return columns(this)
    }
  },
  created() {
    this.getData()
  },
  methods: {
    async getData() {
      await listEmployeeSalary().then(res => {
        this.salaryList = res.data
      })
      this.treeSelect(['doctor'])
    },
    treeSelect(keys) {
      let result = []
      switch (keys[0]) {
        case 'doctor':
          result = this.salaryList.filter(item => item.organizeId === 'doctor')
          break
        case 'nurse':
          result = this.salaryList.filter(item => item.organizeId === 'nurse')
          break
        case 'human':
          result = this.salaryList.filter(item => item.organizeId === 'human')
          break
        case 'logistics':
          result = this.salaryList.filter(item => item.organizeId === 'logistics')
          break
        case 'other':
          result = this.salaryList
          break
      }
      this.data = result
    },
    addSalary() {
      this.$refs.salaryModal.paramReceive()
    },
    exportFile(data) {
      const formData = new FormData()
      formData.append('staffId', data.staffId)
      download(formData)
    }
  }
}
</script>

<style>
</style>
