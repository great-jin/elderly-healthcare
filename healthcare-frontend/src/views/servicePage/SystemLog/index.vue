<template>
  <div>
    <a-tabs type="card" @change="callback">
      <a-tab-pane key="1" tab="Tab 1">
        Content of Tab Pane 2
      </a-tab-pane>
      <a-tab-pane key="2" tab="Tab 2">
        Content of Tab Pane 2
      </a-tab-pane>
      <a-tab-pane key="3" tab="Tab 3">
        Content of Tab Pane 3
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
    }
  },
  methods: {
    callback(key) {
      console.log(key);
    },
  }
}
</script>

<style scoped>

</style>
