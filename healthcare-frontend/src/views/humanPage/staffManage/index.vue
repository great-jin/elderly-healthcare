<template>
  <div>
    <div class="tree">
      <a-directory-tree multiple default-expand-all @select="onSelect" @expand="onExpand">
        <a-tree-node key="0-0" title="parent 0">
          <a-tree-node key="0-0-0" title="leaf 0-0" is-leaf />
          <a-tree-node key="0-0-1" title="leaf 0-1" is-leaf />
        </a-tree-node>
        <a-tree-node key="0-1" title="parent 1">
          <a-tree-node key="0-1-0" title="leaf 1-0" is-leaf />
          <a-tree-node key="0-1-1" title="leaf 1-1" is-leaf />
        </a-tree-node>
      </a-directory-tree>
    </div>

    <div class="table">
      <a-button
        style="float: left; z-index: 1; margin: 10px"
        type="primary"
      >新增</a-button>
      <a-auto-complete
        placeholder="输入查询账号"
        :allowClear="true"
        style="width: 200px; float: right; z-index: 1; margin: 10px"
      />

      <a-table
        :columns="columns"
        :data-source="data"
        :scroll="{ x: 1300, y: 310}"
      >
        <a slot="action" slot-scope="text" href="javascript:;">操作</a>
      </a-table>
    </div>

  </div>
</template>

<script>
import { tableColumns, tableData } from "./const";

export default {
  data() {
    return {
      data: [],
      columns: []
    }
  },
  mounted() {
    this.data = tableData
    this.columns = tableColumns
  },
  methods: {
    onSelect(keys, event) {
      console.log('Trigger Select', keys, event);
    },
    onExpand() {
      console.log('Trigger Expand');
    },
  },
};
</script>

<style>
   .tree{
     width: 15%;
     float: left;
     z-index: 1;
     border: #1890ff 2px solid
   }
   .table{
     width: 80%;
     float: right;
     z-index: 1;
     border: #1890ff 2px solid
   }
</style>
