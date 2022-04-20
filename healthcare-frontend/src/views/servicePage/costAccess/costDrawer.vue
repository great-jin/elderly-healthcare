<template>
  <a-drawer
    title="消费记录"
    width="45%"
    placement="right"
    :visible="visible"
    @close="cancel"
  >
    <a-row :style="{marginBottom: '25px'}">
      <a-col :span="12">
          <span><strong>病号：</strong>
          <a-select
            v-model="patient.patientId"
            :disabled="true"
            style="width: 65%"
          />
        </span>
      </a-col>
      <a-col :span="12">
          <span><strong>病人：</strong>
          <a-select
            v-model="patient.patientName"
            :disabled="true"
            style="width: 65%"
          />
        </span>
      </a-col>
    </a-row>
    <a-table
      :columns="payColumns"
      :data-source="data"
      :locale="locale"
      :pagination="pagination"
    >
      <template slot="action" slot-scope="record">
        <a-button type="link" @click="clickOption('edit', record)">编辑</a-button>
        <a-popconfirm
          title="是否确认删除该条消费记录"
          ok-text="是"
          cancel-text="否"
          @confirm="clickOption('delete', record)"
        >
          <a-button type="link">删除</a-button>
        </a-popconfirm>
        <CostModal ref="costModal" />
      </template>
    </a-table>
  </a-drawer>
</template>

<script>
import Empty from '@/views/utils/empty'
import CostModal from './costModal'
import { payColumns } from './const'
import { getCost } from '@/api/patientCostDetail'

export default {
  name: 'CostDrawer',
  components: {
    Empty,
    CostModal
  },
  data () {
    return {
      visible: false,
      payColumns,
      data: [],
      patient: {
        patientId: '',
        patientName: ''
      },
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
      this.patient.patientId = data
    },
    getData (data) {
      getCost(data).then(res => {
        this.costId = res.data.costId
        this.data = res.data
      })
    },
    cancel () {
      this.visible = false
    },
    clickOption (type, data) {
      switch (type) {
        case 'edit':
          this.$refs.costModal.paramReceive(data)
          break
        case 'delete':
          this.$message.success('delete')
          break
      }
    }
  }
}
</script>

<style scoped>
</style>
