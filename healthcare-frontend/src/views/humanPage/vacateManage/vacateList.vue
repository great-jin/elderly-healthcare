<template>
  <a-list
    class="demo-loadmore-list"
    :loading="loading"
    item-layout="horizontal"
    :data-source="data"
    style="padding: 0px 20px"
  >
    <a-list-item slot="renderItem" slot-scope="item">
      <a-list-item-meta
        :description="item.desc"
      >
        <span slot="title">{{ item.title }}</span>
      </a-list-item-meta>
      <a-button slot="actions" type="link" @click="showProcess(item)">查看进度</a-button>
      <processModal ref="processModal" />
    </a-list-item>
  </a-list>
</template>

<script>
import processModal from './processModal'

export default {
  components: {
    processModal
  },
  data () {
    return {
      loading: false,
      data: [
        {
          desc: 'this is desc',
          title: 'hello'
        },
        {
          desc: 'this is desc',
          title: 'hello'
        },
        {
          desc: 'this is desc',
          title: 'hello'
        }
      ]
    }
  },
  mounted () {
    this.getData()
  },
  methods: {
    getData () {
    },
    showProcess (data) {
      this.$refs.processModal.paramReceive(data)
    }
  }
}
</script>

<style>
  .demo-loadmore-list {
    min-height: 380px;
    border: lightgray 2px solid;
  }
</style>
