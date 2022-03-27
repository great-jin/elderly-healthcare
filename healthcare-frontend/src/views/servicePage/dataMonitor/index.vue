<template>
  <div id="app">
    <div style="background: #ECECEC; padding: 5px">
      <a-row :gutter="16">
        <a-col :span="8">
          <a-card>
            <a-statistic
              title="Feedback"
              :value="11.28"
              :precision="2"
              suffix="%"
              :value-style="{ color: '#3f8600' }"
              style="margin-right: 50px"
            >
              <template #prefix>
                <a-icon type="arrow-up" />
              </template>
            </a-statistic>
          </a-card>
        </a-col>
        <a-col :span="8">
          <a-progress :percent="30" />
          <a-progress :percent="30" />
          <a-progress :percent="30" />
          <a-progress :percent="30" />
          <a-progress :percent="30" />
        </a-col>
        <a-col :span="8">
          <a-card>
            <a-statistic
              title="Idle"
              :value="9.3"
              :precision="2"
              suffix="%"
              class="demo-class"
              :value-style="{ color: '#cf1322' }"
            >
              <template #prefix>
                <a-icon type="arrow-down" />
              </template>
            </a-statistic>
          </a-card>
        </a-col>
      </a-row>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      fileName: '',
      fileBucket: ''
    }
  },
  methods: {
  }
}
</script>

<style scoped>
</style>
