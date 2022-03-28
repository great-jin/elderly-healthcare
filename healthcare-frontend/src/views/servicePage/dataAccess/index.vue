<template>
  <div>
    <a-tabs type="card">
      <a-tab-pane key="1" tab="登记信息">
        <a-table
          :columns="columns"
          :data-source="accessData"
        >
          <template slot="action" slot-scope="record">
            <a-button type="link" @click="openDrawer('detail', record)">详情</a-button>
            <patientDrawer ref="patientDrawer" />
          </template>
          <p slot="expandedRowRender" slot-scope="record" style="margin: 0">
            {{ record.description }}
          </p>
        </a-table>
      </a-tab-pane>
      <a-tab-pane key="2" tab="入住登记">
        <accessForm />
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
import accessForm from './accessForm'
import patientDrawer from './patientDrawer'
import { columns, accessData } from './const'

export default {
  name: 'index',
  components: {
    accessForm,
    patientDrawer
  },
  data () {
    return {
      columns,
      accessData
    }
  },
  methods: {
    openDrawer (type, record) {
      this.$refs.patientDrawer.paramReceive(type, record)
    }
  }
}
</script>

<style scoped>
</style>
