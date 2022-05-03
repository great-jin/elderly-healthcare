<template>
  <div :style="{padding: '10px 20px'}">
    <a-row :style="{marginBottom: '20px'}">
      <a-col :span="14">
        <h4 style="padding-left: 10px">
          <strong>产品类别:&nbsp;</strong>
          <a-select
            v-model="goodsType"
            :allowClear="true"
            placeholder="请选择产品类别"
            style="width: 130px"
          >
            <a-select-option
              v-for="item in typeList"
              :key="item"
              :value="item"
            >{{ item }}
            </a-select-option>
          </a-select>
        </h4>
      </a-col>
      <a-col :span="10">
        <a-button
          type="primary"
          @click="clickOption('reset',null)"
          style="z-index: 1; float: right; margin-left: 10px"
        >重置
        </a-button>
        <a-button
          type="primary"
          @click="clickOption('search',null)"
          style="z-index: 1; float: right"
        >查询
        </a-button>
      </a-col>
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
          <a-button type="link" @click="clickOption('edit', record)">更新</a-button>
          <GoodsModal ref="goodsModal"/>
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
      goodsType: undefined,
      typeList: [],
      allData: [],
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
    async getData () {
      await listGoods().then(res => {
        this.allData = res.data
      })
      this.data = this.allData
      const _types = this.allData.map(item => item.goodsType)
      this.typeList = _types.filter(function (element, index, array) {
        return array.indexOf(element) === index
      })
    },
    clickOption (type, data) {
      switch (type) {
        case 'reset':
          this.goodsType = undefined
          this.data = this.allData
          break
        case 'search':
          this.data = this.allData.filter(item => item.goodsType === this.goodsType)
          break
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
