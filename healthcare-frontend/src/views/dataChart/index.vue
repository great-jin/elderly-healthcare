<template>
  <div class="chart">
    <div id="pie" style="width: 50%; height: 50%; margin: auto auto;"></div>
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
        title: {
          text: 'Echarts Demo',
        },
        tooltip: {},
        legend: {
          data: ['销量']
        },
        xAxis: {
          data: ['衬衫','羊毛衫','雪纺衫','裤子','高跟鞋','袜子']
        },
        yAxis: {},
        series: [{
          name: '销量',
          type: 'bar',
          data: [5,20,36,10,10,20]
        }]
      };
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
