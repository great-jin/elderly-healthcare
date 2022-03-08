<template>
  <div class="Echarts">
    <div id="main" style="width: 100%; height: 100%;"></div>
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
    this.myEcharts()
  },
  methods: {
    myEcharts(){
      // 通过 this.$echarts 来使用
      var myChart = this.$echarts.init(document.getElementById('main'));
      // 配置图表信息
      var option = {
        title: {
          text: 'echarts入门示例',
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
      myChart.setOption(option);
    }
  }
}
</script>

<style scoped>
  .Echarts{
    width: 100%;
    height: 100%;
  }
</style>
