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
      <LineChart v-if="flag" :patientId="patientId"/>
    </div>
  </a-drawer>
</template>

<script>
import LineChart from './infoChart'

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
      visible: false,
      patientId: '',
      flag: false
    }
  },
  methods: {
    paramReceive (data) {
      this.visible = true
      this.flag = true
      this.patientId = data
    },
    cancel () {
      this.visible = false
      this.flag = false
    }
  }
}
</script>

<style scoped>
</style>
