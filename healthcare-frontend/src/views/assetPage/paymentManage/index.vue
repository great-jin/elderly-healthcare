<template>
  <a-row :style="{padding: '10px'}">
    <a-col :span="14" :style="{paddingLeft: '10px'}">
      <a-row :style="{marginBottom: '20px'}">
        <a-col>
          <a-select
            v-model="patientId"
            :allowClear="true"
            placeholder="请选择病人"
            @change="onchange"
            style="padding: 0 5px; width: 170px"
          >
            <a-select-option
              v-for="cases in patientList"
              :key="cases.patientId"
              :value="cases.patientId"
            >{{ cases.patientName }}
            </a-select-option>
          </a-select>
        </a-col>
      </a-row>
      <a-row>
        <a-table
          :columns="columns"
          :data-source="data"
          :pagination="pagination"
          :locale="locale"
        />
      </a-row>
    </a-col>
    <a-col :span="10" :style="{padding: '55px 30px'}">
      <a-row :style="{marginBottom: '25px'}">
        <h4>总价：
          <a-input-number
            v-model="payment.totall"
            :disabled="true"
            style="width: 80%"
          />
        </h4>
      </a-row>
      <a-row :style="{marginBottom: '25px'}">
        <h4>实收：
          <a-input-number
            v-model="payment.receive"
            @change="payCharge"
            style="width: 80%"
          />
        </h4>
      </a-row>
      <a-row :style="{marginBottom: '25px'}">
        <h4>找零：
          <a-input-number
            v-model="payment.charge"
            :disabled="true"
            style="width: 80%"
          />
        </h4>
      </a-row>
      <a-row :style="{textAlign: 'center'}">
        <a-button type="primary" @click="ok">确认</a-button>
        <a-button type="primary" @click="cancel" style="margin-left: 50px">清空</a-button>
      </a-row>
    </a-col>
  </a-row>
</template>

<script>
import { columns } from './const'
import Empty from '@/views/utils/empty'
import { getCost } from '@/api/patientCostDetail'
import { listCostInfo, updateCostInfo } from '@/api/patientCostInfo'

export default {
  name: 'PaymentManage',
  components: {
    Empty
  },
  data () {
    return {
      columns,
      data: [],
      patientList: [],
      patientId: undefined,
      costId: '',
      pagination: {
        total: 0,
        defaultPageSize: 5,
        showSizeChanger: true,
        pageSizeOptions: ['5', '10', '20', '30'],
        showTotal: total => `共 ${total} 条数据`,
        onShowSizeChange: (current, pageSize) => this.pageSize = pageSize
      },
      locale: {
        emptyText: <Empty text="消费已结清" />
      },
      payment: {
        totall: 0.0,
        receive: 0.0,
        charge: 0.0
      }
    }
  },
  created () {
    this.getData()
  },
  methods: {
    getData () {
      listCostInfo().then(res => {
        this.patientList = res.data
      })
    },
    onchange (value) {
      this.payment.totall = 0
      getCost(value).then(res => {
        this.costId = res.data.costId
        this.data = res.data
        // 消费总金额
        let allCost = 0
        res.data.forEach(cost => {
          allCost += Number(cost.costCount)
        })
        this.payment.totall = allCost
      })
    },
    payCharge (value) {
      this.payment.charge = Number(this.payment.totall) - Number(value)
    },
    ok () {
      if (this.payment.charge >= 0) {
        const _info = {
          costId: this.costId,
          isPay: 1
        }
        console.log(this.costId)
        console.log(_info)
        updateCostInfo(_info).then(res => {
          if (res.data !== null) {
            this.$message.success('ok')
            this.data = []
            this.cancel()
          }
        })
      } else {
        this.$message.error('error')
      }
    },
    cancel () {
      this.payment.receive = 0.0
      this.payment.charge = 0.0
    }
  }
}
</script>

<style>
</style>
