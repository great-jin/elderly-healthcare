<template>
  <div id="pie1" style="width: 100%; height: 300px;"/>
</template>

<script>
import {getCharDate} from '@/api/patientInfo'
import moment from "_moment@2.29.1@moment";

export default {
  name: 'pie1Chart',
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
      ageData: {},
      charData: []
    }
  },
  mounted() {
    /*setTimeout(() => {
      this.pie1Chart()
    })
    window.onresize = () => {
      this.pie1Chart()
    }*/
    this.getData()
  },
  methods: {
    async getData() {
      await getCharDate().then(res => {
        this.ageData = res.data
        this.$nextTick(() => {
          this.$echarts.init(document.getElementById('pie1')).dispose()
          this.pie1Chart()
        })
      })
    },
    pie1Chart() {
      const graph = this.$echarts.init(document.getElementById('pie1'))
      const option = {
        title: {
          text: '年龄分布',
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
            name: '年龄分布',
            type: 'pie',
            radius: '45%',
            data: this.ageData,
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
