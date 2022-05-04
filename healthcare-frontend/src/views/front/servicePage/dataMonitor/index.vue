<template>
  <div>
    <div style="background-color: #ececec; padding: 15px;">
      <a-row :gutter="16">
        <a-col :span="6">
          <a-card title="体温监控" :bordered="false" size="small">
            <a-tag color="green">
              正常: {{ normal.temp }}
            </a-tag>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a-tag color="pink" @click="clickOption('temp')">
              异常: {{ warning.temp }}
            </a-tag>
          </a-card>
        </a-col>
        <a-col :span="6">
          <a-card title="心率监控" :bordered="false" size="small">
            <a-tag color="green">
              正常: {{ normal.heart }}
            </a-tag>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a-tag color="pink" @click="clickOption('heart')">
              异常: {{ warning.heart }}
            </a-tag>
          </a-card>
        </a-col>
        <a-col :span="6">
          <a-card title="血压监控" :bordered="false" size="small">
            <a-tag color="green">
              正常: {{ normal.pleasure }}
            </a-tag>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a-tag color="pink" @click="clickOption('pleasure')">
              异常: {{ warning.pleasure }}
            </a-tag>
          </a-card>
        </a-col>
        <a-col :span="6">
          <a-card title="血糖监控" :bordered="false" size="small">
            <a-tag color="green">
              正常: {{ normal.glucose }}
            </a-tag>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a-tag color="pink" @click="clickOption('glucose')">
              异常: {{ warning.glucose }}
            </a-tag>
          </a-card>
        </a-col>

        <WarningModal ref="warningModal"/>
      </a-row>
    </div>
    <a-row style="width: 100%; height: 100%; margin-bottom: 70px">
      <lineChart/>
    </a-row>
  </div>
</template>

<script>
import lineChart from './chart/lineChart'
import WarningModal from './warningModal'

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
  data () {
    return {
      normal: {
        temp: 5,
        heart: 3,
        pleasure: 3,
        glucose: 6
      },
      warning: {
        temp: 2,
        heart: 0,
        pleasure: 1,
        glucose: 0
      }
    }
  },
  components: {
    lineChart,
    WarningModal
  },
  methods: {
    clickOption (type) {
      this.$refs.warningModal.paramReceive(type)
    }
  }
}
</script>

<style scoped>
</style>
