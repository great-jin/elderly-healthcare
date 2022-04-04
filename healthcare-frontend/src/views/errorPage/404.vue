<template>
  <a-result status="404" :title="title" :sub-title="message">
    <template #extra>
      <a-button type="primary" @click="back">
        Back Home
      </a-button>
    </template>
  </a-result>
</template>
<script>

export default {
  name: '404',
  data () {
    return {
      title: 'Not Found',
      message: 'Sorry, the page you visited does not exist.'
    }
  },
  methods: {
    back () {
      this.$router.push('/elderlyHealthcare/home')
    }
  }
}
</script>
