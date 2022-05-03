<template>
  <div :style="{padding: '10px 20px'}">
    <a-row :style="{marginBottom: '20px'}">
      <a-col :span="14">
        <h3>药品类别:&nbsp;
          <a-select
            v-model="drugType"
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
        </h3>
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
    <a-table
      :columns="columns"
      :data-source="data"
      :pagination="pagination"
      :scroll="{ x: 1150 }"
    >
      <template slot="action" slot-scope="record">
        <a-button type="link" @click="clickOption('more', record)">详情</a-button>
        <a-button type="link" @click="clickOption('edit', record)">更新</a-button>

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
      drugType: undefined,
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
        case 'reset':
          this.data = this.allData
          break
        case 'search':
          this.data = this.allData.filter(item => item.drugType === this.drugType)
          break
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
