<template>
  <a-modal
    title="工资详情"
    :visible="visible"
    width="60%"
    @cancel="cancel"
  >

    <template slot="footer">
      <a-button key="submit" type="primary" @click="ok">确定</a-button>
      <a-button key="back" @click="cancel">取消</a-button>
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
      </a-descriptions-item>
    </a-descriptions>
  </a-modal>
</template>

<script>
export default {
  name: 'SalaryModal',
  data () {
    return {
      visible: false
    }
  },
  methods: {
    paramReceive (data) {
      this.visible = true
      console.log(data)
    },
    cancel () {
      this.visible = false
      this.$message.success('关闭页面')
    },
    ok () {
      this.visible = false
      this.$message.success('关闭页面')
    }
  }
}
</script>

<style scoped>
</style>
