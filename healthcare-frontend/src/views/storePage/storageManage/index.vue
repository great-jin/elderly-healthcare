<template>
  <div>
    <a-row>

    </a-row>
    <a-row>
      <a-table
        :columns="columns"
        :data-source="data"
        :pagination="pagination"
        :scroll="{ x: 1300 }"
      >
        <template slot="action" slot-scope="record">
          <a-button type="link" @click="clickOption('more', record)">详情</a-button>
          <a-button type="link" @click="clickOption('edit', record)">详情</a-button>
          <GoodsModal ref="goodsModal" />
        </template>
      </a-table>
    </a-row>
  </div>
</template>

<script>
import { columns } from './const'
import GoodsModal from './goodsModal'
import { listGoods } from '@/api/warehouseStorage'

export default {
  name: 'index',
  components: {
    GoodsModal
  },
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
      listGoods().then(res => {
        this.data = res.data
      })
    },
    clickOption (type, data) {
      switch (type) {
        case 'more':
          this.$refs.goodsModal.paramReceive('more', data)
          break
        case 'edit':
          this.$refs.goodsModal.paramReceive('edit', data)
          break
      }
    }
  }
}
</script>

<style>
</style>
