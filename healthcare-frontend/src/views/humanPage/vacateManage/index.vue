<template>
  <div>
    <a-steps v-model="current" type="navigation" size="small" :style="stepStyle">
      <a-step
        title="Step 1"
        sub-title="00:00:05"
        status="finish"
        description="This is a description."
      />
      <a-step
        title="Step 2"
        sub-title="00:01:02"
        status="process"
        description="This is a description."
      />
      <a-step
        title="Step 3"
        sub-title="waiting for longlong time"
        status="wait"
        description="This is a description."
      />
    </a-steps>
  </div>
</template>
<script>
export default {
  data() {
    return {
      current: 0,
      stepStyle: {
        marginBottom: '60px',
        boxShadow: '0px -1px 0 0 #e8e8e8 inset'
      }
    }
  },
}
</script>
