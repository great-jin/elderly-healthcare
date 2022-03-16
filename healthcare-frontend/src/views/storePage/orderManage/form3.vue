<template>
  <a-result
    status="success"
    title="订单提交成功!"
    sub-title="订单号: 2017182818828182881."
  >
    <template #extra>
      <a-button type="primary" @click="next(1)" style="margin-right: 10px">上一步</a-button>
      <a-button key="buy">完&nbsp;&nbsp;&nbsp;&nbsp;成</a-button>
    </template>
  </a-result>
</template>

<script>
export default {
  name: "form3",
  data() {
    return {
    }
  },
  methods: {
    next(data) {
      this.$emit("changeData", data)
    }
  }
}
</script>

<style scoped>

</style>
