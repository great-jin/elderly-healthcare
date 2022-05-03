<template>
  <div :style="{padding:'10px 20px'}">
    <a-row :style="{marginBottom:'30px'}">
      <pie2Chart/>
    </a-row>
    <a-row>
      <pie1Chart/>
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
