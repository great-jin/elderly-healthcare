<template>
  <div class="chart">
    <div id="pie" style="width: 70%; height: 100%; margin: 0 auto;"></div>
  </div>
</template>

<script>
export default {
  name: "DataChart",
  props: {
    // 设置容器的宽、高，解决外部设置无效问题
    width: {
      type: Number,
      default: null
    },
    height: {
      type: Number,
      default: null
    }
  },
  mounted() {
    this.pieChart()
  },
  methods: {
    pieChart(){
      // 通过 this.$echarts 来使用
      // document.getElementById()
      // document.getElementsByClassName() 不可用
      var pieGraph = this.$echarts.init(document.getElementById('pie'));
      // 配置图表信息
      var option = {
        legend: {},
        tooltip: {},
        dataset: {
          source: [
            ['product', '2012', '2013', '2014', '2015'],
            ['Matcha Latte', 41.1, 30.4, 65.1, 53.3],
            ['Milk Tea', 86.5, 92.1, 85.7, 83.1],
            ['Cheese Cocoa', 24.1, 67.2, 79.5, 86.4]
          ]
        },
        xAxis: [
          { type: 'category', gridIndex: 0 },
          { type: 'category', gridIndex: 1 }
        ],
        yAxis: [{ gridIndex: 0 }, { gridIndex: 1 }],
        grid: [{ bottom: '55%' }, { top: '55%' }],
        series: [
          // These series are in the first grid.
          { type: 'bar', seriesLayoutBy: 'row' },
          { type: 'bar', seriesLayoutBy: 'row' },
          { type: 'bar', seriesLayoutBy: 'row' },
          // These series are in the second grid.
          { type: 'bar', xAxisIndex: 1, yAxisIndex: 1 },
          { type: 'bar', xAxisIndex: 1, yAxisIndex: 1 },
          { type: 'bar', xAxisIndex: 1, yAxisIndex: 1 },
          { type: 'bar', xAxisIndex: 1, yAxisIndex: 1 }
        ]
      }
      pieGraph.setOption(option);
    }
  }
}
</script>

<style scoped>
  .chart{
    width: 100%;
    height: 100%;
  }
</style>
