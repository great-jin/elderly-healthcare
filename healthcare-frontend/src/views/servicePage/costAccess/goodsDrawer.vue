<template>
  <a-drawer
    title="消费记录"
    width="45%"
    placement="right"
    :visible="visible"
    @close="cancel"
  >

    <a-table
      :columns="payColumns"
      :data-source="data"
      :locale="locale"
      :pagination="pagination"
    />
  </a-drawer>
</template>

<script>
import Empty from '@/views/utils/empty'
import { payColumns } from './const'
import { getCost } from '@/api/patientCostDetail'

export default {
  name: 'UserModal',
  components: {
    Empty
  },
  data () {
    return {
      visible: false,
      payColumns,
      data: [],
      pagination: {
        total: 0,
        defaultPageSize: 5,
        showSizeChanger: true,
        pageSizeOptions: ['5', '10', '20', '30'],
        showTotal: total => `共 ${total} 条数据`,
        onShowSizeChange: (current, pageSize) => this.pageSize = pageSize
      },
      locale: {
        emptyText: <Empty text="消费已结清" />
      }
    }
  },
  methods: {
    paramReceive (data) {
      this.visible = true
      this.getData(data)
    },
    getData (data) {
      getCost(data).then(res => {
        this.costId = res.data.costId
        this.data = res.data
      })
    },
    cancel () {
      this.visible = false
    }
  }
}
</script>

<style scoped>
</style>
