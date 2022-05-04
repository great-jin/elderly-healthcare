<template>
  <a-drawer
    title="消费记录"
    width="55%"
    placement="right"
    :visible="visible"
    @close="cancel"
  >
    <a-row :style="{marginBottom: '25px', marginLeft: '5px'}">
      <span><strong>病号：</strong>
        <a-input
          v-model="patientId"
          :disabled="true"
          style="width: 32%"
        />
      </span>
      &nbsp;&nbsp;&nbsp;&nbsp;
      <span><strong>病人姓名：</strong>
        <a-input
          v-model="patientName"
          :disabled="true"
          style="width: 32%"
        />
      </span>
    </a-row>
    <a-table
      :data-source="data"
      :columns="costColumns"
      :locale="locale"
      :pagination="pagination"
    >
      <template slot="action" slot-scope="record">
        <a-button type="link" @click="clickOption('edit', record)">更新</a-button>
        <a-popconfirm
          title="是否确认删除该条消费记录"
          ok-text="是"
          cancel-text="否"
          @confirm="clickOption('delete', record)"
        >
          <a-button type="link">删除</a-button>
        </a-popconfirm>
        <CostModal ref="costModal"/>
      </template>
    </a-table>
  </a-drawer>
</template>

<script>
import Empty from '@/views/utils/empty'
import CostModal from './costModal'
import { costColumns } from './const'
import { getCost } from '@/api/patientCostDetail'
import { listCostInfo } from '@/api/patientCostInfo'

export default {
  name: 'CostDrawer',
  components: {
    Empty,
    CostModal
  },
  data () {
    return {
      visible: false,
      data: [],
      patientId: '',
      patientName: '',
      pagination: {
        total: 0,
        defaultPageSize: 5,
        showSizeChanger: true,
        pageSizeOptions: ['5', '10', '20', '30'],
        showTotal: total => `共 ${total} 条数据`,
        onShowSizeChange: (current, pageSize) => this.pageSize = pageSize
      },
      locale: {
        emptyText: <Empty text="消费已结清"/>
      }
    }
  },
  computed: {
    costColumns () {
      return costColumns(this)
    }
  },
  methods: {
    paramReceive (data) {
      this.visible = true
      this.patientId = data
      // data: patientId
      this.getData(data)
    },
    getData (data) {
      const _obj = {
        patientId: this.patientId
      }
      listCostInfo(_obj).then(res => {
        // 获取病人姓名
        this.patientName = res.data[0].patientName
      })
      getCost(data).then(res => {
        // 获取消费信息列表
        this.data = res.data
      })
    },
    cancel () {
      this.visible = false
    },
    clickOption (type, data) {
      switch (type) {
        case 'edit':
          this.$refs.costModal.paramReceive(data.id)
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
