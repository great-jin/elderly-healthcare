<template>
  <div>
    <a-card title="流程" style="width: 100%; margin: 5px 10px; padding: 5px 10px">
      <a-steps>
        <a-step status="finish" title="Login">
          <a-icon slot="icon" type="user" />
        </a-step>
        <a-step status="finish" title="Verification">
          <a-icon slot="icon" type="solution" />
        </a-step>
        <a-step status="process" title="Pay">
          <a-icon slot="icon" type="loading" />
        </a-step>
        <a-step status="wait" title="Done">
          <a-icon slot="icon" type="smile-o" />
        </a-step>
      </a-steps>
    </a-card>
  </div>
</template>
<script>
export default {
  data() {
    return {
      current: 0,
      steps: [
        {
          title: 'First',
          content: 'First-content',
        },
        {
          title: 'Second',
          content: 'Second-content',
        },
        {
          title: 'Last',
          content: 'Last-content',
        },
      ],
    };
  },
  methods: {
    next() {
      this.current++;
    },
    prev() {
      this.current--;
    },
  },
};
</script>
<style scoped>
  .steps-content {
    margin-top: 16px;
    border: 1px dashed #e9e9e9;
    border-radius: 6px;
    background-color: #fafafa;
    min-height: 200px;
    text-align: center;
    padding-top: 80px;
  }

  .steps-action {
    margin-top: 24px;
  }
</style>
