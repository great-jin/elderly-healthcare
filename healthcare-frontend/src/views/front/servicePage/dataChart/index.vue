<template>
  <div>
    <br/>
    <a-row style="width: 100%; height: 100%; margin-bottom: 70px">
      <a-col :span="8"><pie1Chart /></a-col>
      <a-col :span="8"><pie2Chart /></a-col>
      <a-col :span="8"><pie3Chart /></a-col>
    </a-row>
    <a-row style="width: 100%; height: 100%;">
      <a-col :span="12" style="padding: 0 15px"><line1Chart /></a-col>
      <a-col :span="12" style="padding: 0 15px"><line2Chart /></a-col>
    </a-row>
  </div>
</template>

<script>
import pie1Chart from './pie1Chart'
import pie2Chart from './pie2Chart'
import pie3Chart from './pie3Chart'
import line1Chart from './line1Chart'
import line2Chart from './line2Chart'

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
    pie2Chart,
    pie3Chart,
    line1Chart,
    line2Chart
  }
}
</script>

<style scoped>
</style>
