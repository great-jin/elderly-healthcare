<template>
  <a-tabs type="card">
    <a-tab-pane
      key="1"
      tab="请假审批"
      :style="{padding: '0 10px'}"
    >
      <Vacate />
    </a-tab-pane>
    <a-tab-pane
      key="2"
      tab="物资审批"
      :style="{padding: '0 10px'}"
    >
      <Apply />
    </a-tab-pane>
      <a-tab-pane
        key="3"
        tab="采购审核"
        :style="{padding: '0 10px'}"
      >
      <Order />
    </a-tab-pane>
  </a-tabs>
</template>

<script>
import Vacate from './vacate/index'
import Apply from './apply/index'
import Order from './order/index'

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
