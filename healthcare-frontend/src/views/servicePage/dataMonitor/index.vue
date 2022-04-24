<template>
  <div>
    <a-row style="margin-bottom: 15px; font-weight: 600">
      <a-col :span="24" style="text-align: center"><h2>数据详情</h2></a-col>
    </a-row>
    <a-row style="width: 100%; height: 100%; margin-bottom: 70px">
      <a-col :span="12"><pieChart /></a-col>
      <a-col :span="12"><lineChart /></a-col>
    </a-row>
  </div>
</template>

<script>
import pieChart from './pieChart'
import lineChart from './lineChart'

export default {
  name: 'DataChart',
  props: {
    width: {
      type: String,
      default: null
    },
    height: {
      type: String,
      default: null
    }
  },
  components: {
    pieChart,
    lineChart
  }
}
</script>

<style scoped>
</style>
