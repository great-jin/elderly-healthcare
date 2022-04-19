<template>
  <div class="empty-wrap">
    <img
      alt=""
      :src="imgSrc|| require('@/assets/1.png')"
      style="width: 150px; height: 150px">
    <div style="{'font-size':fontSize 'px'}">{{ text }}</div>
  </div>
</template>

<script>
export default {
  name: 'empty',
  props: {
    text: {
      type: String,
      default: ''
    },
    imgSrc: {
      type: String,
      default: ''
    }
  }
}
</script>

<style scoped>

</style>
