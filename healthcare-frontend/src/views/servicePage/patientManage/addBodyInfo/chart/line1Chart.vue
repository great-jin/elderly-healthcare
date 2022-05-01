<template>
  <div id="line3" style="width: 100%; height: 400px;"/>
</template>

<script>
import { listBodyInfo } from '@/api/patientBodyInfo'

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
  data () {
    return {
      patient: this.patientId,
      bodyInfo: [],
      charDate: [],
      charData: []
    }
  },
  mounted () {
    setTimeout(() => {
      this.line3Chart()
    })
    window.onresize = () => {
      this.line3Chart()
    }
  },
  methods: {
    async getData () {
      const _patient = {
        patient_id: this.patient
      }
      await listBodyInfo(_patient).then(res => {
        this.bodyInfo = res.data
      })
      console.log(this.bodyInfo)
    },
    line3Chart () {
      this.getData()
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
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '体温',
            type: 'line',
            stack: 'Total',
            data: [120, 132, 101, 134, 90, 230, 210]
          },
          {
            name: '心率',
            type: 'line',
            stack: 'Total',
            data: [220, 182, 191, 234, 290, 330, 310]
          },
          {
            name: '血压',
            type: 'line',
            stack: 'Total',
            data: [150, 232, 201, 154, 190, 330, 410]
          },
          {
            name: '血糖',
            type: 'line',
            stack: 'Total',
            data: [320, 332, 301, 334, 390, 330, 320]
          },
          {
            name: '血脂',
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
