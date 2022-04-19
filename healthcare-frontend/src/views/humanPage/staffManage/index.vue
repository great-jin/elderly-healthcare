<template>
  <div>
    <div class="tree">
      <a-input-search
        style="margin-bottom: 8px"
        placeholder="输入姓名查询"
        @change="onChange"
      />
      <a-tree
        :expanded-keys="expandedKeys"
        :auto-expand-parent="autoExpandParent"
        @expand="onExpand"
      >
        <a-tree-node key="0" title="parent 0">
          <a-tree-node
            v-for="option in nurseList"
            :key="option.staffId"
            :title="option.staffName"
            is-leaf
          />
        </a-tree-node>
        <a-tree-node key="1" title="parent 1">
          <a-tree-node
            v-for="option in nurseList"
            :key="option.staffId"
            :title="option.staffName"
            is-leaf
          />
        </a-tree-node>
      </a-tree>
    </div>

    <div class="table">
      <a-button
        style="float: left; z-index: 1; margin: 10px"
        type="primary"
      >新增
      </a-button>
      <a-auto-complete
        placeholder="输入查询账号"
        :allowClear="true"
        style="width: 200px; float: right; z-index: 1; margin: 10px"
      />

      <a-table
        :columns="columns"
        :data-source="staffData"
        :pagination="pagination"
      >
        <a slot="action" slot-scope="record" href="javascript:;">操作</a>
      </a-table>
    </div>

  </div>
</template>

<script>
import { columns, staffData } from './const'

export default {
  data () {
    return {
      columns,
      staffData,
      nurseList: [
        {
          staffId: '张三',
          staffName: '张三'
        },
        {
          staffId: '王五',
          staffName: '王五'
        },
        {
          staffId: '李四',
          staffName: '李四'
        }
      ],
      doctorList: [],
      expandedKeys: [],
      autoExpandParent: true,
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
    onSelect (keys) {
      console.log(keys)
    },
    onExpand (expandedKeys) {
      this.expandedKeys = expandedKeys
      this.autoExpandParent = false
    },
    onChange (e) {
      const value = e.target.value
      this.autoExpandParent = true
      this.expandedKeys.push(value)
      if (value === '') {
        this.expandedKeys = []
      }
    }
  }
}
</script>

<style>
.tree {
  width: 20%;
  float: left;
  z-index: 1;
  border: #1890ff 2px solid
}

.table {
  width: 80%;
  float: right;
  z-index: 1;
  border: #1890ff 2px solid
}
</style>
