<template>
  <a-modal
    :title="type === 'edit' ? '编辑' : '详情'"
    :visible="visible"
    width="70%"
    @cancel="cancel()"
  > <!-- 这里的取消时右上角关闭( X )-->

    <template slot="footer">
      <a-button key="back" @click="cancel()">取消</a-button>
      <a-button
        key="submit"
        type="primary"
        :disabled="editable"
        :loading="confirmLoading"
        @click="ok()"
      >确定</a-button>
    </template>

    <a-descriptions title="User Info" bordered>
      <a-descriptions-item label="Product">
        Cloud Database
      </a-descriptions-item>
      <a-descriptions-item label="Billing Mode">
        Prepaid
      </a-descriptions-item>
      <a-descriptions-item label="Automatic Renewal">
        YES
      </a-descriptions-item>
      <a-descriptions-item label="Order time">
        2018-04-24 18:00:00
      </a-descriptions-item>
      <a-descriptions-item label="Usage Time" :span="2">
        2019-04-24 18:00:00
      </a-descriptions-item>
      <a-descriptions-item label="Status" :span="3">
        <a-badge status="processing" text="Running" />
      </a-descriptions-item>
      <a-descriptions-item label="Negotiated Amount">
        $80.00
      </a-descriptions-item>
      <a-descriptions-item label="Discount">
        $20.00
      </a-descriptions-item>
      <a-descriptions-item label="Official Receipts">
        $60.00
      </a-descriptions-item>
      <a-descriptions-item label="Config Info">
        Data disk type: MongoDB
        <br />
        Database version: 3.4
        <br />
        Package: dds.mongo.mid
        <br />
        Storage space: 10 GB
        <br />
        Replication factor: 3
        <br />
        Region: East China 1<br />
      </a-descriptions-item>
    </a-descriptions>
  </a-modal>
</template>

<script>
export default {
  name: 'UserModal',
  data () {
    return {
      type: '',
      visible: false,
      editable: false,
      confirmLoading: false,
      taskInfo: {},
      patientInfo: {}
    }
  },
  methods: {
    cancel () {
      this.visible = false
      this.isDetail = false
    },
    ok () {

    },
    paramReceive (type, data) {
      this.type = type
      this.visible = true
      this.loading = false
      if (type === 'more') {
        this.editable = false
      }
    }
  }
}
</script>

<style scoped>

</style>
