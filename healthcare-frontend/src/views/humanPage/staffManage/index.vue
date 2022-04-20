<template>
  <div>
    <div class="tree">
      <a-directory-tree
        @select="onSelect"
        default-expand-all
      >
        <a-tree-node key="0" title="医护部门">
          <a-tree-node key="doctor" title="医师" is-leaf/>
          <a-tree-node key="nurse" title="护理员" is-leaf/>
        </a-tree-node>
        <a-tree-node key="1" title="其他部门">
          <a-tree-node key="human" title="人事" is-leaf/>
          <a-tree-node key="logistics" title="后勤" is-leaf/>
          <a-tree-node key="other" title="其他" is-leaf/>
        </a-tree-node>
      </a-directory-tree>
    </div>

    <div class="table">
      <a-button
        style="float: left; z-index: 1; margin: 10px"
        type="primary"
      >新增
      </a-button>
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
          <a-button type="link" @click="clickOption('more', record)">详情</a-button>
          <a-button type="link" @click="clickOption('download', record)">下载</a-button>
        </template>
      </a-table>
    </div>

  </div>
</template>

<script>
import { columns } from './const'
import { listNurse } from '@/api/staffNurse'
import { listDoctor } from '@/api/staffDoctor'
import { listOrganizeStaff } from '@/api/organizeStaff'

export default {
  name: 'SalaryManage',
  data () {
    return {
      columns,
      data: [],
      nurseList: [],
      doctorList: [],
      otherStaff: [],
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
  methods: {
    getData () {
      listNurse().then(res => {
        this.nurseList = res.data
      })
      listDoctor().then(res => {
        this.doctorList = res.data
      })
      listOrganizeStaff().then(res => {
        this.otherStaff = res.data
      })
    },
    onSelect (keys) {
      let result = []
      switch (keys) {
        case 'doctor':
          result = this.nurseList
          break
        case 'nurse':
          result = this.doctorList
          break
        case 'human':
          result = this.otherStaff.filter(item => item.organizeId === 'human')
          break
        case 'logistics':
          result = this.otherStaff.filter(item => item.organizeId === 'logistics')
          break
        case 'other':
          result = this.otherStaff.filter(item => item.organizeId !== 'human' && item.organizeId !== 'logistics')
          break
      }
      this.data = result
    },
    clickOption (type, record) {
      switch (type) {
        case 'more':
          this.$message.info('详情')
          break
        case 'download':
          this.$message.info('下载')
          break
      }
    }
  }
}
</script>

<style>
.tree {
  width: 15%;
  float: left;
  z-index: 1;
  padding-top: 15px;
  padding-left: 10px;
  /*border: #1890ff 2px solid*/
}

.table {
  width: 83%;
  float: right;
  z-index: 1;
  /*border: #1890ff 2px solid*/
}
</style>
