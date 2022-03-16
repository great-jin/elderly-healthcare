<template>
  <div>
    <a-tabs type="card">
      <a-tab-pane key="1" tab="信息填写">
        <a-descriptions title="User Info" style="padding: 0px 10px" bordered>
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
      </a-tab-pane>
      <a-tab-pane key="2" tab="流程日志">
        <a-steps :current="1">
          <a-popover slot="progressDot" slot-scope="{ index, status, prefixCls }">
            <template slot="content">
              <span>step {{ index }} status: {{ status }}</span>
            </template>
            <span :class="`${prefixCls}-icon-dot`" />
          </a-popover>
          <a-step title="Finished" description="You can hover on the dot." />
          <a-step title="In Progress" description="You can hover on the dot." />
          <a-step title="Waiting" description="You can hover on the dot." />
          <a-step title="Waiting" description="You can hover on the dot." />
        </a-steps>
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
export default {
  name: "index"
}
</script>

<style scoped>

</style>
