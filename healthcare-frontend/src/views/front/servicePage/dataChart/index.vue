<template>
  <div style="margin: auto 0">
    <a-row style="width: 100%; height: 100%; margin-bottom: 70px">
      <a-col :span="8"><pie2Chart /></a-col>
      <a-col :span="16"><pie1Chart /></a-col>
    </a-row>
  </div>
</template>

<script>
import pie1Chart from './pieChart/pie1Chart'
import pie2Chart from './pieChart/pie2Chart'

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
    pie1Chart,
    pie2Chart
  }
}
</script>

<style scoped>
</style>
