<template>
  <a-result status="500" :title="title" :sub-title="message">
    <template #extra>
      <a-button type="primary" @click="back">
        Back Home
      </a-button>
    </template>
  </a-result>
</template>
<script>
export default {
  name: '500',
  data() {
    return {
      title: 'Server Error',
      message: 'Sorry, the server is wrong.'
    }
  },
  methods: {
    back(){
      this.$router.push('/elderlyHealthcare/service')
    }
  }
}
</script>
