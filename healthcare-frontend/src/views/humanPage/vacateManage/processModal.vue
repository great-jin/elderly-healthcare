<template>
  <a-modal
    title="流程进度"
    :visible="visible"
    width="60%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="back" @click="cancel">取消</a-button>
    </template>

    <div>
      <div class="process-content">
        <a-descriptions>
          <a-descriptions-item label="UserName">
            Zhou Maomao
          </a-descriptions-item>
          <a-descriptions-item label="Telephone">
            1810000000
          </a-descriptions-item>
          <a-descriptions-item label="Live">
            Hangzhou, Zhejiang
          </a-descriptions-item>
          <a-descriptions-item label="Remark">
            empty
          </a-descriptions-item>
          <a-descriptions-item label="Address">
            No. 18, Wantang Road, Xihu District, Hangzhou, Zhejiang, China
          </a-descriptions-item>
        </a-descriptions>
      </div>
      <div class="process-step">
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
      </div>
    </div>

  </a-modal>
</template>

<script>
export default {
  name: 'ProcessModal',
  data () {
    return {
      type: '',
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
    }
  }
}
</script>

<style scoped>
  .process-content{
    padding: 5px 10px;
    margin-bottom: 35px;
  }
  .process-content ant-descriptions-item-colon{
    font-size: 15px;
  }
  .process-step{
    padding: 5px 10px;
  }
</style>
