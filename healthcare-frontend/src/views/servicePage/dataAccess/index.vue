<template>
  <div>
    <a-tabs type="card" @change="callback">
      <a-tab-pane key="1" tab="入住登记">
        <accessForm />
      </a-tab-pane>
      <a-tab-pane key="2" tab="登记信息">
        <a-table :columns="columns" :data-source="data">
          <a slot="action" slot-scope="text" href="javascript:;">Delete</a>
          <p slot="expandedRowRender" slot-scope="record" style="margin: 0">
            {{ record.description }}
          </p>
        </a-table>
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
import accessForm from './accessForm'
import {tableData, tableColumns} from "./const";

export default {
  name: "index",
  components: {
    accessForm,
  },
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
    callback(key) {
      console.log(key);
    }
  }
}
</script>

<style scoped>
</style>
