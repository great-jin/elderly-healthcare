<template>
  <div>
    <h1>药品管理</h1>
    <MedicineModal ref="medicineModal" />
  </div>
</template>

<script>
import { columns } from './const'
import MedicineModal from './medicineModal'

export default {
  data () {
    return {
    }
  },
  components: {
    MedicineModal
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
