<template>
  <a-modal
    title="流程详情"
    :visible="visible"
    width="70%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="back" @click="cancel">取消</a-button>
    </template>

    <div>
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
    paramReceive (type, data) {
      this.type = type
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
</style>
