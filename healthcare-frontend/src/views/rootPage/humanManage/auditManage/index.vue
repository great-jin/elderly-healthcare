<template>

  <a-tabs type="card">
    <a-tab-pane key="1" tab="请假审批">
      <Vacate />
    </a-tab-pane>
    <a-tab-pane key="2" tab="物资审批">
      <Apply />
    </a-tab-pane>
    <a-tab-pane key="3" tab="采购审核">
      <Order />
    </a-tab-pane>
  </a-tabs>
</template>

<script>
import Vacate from './apply/index'
import Apply from './apply/index'
import Order from './apply/index'

export default {
  name: 'index',
  components: {
    Vacate,
    Apply,
    Order
  }
}
</script>

<style scoped>

</style>
