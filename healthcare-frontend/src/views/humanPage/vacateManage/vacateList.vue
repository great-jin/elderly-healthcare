<template>
  <a-list
    :loading="loading"
    :data-source="myVacate"
    item-layout="horizontal"
    style="padding: 0px 20px"
    class="demo-loadmore-list"
  >
    <a-list-item slot="renderItem" slot-scope="item">
      <a-list-item-meta
        :description="item.vacateReason"
      >
        <span slot="title">{{ item.vacateType }} 申请</span>
      </a-list-item-meta>
      <a-button slot="actions" type="link" @click="showProcess(item)">查看进度</a-button>
      <processModal ref="processModal" />
    </a-list-item>
  </a-list>
</template>

<script>
import processModal from './processModal'
import { listVacateInfo } from '@/api/vacateInfo'

export default {
  components: {
    processModal
  },
  data () {
    return {
      loading: false,
      myVacate: []
    }
  },
  mounted () {
    this.getData()
  },
  methods: {
    getData () {
      const loginUser = JSON.parse(localStorage.getItem('loginUser'))
      listVacateInfo({ staffId: loginUser.staffId }).then(res => {
        this.myVacate = res.data
      })
    },
    showProcess (data) {
      this.$refs.processModal.paramReceive(data)
    }
  }
}
</script>

<style>
  .demo-loadmore-list {
    min-height: 380px;
    border: lightgray 2px solid;
  }
</style>
