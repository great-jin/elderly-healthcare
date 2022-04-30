<template>
  <a-drawer
    title="病人详情"
    width="55%"
    placement="right"
    :closable="true"
    :visible="visible"
    @close="cancel"
  >
    <div>
      <LineChart />
    </div>
  </a-drawer>
</template>

<script>
import LineChart from './chart/lineChart'
export default {
  name: 'CaseInfo',
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
    LineChart
  },
  data () {
    return {
      visible: false
    }
  },
  methods: {
    paramReceive (data) {
      this.visible = true
      console.log(data)
    },
    getData () {

    },
    cancel () {
      this.visible = false
    }
  }
}
</script>

<style scoped>
</style>
