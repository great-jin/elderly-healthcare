<template>
  <a-list
    :data-source="data"
    item-layout="horizontal"
  >
    <a-list-item slot="renderItem" slot-scope="item">
      <a-button
        type="link"
        slot="actions"
        @click="ClickOption(item)"
      >查看</a-button>
      <a-list-item-meta>
        <span slot="title">
          编号：{{ (item.applyId).substring(0,8) }}
          &nbsp;&nbsp;&nbsp;&nbsp;
          申请人编号：{{ item.staffId }}
        </span>
      </a-list-item-meta>

      <ProcessModal ref="processModal" />
    </a-list-item>
  </a-list>
</template>

<script>
import ProcessModal from './processModal'
import { listApplyInfo } from '@/api/assetApplyInfo'

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
      listApplyInfo().then(res => {
        this.data = res.data.filter(item => item.currentState === 0)
      })
    },
    ClickOption (data) {
      this.$refs.processModal.paramReceive(data)
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
