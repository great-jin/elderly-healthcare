<template>
  <a-row>
    <a-col :span="12">
      <div id="pie2" style="width: 100%; height: 300px;"/>
    </a-col>
    <a-col :span="12" style="margin-top: 30px">
      <a-row :style="{textAlign:'center', marginBottom:'15px'}">
        <h3><strong>医护人员占比</strong></h3>
      </a-row>
      <a-row>
        <a-descriptions
          :column="{ xxl: 4, xl: 3, lg: 3, md: 3, sm: 2, xs: 1 }"
          bordered
        >
          <a-descriptions-item label="医师" :span="4">
            {{ charDate[1].value }} 人
          </a-descriptions-item>
          <a-descriptions-item label="护理员" :span="4">
            {{ charDate[0].value }} 人
          </a-descriptions-item>
          <a-descriptions-item label="总数" :span="4">
            {{ charDate[0].value + charDate[1].value }} 人
          </a-descriptions-item>
        </a-descriptions>
      </a-row>
    </a-col>
  </a-row>
</template>

<script>
import {getCount} from "@/api/staffNurse";

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
  data () {
    return {
      charDate:[]
    }
  },
  mounted () {
    this.getCount()
  },
  methods: {
    async getCount () {
      await getCount().then(res => {
        this.charDate = res.data
      })
      this.$nextTick(() => {
        this.$echarts.init(document.getElementById('pie2')).dispose()
        this.pie2Chart()
      })
    },
    pie2Chart () {
      const graph = this.$echarts.init(document.getElementById('pie2'))
      const option = {
        title: {
          text: '医护占比',
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
            data: this.charDate
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
