<template>
  <a-modal
    :title="title"
    :visible="visible"
    width="40%"
    @cancel="cancel"
  >
    <a-list
      :data-source="data"
      item-layout="horizontal"
    >
      <a-list-item slot="renderItem" slot-scope="item">
        <a-list-item-meta>
          <span slot="title">
            病号：{{ item.patientId }}
            &nbsp;&nbsp;&nbsp;&nbsp;
            姓名：{{ item.patientName }}
          </span>
        </a-list-item-meta>
      </a-list-item>
    </a-list>
  </a-modal>
</template>

<script>
import {getWarning} from '@/api/patientBodyInfo'

export default {
  name: 'WarningModal',
  data() {
    return {
      type: '',
      title: '',
      visible: false,
      data: [],
      infoList: []
    }
  },
  methods: {
    paramReceive(type) {
      this.type = type
      this.visible = true
      this.getData(type)
    },
    async getData(type) {
      await getWarning(1).then(res => {
        this.infoList = res.data
      })
      let _data = []
      switch (type) {
        case 'temp':
          _data = this.infoList.filter(item => Number(item.bodyTemper) > 37)
          this.title = '体温异常病人信息'
          break
        case 'heart':
          _data = this.infoList.filter(item => Number(item.heartBeat) > 70)
          this.title = '心率异常病人信息'
          break
        case 'pleasure':
          _data = this.infoList.filter(item => Number(item.bloodPressure) > 120)
          this.title = '血压异常病人信息'
          break
        case 'glucose':
          _data = this.infoList.filter(item => Number(item.bloodGlucose) > 37)
          this.title = '血糖异常病人信息'
          break
      }
      this.data = _data
    },
    cancel() {
      this.visible = false
      this.data = []
      this.infoList = []
    },
    ok() {
      this.visible = false
    }
  }
}
</script>

<style scoped>

</style>
