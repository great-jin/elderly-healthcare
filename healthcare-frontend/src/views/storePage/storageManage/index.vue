<template>
  <div>
    <GoodsModal ref="goodsModal" />
  </div>
</template>

<script>
import { columns } from './const'
import GoodsModal from './goodsModal'

export default {
  name: 'index',
  components: {
    GoodsModal
  },
  data () {
    return {
      values: ''
    }
  },
  computed: {
    columns () {
      return columns(this)
    }
  },
  methods: {

  }
}
</script>

<style>
</style>
