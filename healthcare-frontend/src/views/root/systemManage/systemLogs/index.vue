<template>
  <div>
    <div style="margin-bottom: 30px;">
      <a-row>
        <a-col :span="12">
          <a-row style="text-align: center">
            <a-statistic-countdown
              title="项目已运行: "
              format="D 天 H 时 m 分 s 秒"
              :value="runTime"
            />
          </a-row>
        </a-col>
        <a-col :span="12">
          <a-row style="text-align: center">
            <a-statistic-countdown
              title="日志打印计时"
              format="HH:mm:ss"
              :value="downTime"
            />
          </a-row>
        </a-col>
      </a-row>
    </div>
    <a-table
      :columns="columns"
      :data-source="data"
    >
      <template slot="action" slot-scope="record">
        <a-button type="link">详情</a-button>
      </template>
    </a-table>
  </div>
</template>

<script>
import { data, columns } from './const'

export default {
  name: 'Logs',
  data () {
    return {
      data,
      columns,
      downTime: Date.now() + 1000 * 60 * 60 * 6,
      runTime: Date.now() + 1000 * 60 * 60 * 24 * 2
    }
  }
}
</script>

<style scoped>
</style>
