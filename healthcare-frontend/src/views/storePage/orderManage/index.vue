<template>
  <div>
    <a-card title="流程" style="width: 100%; margin: 10px; padding: 15px">
      <a-steps :current="current">
        <a-step v-for="item in steps" :key="item.title" :title="item.title" />
      </a-steps>
      <div class="steps-content">
        <template v-if="current === 0">
          <form1 @changeData="nextStep"></form1>
        </template>
        <template v-if="current === 1">
          <form2 @changeData="nextStep"></form2>
        </template>
        <template v-if="current === 2">
          <form3 @changeData="nextStep"></form3>
        </template>
      </div>
    </a-card>
  </div>
</template>

<script type="text/javascript">
import form1 from './form1'
import form2 from './form2'
import form3 from './form3'

export default {
  components: {
    form1: form1,
    form2: form2,
    form3: form3
  },
  data () {
    return {
      current: 0,
      steps: [
        {
          title: 'First'
        },
        {
          title: 'Second'
        },
        {
          title: 'Last'
        }
      ]
    }
  },
  methods: {
    nextStep (params) {
      this.current = params
    }
  }
}
</script>

<style scoped>
  .steps-content {
    margin-top: 16px;
    border: 1px dashed #e9e9e9;
    border-radius: 6px;
    background-color: #fafafa;
    min-height: 200px;
    text-align: center;
    padding-top: 20px;
  }
</style>
