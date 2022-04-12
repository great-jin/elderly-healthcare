<template>
  <div>
    <div style="margin-bottom: 30px;">
      <a-row :gutter="16">
        <a-col :span="12" style="padding: 5px 30px">
          <a-statistic-countdown
            title="Million Seconds"
            :value="deadline"
            format="HH:mm:ss:SSS"
            style="margin-right: 50px"
          />
        </a-col>
        <a-col :span="12" style="padding: 5px 30px">
          <a-statistic-countdown
            title="Day Level"
            :value="deadline"
            format="D 天 H 时 m 分 s 秒"
          />
        </a-col>
      </a-row>
    </div>
    <a-table :columns="columns" :data-source="data">
      <a slot="action" slot-scope="text" href="javascript:;">Detail</a>
      <p slot="expandedRowRender" slot-scope="record" style="margin: 0">
        {{ record.description }}
      </p>
    </a-table>
  </div>
</template>

<script>
import { Data, Columns } from './const'

export default {
  name: 'index',
  data () {
    return {
      data: Data,
      columns: Columns,
      deadline: Date.now() + 1000 * 60 * 60 * 24 * 2 + 1000 * 30
    }
  },
  methods: {
    callback (key) {
      console.log(key)
    }
  }
}
</script>

<style scoped>

</style>
