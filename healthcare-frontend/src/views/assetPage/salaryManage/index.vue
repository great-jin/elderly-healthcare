<template>
  <div>
    <div class="tree">
      <a-directory-tree @select="onSelect" multiple default-expand-all>
        <a-tree-node key="0" title="医护人员">
          <a-tree-node key="0-1" title="医师" is-leaf />
          <a-tree-node key="0-2" title="护理员" is-leaf />
        </a-tree-node>
        <a-tree-node key="1" title="普通员工">
          <a-tree-node key="1-1" title="员工" is-leaf />
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
        :data-source="salaryData"
        :scroll="{ x: 1300, y: 310}"
      >
        <template slot="action" slot-scope="text, record, index">
          <a-button type="link" @click="operationClick('detail', record)">详情</a-button>
          <a-button type="link" @click="operationClick('edit', record)" >下载</a-button>
        </template>
      </a-table>
    </div>

  </div>
</template>

<script>
import { columns, salaryData } from "./const";

export default {
  data() {
    return {
      columns,
      salaryData
    }
  },
  methods: {
    onSelect(keys) {
      console.log(keys);
    },
    async operationClick (type, record) {
      switch (type) {
        case 'download':
          this.$message.info('下载')
          break
        case 'detail':
          this.$message.info('详情')
          break
      }
    }
  }
}
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
