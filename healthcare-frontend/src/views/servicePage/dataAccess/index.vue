<template>
  <div>
    <a-tabs type="card" @change="callback">
      <a-tab-pane key="1" tab="入住登记">
        <accessForm />
      </a-tab-pane>
      <a-tab-pane key="2" tab="登记信息">
        <dataTable />
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
import accessForm from './accessForm'
import dataTable from './dataTable'

export default {
  name: "index",
  components: {
    accessForm,
    dataTable
  },
  data() {
    return {}
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
