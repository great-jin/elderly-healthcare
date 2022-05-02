<template>
  <div id="monitorLine" style="width: 100%; height: 400px;"/>
</template>

<script>
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
  mounted () {
    setTimeout(() => {
      this.lineChart()
    })
    window.onresize = () => {
      this.lineChart()
    }
  },
  methods: {
    lineChart () {
      const graph = this.$echarts.init(document.getElementById('monitorLine'))
      const option = {
        xAxis: {
          type: 'category',
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data: [120, 200, 150, 80, 70, 110, 130],
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
