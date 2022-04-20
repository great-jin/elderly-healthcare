<template>
  <a-modal
    title="消费记录信息"
    :visible="visible"
    width="40%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="submit" type="primary" @click="ok">确定</a-button>
      <a-button key="back" @click="cancel">取消</a-button>
    </template>
    <div>
      <a-row :style="{marginBottom: '25px'}">
        <span><strong>名称：</strong>
          <a-input-number
            v-model="goodsInfo.goodsName"
            :disabled="true"
            style="width: 82%"
          />
        </span>
      </a-row>
      <a-row :style="{marginBottom: '25px'}">
        <span><strong>数量：</strong>
          <a-input-number
            v-model="goodsInfo.goodsNumber"
            :min="0"
            @change="changeCount"
            style="width: 82%"
          />
        </span>
      </a-row>
      <a-row :style="{marginBottom: '25px'}">
        <span><strong>单价：</strong>
          <a-input-number
            v-model="goodsInfo.goodsPrice"
            :disabled="true"
            style="width: 82%"
          />
        </span>
      </a-row>
      <a-row :style="{marginBottom: '25px'}">
        <span><strong>合计：</strong>
          <a-input-number
            v-model="goodsInfo.costCount"
            :disabled="true"
            style="width: 82%"
          />
        </span>
      </a-row>
    </div>
  </a-modal>
</template>

<script>
export default {
  name: 'CostModal',
  data () {
    return {
      type: '',
      visible: false,
      goodsInfo: {
        goodsName: '',
        goodsType: '',
        goodsPrice: '',
        goodsNumber: 0,
        costCount: 0
      }
    }
  },
  methods: {
    paramReceive (data) {
      this.visible = true
      this.goodsInfo = data
    },
    cancel () {
      this.visible = false
    },
    ok () {
      this.$message.success('ok')
    },
    changeCount (value) {
      this.goodsInfo.costCount = Number(this.goodsInfo.goodsPrice) * Number(value)
    }
  }
}
</script>

<style scoped>

</style>
