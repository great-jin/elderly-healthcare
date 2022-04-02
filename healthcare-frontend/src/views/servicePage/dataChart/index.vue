<template>
  <div>
    <a-row style="margin-bottom: 15px; font-weight: 600">
      <a-col :span="24" style="text-align: center">
        <h2>数据详情</h2>
      </a-col>
    </a-row>
    <a-row style="width: 100%; height: 100%; margin-bottom: 70px">
      <a-col :span="8">
        <div id="pie2" style="width: 100%; height: 300px;"/>
      </a-col>
      <a-col :span="8">
        <div id="pie1" style="width: 100%; height: 300px;"/>
      </a-col>
      <a-col :span="8">
        <div id="pie3" style="width: 100%; height: 300px;"/>
      </a-col>
    </a-row>
    <a-row style="width: 100%; height: 100%;">
      <a-col :span="12">
        <div id="line1" style="width: 100%; height: 400px;"/>
      </a-col>
      <a-col :span="12">
        <div id="line2" style="width: 100%; height: 400px;"/>
      </a-col>
    </a-row>
  </div>
</template>

<script>
export default {
  name: 'DataChart',
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
      this.pie1Chart()
      this.pie2Chart()
      this.pie3Chart()
      this.line1Chart()
      this.line2Chart()
    })
    window.onresize = () => {
      this.pie1Chart()
      this.pie2Chart()
      this.pie3Chart()
      this.line1Chart()
      this.line2Chart()
    }
  },
  methods: {
    pie1Chart () {
      const graph = this.$echarts.init(document.getElementById('pie1'))
      const option = {
        title: {
          text: '员工分布',
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
    },
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
    },
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
    },
    line1Chart () {
      const graph = this.$echarts.init(document.getElementById('line1'))
      const option = {
        title: {
          text: 'Nightingale Chart',
          left: 'center',
          top: 'bottom',
          textStyle: {
            fontSize: 16
          }
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['Email', 'Union Ads', 'Video Ads', 'Direct', 'Search Engine']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '10%',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: 'Email',
            type: 'line',
            stack: 'Total',
            data: [120, 132, 101, 134, 90, 230, 210]
          },
          {
            name: 'Union Ads',
            type: 'line',
            stack: 'Total',
            data: [220, 182, 191, 234, 290, 330, 310]
          },
          {
            name: 'Video Ads',
            type: 'line',
            stack: 'Total',
            data: [150, 232, 201, 154, 190, 330, 410]
          },
          {
            name: 'Direct',
            type: 'line',
            stack: 'Total',
            data: [320, 332, 301, 334, 390, 330, 320]
          },
          {
            name: 'Search Engine',
            type: 'line',
            stack: 'Total',
            data: [820, 932, 901, 934, 1290, 1330, 1320]
          }
        ]
      }
      graph.setOption(option)
    },
    line2Chart () {
      const graph = this.$echarts.init(document.getElementById('line2'))
      const option = {
        title: {
          text: 'Nightingale Chart',
          left: 'center',
          top: 'bottom',
          textStyle: {
            fontSize: 16
          }
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['Email', 'Union Ads', 'Video Ads', 'Direct', 'Search Engine']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '10%',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: 'Email',
            type: 'line',
            stack: 'Total',
            data: [120, 132, 101, 134, 90, 230, 210]
          },
          {
            name: 'Union Ads',
            type: 'line',
            stack: 'Total',
            data: [220, 182, 191, 234, 290, 330, 310]
          },
          {
            name: 'Video Ads',
            type: 'line',
            stack: 'Total',
            data: [150, 232, 201, 154, 190, 330, 410]
          },
          {
            name: 'Direct',
            type: 'line',
            stack: 'Total',
            data: [320, 332, 301, 334, 390, 330, 320]
          },
          {
            name: 'Search Engine',
            type: 'line',
            stack: 'Total',
            data: [820, 932, 901, 934, 1290, 1330, 1320]
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
