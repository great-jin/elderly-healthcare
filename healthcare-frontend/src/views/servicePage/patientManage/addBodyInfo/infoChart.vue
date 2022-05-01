<template>
  <div id="line3" style="width: 100%; height: 400px;"/>
</template>

<script>
import { getCharData } from '@/api/patientBodyInfo'
import moment from "_moment@2.29.1@moment";

export default {
  name: 'line3Chart',
  props: {
    patientId: {
      type: String,
      default: null
    },
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
      patient: this.patientId,
      bodyInfo: [],
      charDate: [],
      charData: []
    }
  },
  mounted() {
    this.bodyInfo = []
    this.charDate = []
    this.charData = []
    this.getData()
  },
  methods: {
    async getData() {
      await getCharData(this.patient).then(res => {
        this.bodyInfo = res.data
        const tempList= this.bodyInfo.map(item => Number(item.bodyTemper))
        const heartList= this.bodyInfo.map(item => Number(item.heartBeat))
        const pressureList= this.bodyInfo.map(item => Number(item.bloodPressure))
        const glucoseList= this.bodyInfo.map(item => Number(item.bloodGlucose))
        const fatList= this.bodyInfo.map(item => Number(item.bloodFat))
        this.charDate = this.bodyInfo.map(item => moment(item.inTime).format('YYYY-MM-DD'))
        this.charData = [
          {
            name: '体温',
            type: 'line',
            stack: 'Total',
            data: tempList
          },
          {
            name: '心率',
            type: 'line',
            stack: 'Total',
            data: heartList
          },
          {
            name: '血压',
            type: 'line',
            stack: 'Total',
            data: pressureList
          },
          {
            name: '血糖',
            type: 'line',
            stack: 'Total',
            data: glucoseList
          },
          {
            name: '血脂',
            type: 'line',
            stack: 'Total',
            data: fatList
          }
        ]
        this.$nextTick(() => {
          this.$echarts.init(document.getElementById('line3')).dispose()
          this.line3Chart()
        });
      })
    },
    line3Chart() {
      const graph = this.$echarts.init(document.getElementById('line3'))
      const option = {
        title: {
          text: '近7日身体指标详情',
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
          data: ['体温', '心率', '血压', '血糖', '血脂']
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
          data: this.charDate
        },
        yAxis: {
          type: 'value'
        },
        series: this.charData
      }
      graph.clear()
      graph.setOption(option, true)
    }
  }
}
</script>

<style scoped>
</style>
