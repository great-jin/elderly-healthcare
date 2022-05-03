<template>
  <a-row>
    <a-col :span="12">
      <a-row :style="{textAlign:'center'}">
        <h3><strong>病人年龄分布</strong></h3>
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
          <a-descriptions-item label="总人数" :span="4">
            {{ countNum }} 人
          </a-descriptions-item>
        </a-descriptions>
      </a-row>
    </a-col>
    <a-col :span="12" :style="{paddingTop:'50px'}">
      <div id="pie1" style="width: 100%; height: 300px;"
      />
    </a-col>
  </a-row>
</template>

<script>
import { getCharDate } from '@/api/patientInfo'

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
      ageData: [],
      countNum: 0
    }
  },
  mounted() {
    this.getData()
  },
  methods: {
    async getData() {
      await getCharDate().then(res => {
        this.ageData = res.data
        this.ageData.forEach(item => {
          this.countNum += item.value
        })
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
            data: this.ageData
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
