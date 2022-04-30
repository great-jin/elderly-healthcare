<template>
  <div>
    <a-row>
      <a-col :span="3" :style="{paddingLeft: '10px'}">
        <a-directory-tree
          @select="treeSelect"
          default-expand-all
        >
          <a-tree-node key="0" title="部门">
            <a-tree-node key="doctor" title="医师" is-leaf/>
            <a-tree-node key="nurse" title="护士" is-leaf/>
            <a-tree-node key="human" title="人事" is-leaf/>
            <a-tree-node key="logistics" title="后勤" is-leaf/>
            <a-tree-node key="other" title="其他" is-leaf/>
          </a-tree-node>
        </a-directory-tree>
      </a-col>
      <a-col :span="1">
      </a-col>
      <a-col :span="20" :style="{paddingLeft: '15px'}">
        <a-auto-complete
          placeholder="输入员工编号"
          :allowClear="true"
          style="width: 200px; float: right; z-index: 1; margin: 10px"
        />
        <a-table
          :columns="columns"
          :data-source="data"
          :pagination="pagination"
          :scroll="{ x: 1500}"
        >
          <template slot="action" slot-scope="text, record">
            <a-button type="link" @click="clickOption('more', record)">详情</a-button>
            <a-button type="link" @click="clickOption('download', record)">下载</a-button>
            <SalaryModal ref="salaryModal" />
          </template>
        </a-table>
      </a-col>
    </a-row>
  </div>
</template>

<script>
import { columns } from './const'
import SalaryModal from './salaryModal'
import { listNurse } from '@/api/staffNurse'
import { listDoctor } from '@/api/staffDoctor'
import { listOrganizeStaff } from '@/api/organizeStaff'

export default {
  name: 'SalaryManage',
  components: {
    SalaryModal
  },
  data () {
    return {
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
  computed: {
    columns () {
      return columns(this)
    }
  },
  created () {
    this.getData()
  },
  methods: {
    async getData () {
      await listNurse().then(res => {
        this.nurseList = res.data
      })
      await listDoctor().then(res => {
        this.doctorList = res.data
      })
      await listOrganizeStaff().then(res => {
        this.otherStaff = res.data
      })
      this.treeSelect(['doctor'])
    },
    treeSelect (keys) {
      let result = []
      switch (keys[0]) {
        case 'doctor':
          result = this.doctorList
          break
        case 'nurse':
          result = this.nurseList
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
    clickOption (type, data) {
      switch (type) {
        case 'more':
          this.$refs.salaryModal.paramReceive(data)
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
</style>
