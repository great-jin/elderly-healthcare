<template>
  <div id="pie2" style="width: 100%; height: 300px;"/>
</template>

<script>
export default {
  name: 'pie2Chart',
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
      this.pie2Chart()
    })
    window.onresize = () => {
      this.pie2Chart()
    }
  },
  methods: {
    pie2Chart () {
      const graph = this.$echarts.init(document.getElementById('pie2'))
      const option = {
        title: {
          text: '病人分布',
          left: 'center',
          top: 'bottom',
          textStyle: {
            fontSize: 16
          }
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: 'top',
          left: 'center'
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: '45%',
            data: [
              { value: 1048, name: 'Search Engine' },
              { value: 735, name: 'Direct' },
              { value: 580, name: 'Email' },
              { value: 484, name: 'Union Ads' }
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
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
