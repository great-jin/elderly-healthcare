<template>
  <div>
    <a-button-group>
      <a-button @click="clickOption('0')">未审批</a-button>
      <a-button @click="clickOption('1')">已审批</a-button>
    </a-button-group>
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
        <a-button slot="actions" type="link" @click="showProcess(item)">审批进度</a-button>
        <processModal ref="processModal" />
      </a-list-item>
    </a-list>
  </div>
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
      myVacate: [],
      vacateList: []
    }
  },
  mounted () {
    this.getData()
    this.clickOption(0)
  },
  methods: {
    getData () {
      const loginUser = JSON.parse(localStorage.getItem('loginUser'))
      listVacateInfo({ staffId: loginUser.staffId }).then(res => {
        this.vacateList = res.data
      })
    },
    clickOption (data) {
      if (data === '0') {
        this.myVacate = this.vacateList.filter(item => item.isProve === 0)
      } else {
        this.myVacate = this.vacateList.filter(item => item.isProve === 1)
      }
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
