<template>
  <a-row>
    <a-col :span="12">
      <div id="pie1" style="width: 100%; height: 300px;"/>
    </a-col>
    <a-col :span="12">
      <a-row :style="{textAlign:'center', marginBottom:'15px'}">
        <h3>病人年龄分布</h3>
      </a-row>
      <a-row>
        <a-descriptions
            :column="{ xxl: 4, xl: 3, lg: 3, md: 3, sm: 2, xs: 1 }"
            bordered
        >
          <a-descriptions-item label="40岁以下" :span="4">
            {{ ageData[0].value }} 人
          </a-descriptions-item>
          <a-descriptions-item label="40岁~55岁" :span="4">
            {{ ageData[1].value }} 人
          </a-descriptions-item>
          <a-descriptions-item label="55岁~65岁" :span="4">
            {{ ageData[2].value }} 人
          </a-descriptions-item>
          <a-descriptions-item label="65岁~100岁" :span="4">
            {{ ageData[3].value }} 人
          </a-descriptions-item>
        </a-descriptions>
      </a-row>
    </a-col>
  </a-row>
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
        console.log(this.ageData)
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
