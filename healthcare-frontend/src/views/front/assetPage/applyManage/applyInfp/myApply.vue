<template>
  <div>
    <a-table
      :columns="columns"
      :data-source="data"
      :scroll="{ x: 1000 }"
    >
      <template slot="action" slot-scope="record">
        <a-button type="link" @click="clickOption('more', record.applyId)">详情</a-button>
        <a-button type="link" @click="clickOption('delete', record.applyId)">撤销</a-button>

        <DetailModal ref="detailModal" />
      </template>
    </a-table>
  </div>
</template>

<script>
import { columns } from './const'
import DetailModal from './detailModal'
import { listApplyInfo, removeApplyInfo } from '@/api/assetApplyInfo'

export default {
  name: 'MyApply',
  components: {
    DetailModal
  },
  data () {
    return {
      data: []
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
      const loginUser = JSON.parse(localStorage.getItem('loginUser'))
      const _staff = {
        staffId: loginUser.staffId
      }
      listApplyInfo(_staff).then(res => {
        this.data = res.data
      })
    },
    clickOption (type, data) {
      switch (type) {
        case 'more':
          this.$refs.detailModal.paramReceive(data)
          break
        case 'delete':
          const _data = new FormData()
          _data.append('applyId', data)
          removeApplyInfo(_data).then(res => {
            if (res.data) {
              this.$message.success('成功撤销申请')
            } else {
              this.$message.error('撤销失败，请重试')
            }
          })
          break
      }
    }
  }
}
</script>

<style scoped>
</style>
