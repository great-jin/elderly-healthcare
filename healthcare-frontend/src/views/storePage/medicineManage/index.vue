<template>
  <div>
    <a-table
      :columns="columns"
      :data-source="data"
      :pagination="pagination"
      :scroll="{ x: 1200 }"
    >
      <template slot="action" slot-scope="record">
        <a-button type="link" @click="clickOption('more', record)">详情</a-button>
        <a-button type="link" @click="clickOption('edit', record)">详情</a-button>
        <MedicineModal ref="medicineModal" />
      </template>
    </a-table>
  </div>
</template>

<script>
import { columns } from './const'
import MedicineModal from './medicineModal'
import { listMedicineCatalog } from '@/api/medicineCatalog'

export default {
  data () {
    return {
      data: [],
      pagination: {
        total: 0,
        defaultPageSize: 5,
        showSizeChanger: true,
        pageSizeOptions: ['5', '10', '20', '30'],
        showTotal: total => `共 ${total} 条数据`,
        onShowSizeChange: (current, pageSize) => this.pageSize = pageSize
      }
    }
  },
  components: {
    MedicineModal
  },
  computed: {
    columns () {
      return columns(this)
    }
  },
  created () {
    this.getData()
  },
  methods: {
    getData () {
      listMedicineCatalog().then(res => {
        this.data = res.data
      })
    },
    clickOption (type, data) {
      switch (type) {
        case 'more':
          this.$refs.medicineModal.paramReceive('more', data)
          break
        case 'edit':
          this.$refs.medicineModal.paramReceive('edit', data)
          break
      }
    }
  }
}
</script>

<style>
</style>
