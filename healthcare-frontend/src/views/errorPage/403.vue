<template>
  <a-result status="403" :title="title" :sub-title="message">
    <template #extra>
      <a-button type="primary" @click="back">
        Back Home
      </a-button>
    </template>
  </a-result>
</template>
<script>
export default {
  name: '403',
  data () {
    return {
      title: 'Authorized Reject',
      message: 'Sorry, you are not authorized to access this page.'
    }
  },
  methods: {
    back () {
      this.$router.push('/elderlyHealthcare/home')
    }
  }
}
</script>
