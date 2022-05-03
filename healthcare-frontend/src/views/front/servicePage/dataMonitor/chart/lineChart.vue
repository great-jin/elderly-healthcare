<template>
  <a-row>
    <div id="monitorLine" style="width: 100%; height: 400px;"/>
  </a-row>
</template>

<script>
import {getCharDate} from "@/api/patientInfo";

export default {
  name: 'LineChart',
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
  data() {
    return {
      ageData: []
    }
  },
  mounted() {
    this.getData()
  },
  methods: {
    async getData() {
      await getCharDate().then(res => {
        this.ageData = res.data.map(item => item.value)
      })
      this.$nextTick(() => {
        this.$echarts.init(document.getElementById('monitorLine')).dispose()
        this.lineChart()
      })
    },
    lineChart() {
      const graph = this.$echarts.init(document.getElementById('monitorLine'))
      const option = {
        xAxis: {
          type: 'category',
          data: ['0~40', '40~55', '55~65', '65-100']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data: this.ageData,
            type: 'bar',
            showBackground: true,
            backgroundStyle: {
              color: 'rgba(180, 180, 180, 0.2)'
            }
          }
        ]
      }
      graph.setOption(option)
    }
  }
}
</script>

<style scoped>
</style>
