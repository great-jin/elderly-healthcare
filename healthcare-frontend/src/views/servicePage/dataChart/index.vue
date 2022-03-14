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
          dimensions: ['product', '2015', '2016', '2017'],
          source: [
            { product: 'Matcha Latte', 2015: 43.3, 2016: 85.8, 2017: 93.7 },
            { product: 'Milk Tea', 2015: 83.1, 2016: 73.4, 2017: 55.1 },
            { product: 'Cheese Cocoa', 2015: 86.4, 2016: 65.2, 2017: 82.5 },
            { product: 'Walnut Brownie', 2015: 72.4, 2016: 53.9, 2017: 39.1 }
          ]
        },
        xAxis: { type: 'category' },
        yAxis: {},
        // Declare several bar series, each will be mapped
        // to a column of dataset.source by default.
        series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
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
