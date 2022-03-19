<template>
  <div>
    <a-tree-select
      v-model="value"
      :tree-data="treeData"
      class="tree"
      style="width: 100%"
      tree-checkable
    />
    <a-input v-model="result" />
    <a-button type="primary" @click="ok">展示数据</a-button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      value: [],
      treeData: [],
      result: []
    }
  },
  mounted() {
    const orgName = [
      {
        id: '123',
        title: '福州',
        value: '123'
      }, {
        id: '124',
        title: '泉州',
        value: '124'
      }
    ]
    this.treeData = orgName
    orgName.forEach(org => {
      this.value.push(org.value)
    })
    console.log(this.value)
  },
  methods: {
    ok() {
      this.result = this.value
    }
  }
}
</script>

<style>
  .tree .ant-select-selection__rendered{
    height: 100px;
  }
  .ant-select-tree-dropdown{
    display: none;
  }
</style>
