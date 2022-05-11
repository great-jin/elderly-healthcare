<template>
  <div>
    <a-row>
      <a-col :span="3" :style="{paddingLeft: '10px'}">
        <a-directory-tree
          @select="treeSelect"
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
      </a-col>
      <a-col :span="1">
      </a-col>
      <a-col :span="20" :style="{paddingLeft: '15px'}">
        <a-button
          @click="clickOption('add',null)"
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
          :scroll="{ x: 1600}"
        >
          <template slot="action" slot-scope="text, record">
            <a-button type="link" @click="clickOption('more', record)">详情</a-button>
            <a-button type="link" @click="clickOption('edit', record)">更新</a-button>
          </template>
        </a-table>
      </a-col>
    </a-row>

    <InfoDrawer ref="infoDrawer" />
    <AccountModal ref="accountModal" />
  </div>
</template>

<script>
import { columns } from './const'
import InfoDrawer from './infoDrawer'
import { listNurse } from '@/api/staffNurse'
import { listDoctor } from '@/api/staffDoctor'
import { listOrganizeStaff } from '@/api/organizeStaff'

export default {
  name: 'StaffManage1',
  components: {
    InfoDrawer
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
    clickOption (type, data) {
      switch (type) {
        case 'add':
          this.$refs.infoDrawer.paramReceive(type, null, null)
          break
        case 'more':
        case 'edit':
          this.$refs.infoDrawer.paramReceive(type, this.treeKeys, data.staffId)
          break
      }
    }
  }
}
</script>

<style>
</style>
