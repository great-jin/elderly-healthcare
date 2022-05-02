<template>
  <div class="vacate-list">
    <a-button-group>
      <a-button @click="clickOption('0')">未审批</a-button>
      <a-button @click="clickOption('1')">已审批</a-button>
    </a-button-group>
    <a-list
      :data-source="myVacate"
      item-layout="horizontal"
      style="padding: 0px 20px"
    >
      <a-list-item slot="renderItem" slot-scope="item">
        <a-list-item-meta
          :description="item.vacateReason"
        >
          <span slot="title">{{ item.vacateType }} 申请</span>
        </a-list-item-meta>
        <a-button slot="actions" type="link" @click="showProcess(item)">审批进度</a-button>
        <processModal ref="processModal"/>
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
      myVacate: [],
      vacateList: []
    }
  },
  mounted () {
    this.getData()
  },
  methods: {
    async getData () {
      const loginUser = JSON.parse(localStorage.getItem('loginUser'))
      const _staff = {
        staffId: loginUser.staffId
      }
      await listVacateInfo(_staff).then(res => {
        this.vacateList = res.data
      })
      this.clickOption('0')
    },
    clickOption (data) {
      if (data === '0') {
        this.myVacate = this.vacateList.filter(item => item.isApprove === 0)
      } else {
        const doneList = this.vacateList.filter(item => item.isApprove === 1)
        this.myVacate = doneList.slice(0, 10)
      }
    },
    showProcess (data) {
      this.$refs.processModal.paramReceive(data)
    }
  }
}
</script>

<style>
.vacate-list {
  min-height: 380px;
  padding: 5px;
  border: lightgray 2px solid;
}
</style>
