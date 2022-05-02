<template>
  <a-modal
    title="物资申请信息"
    :visible="visible"
    width="55%"
    @cancel="cancel"
  >
    <a-table
      :columns="detailColumns"
      :data-source="data"
    />
  </a-modal>
</template>

<script>
import { detailColumns } from './const'
import { listApplyGoods } from '@/api/assetApplyGoods'

export default {
  name: 'applyInfoModal',
  data () {
    return {
      data: [],
      detailColumns,
      visible: false
    }
  },
  methods: {
    paramReceive (data) {
      this.visible = true
      this.getData(data)
    },
    getData (data) {
      const _apply = {
        applyId: data
      }
      listApplyGoods(_apply).then(res => {
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
