<template>
  <div id="pie3" style="width: 100%; height: 300px;"/>
</template>

<script>
export default {
  name: 'pie3Chart',
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
      this.pie3Chart()
    })
    window.onresize = () => {
      this.pie3Chart()
    }
  },
  methods: {
    pie3Chart () {
      const graph = this.$echarts.init(document.getElementById('pie3'))
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
            radius: ['40%', '55%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: false,
              position: 'center'
            },
            labelLine: {
              show: false
            },
            data: [
              { value: 1048, name: 'Search Engine' },
              { value: 735, name: 'Direct' },
              { value: 580, name: 'Email' },
              { value: 484, name: 'Union Ads' }
            ]
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
