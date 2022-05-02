<template>
  <a-list
    :data-source="data"
    item-layout="horizontal"
  >
    <a-list-item slot="renderItem" slot-scope="item">
      <a-button
        type="link"
        slot="actions"
        @click="ClickOption('view', item)"
      >查看</a-button>
      <a-list-item-meta :description="item.vacateReason">
        <span slot="title">{{ item.vacateType }}</span>
      </a-list-item-meta>

      <ProcessModal ref="processModal" />
    </a-list-item>
  </a-list>
</template>

<script>
import ProcessModal from './processModal'
import { listVacateInfo } from '@/api/vacateInfo'

export default {
  components: {
    ProcessModal
  },
  data () {
    return {
      data: []
    }
  },
  created () {
    this.getData()
  },
  methods: {
    getData () {
      listVacateInfo().then(res => {
        this.data = res.data.filter(item => item.isApprove === 0)
      })
    },
    ClickOption (type, data) {
      this.$refs.processModal.paramReceive(type, data)
    }
  }
}
</script>

<style>
.loadding{
  text-align: center;
  margin-top: 12px;
  height: 32px;
  line-height: 32px
}
</style>
