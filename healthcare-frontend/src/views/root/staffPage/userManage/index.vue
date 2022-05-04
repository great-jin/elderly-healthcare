<template>
  <div>
    <a-row>
      <a-col :span="3" :style="{paddingLeft: '10px'}">
        <a-directory-tree
          @select="treeSelect"
          default-expand-all
        >
          <a-tree-node key="0" title="单位部门">
            <a-tree-node key="doctor" title="医师" is-leaf/>
            <a-tree-node key="nurse" title="护理员" is-leaf/>
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
          style="width: 200px; float: left; z-index: 1; margin: 10px"
        />
        <a-table
          :columns="columns"
          :data-source="data"
          :pagination="pagination"
          :scroll="{ x: 1600}"
        >
          <template slot="action" slot-scope="text, record">
            <a-button type="link" @click="clickOption('power', record)">开通</a-button>
            <a-button type="link" @click="clickOption('edit', record)">编辑</a-button>
          </template>
        </a-table>
      </a-col>
    </a-row>

    <PowerModal ref="powerModal" />
  </div>
</template>

<script>
import { columns } from './const'
import PowerModal from './powerModal'
import { listNurse } from '@/api/staffNurse'
import { listDoctor } from '@/api/staffDoctor'
import { listOrganizeStaff } from '@/api/organizeStaff'
import { getUser } from '@/api/loginUser'

export default {
  name: 'StaffManage',
  components: {
    PowerModal
  },
  data () {
    return {
      data: [],
      treeKeys: '',
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
    getData () {
      listNurse().then(res => {
        this.nurseList = res.data
      })
      listDoctor().then(res => {
        this.doctorList = res.data
        this.treeSelect(['doctor'])
      })
      listOrganizeStaff().then(res => {
        this.otherStaff = res.data
      })
    },
    treeSelect (keys) {
      this.treeKeys = keys[0]
      let result = []
      switch (keys[0]) {
        case '0':
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
        case '1':
        case 'other':
          result = this.otherStaff.filter(item => item.organizeId !== 'human' && item.organizeId !== 'logistics')
          break
      }
      this.data = result
    },
    async clickOption (type, data) {
      let result = {}
      await getUser(data.staffId).then(res => {
        result = res.data
      })
      let isOpen = false
      if (result.staffId !== undefined) {
        isOpen = true
      }
      // 已开通账号无法重复开通
      // 未开通账号无法进行编辑
      switch (type) {
        case 'power':
          if (!isOpen) {
            this.$refs.powerModal.paramReceive(type, data)
          } else {
            this.$message.error('员工已开通账号')
          }
          break
        case 'edit':
          if (isOpen) {
            this.$refs.powerModal.paramReceive(type, data)
          } else {
            this.$message.error('员工尚未开通账号')
          }
          break
      }
    }
  }
}
</script>

<style>
</style>
