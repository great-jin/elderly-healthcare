<template>
  <a-row :style="{padding: '10px'}">
    <a-col :span="11" :style="{padding: '10px 30px'}">
      <a-row :style="{textAlign: 'center', paddingBottom: '25px'}">
        <span class="pay-title">消费登记</span>
      </a-row>
      <a-row :style="{marginBottom: '25px'}">
        <a-col :span="12">
          <span><strong>病号：</strong>
            <a-select
              v-model="patientId"
              :disabled="true"
              placeholder="请选择病人"
              style="width: 65%"
            />
          </span>
        </a-col>
        <a-col :span="12">
          <span><strong>病人：</strong>
            <a-select
              v-model="patientId"
              :allowClear="true"
              placeholder="请选择病人"
              style="width: 65%"
            >
              <a-select-option
                v-for="cases in patientList"
                :key="cases.patientId"
                :value="cases.patientId"
              >{{ cases.patientName }}
              </a-select-option>
            </a-select>
          </span>
        </a-col>
      </a-row>
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
        <span><strong>单价：</strong>
          <a-input-number
            v-model="goodsInfo.goodsPrice"
            :disabled="true"
            style="width: 82%"
          />
        </span>
      </a-row>
      <a-row :style="{marginBottom: '25px'}">
        <span><strong>数量：</strong>
          <a-input-number
            v-model="goodsInfo.orderNum"
            :min="0"
            :disabled="goodsInfo.goodsName===''"
            @change="changeCount"
            style="width: 82%"
          />
        </span>
      </a-row>
      <a-row :style="{marginBottom: '25px'}">
        <span><strong>合计：</strong>
          <a-input-number
            v-model="goodsInfo.orderCount"
            :disabled="true"
            style="width: 82%"
          />
        </span>
      </a-row>
      <a-row :style="{textAlign: 'center'}">
        <a-button type="primary" @click="see">查看</a-button>
        <a-button type="primary" @click="ok" style="margin-left: 25px">确认</a-button>
        <a-button type="primary" @click="cancel" style="margin-left: 25px">清空</a-button>
        <GoodsDrawer ref="goodsDrawer"/>
      </a-row>
    </a-col>
    <a-col :span="13" :style="{padding: '10px'}">
      <a-row :style="{margin: '0 0 15px 5px'}">
        <a-col :span="12">
          <span><strong>产品类别：</strong>
            <a-select
              v-model="goodsType"
              :allowClear="true"
              placeholder="请选择类别"
              style="width: 50%"
            >
              <a-select-option
                v-for="item in catalogList"
                :key="item"
                :value="item"
              >{{ item }}
              </a-select-option>
            </a-select>
          </span>
        </a-col>
        <a-col :span="12">
          <a-button
            type="primary"
            @click="refresh"
            style="float: right; z-index: 1"
          >取消</a-button>
          <a-button
            type="primary"
            @click="search"
            style="float: right; z-index: 1; margin-right: 10px"
          >查询</a-button>
        </a-col>
      </a-row>
      <a-row>
        <a-table
          :columns="columns"
          :data-source="data"
          :locale="locale"
          :customRow="customRow"
          :pagination="pagination"
          :scroll="{ y: 300}"
          style="min-height: 250px"
        />
      </a-row>
    </a-col>
  </a-row>
</template>

<script>
import GoodsDrawer from './costDrawer'
import { columns } from './const'
import Empty from '@/views/utils/empty'
import { listGoods } from '@/api/warehouseStorage'
import { listCostInfo } from '@/api/patientCostInfo'

export default {
  name: 'PaymentManage',
  components: {
    Empty,
    GoodsDrawer
  },
  data () {
    return {
      columns,
      data: [],
      patientList: [],
      goodsType: undefined,
      catalogList: [],
      goodsList: [],
      patientId: undefined,
      goodsInfo: {
        goodsName: '',
        goodsType: '',
        goodsPrice: '',
        orderNum: 0,
        orderCount: 0
      },
      pagination: {
        total: 0,
        defaultPageSize: 5,
        showSizeChanger: true,
        pageSizeOptions: ['5', '10', '20', '30'],
        showTotal: total => `共 ${total} 条数据`,
        onShowSizeChange: (current, pageSize) => this.pageSize = pageSize
      },
      locale: {
        emptyText: <Empty text="消费已结清"/>
      }
    }
  },
  created () {
    this.getData()
  },
  methods: {
    getData () {
      listGoods().then(res => {
        this.goodsList = res.data
        this.data = this.goodsList
        // 获取所有产品类别并去重
        const typeList = this.data.map(item => item.goodsType)
        const result = typeList.filter(function (element, index, array) {
          return array.indexOf(element) === index
        })
        this.catalogList = result
      })
      listCostInfo().then(res => {
        this.patientList = res.data
      })
    },
    changeCount (value) {
      this.goodsInfo.orderCount = Number(this.goodsInfo.goodsPrice) * Number(value)
    },
    search () {
      // 按产品类别过滤数据
      this.data = this.goodsList.filter(item => item.goodsType === this.goodsType)
    },
    refresh () {
      this.goodsType = undefined
      this.data = this.goodsList
    },
    ok () {
      if (this.patientId !== undefined) {
        if (this.goodsInfo.orderCount instanceof Number && this.goodsInfo.orderCount > 0) {
          // 提交新消费记录
          this.$message.error('ok')
        } else {
          this.$message.error('请选择数量')
        }
      } else {
        this.$message.error('请先选择病人')
      }
    },
    see () {
      if (this.patientId !== undefined) {
        // 根据病人编号查看已有消费
        this.$refs.goodsDrawer.paramReceive(this.patientId)
      } else {
        this.$message.error('请先选择病人')
      }
    },
    cancel () {
      this.goodsInfo = {}
    },
    customRow (record) {
      return {
        on: {
          click: () => {
            if (this.patientId !== undefined) {
              this.goodsInfo = record
            } else {
              this.$message.error('请先选择病人')
            }
          }
        }
      }
    }
  }
}
</script>

<style>
.pay-title {
  color: #1890ff;
  font-size: 20px;
  font-weight: 600;
}
</style>
