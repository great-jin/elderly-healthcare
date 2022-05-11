<template>
  <div>
    <a-tabs type="card" @change="callback">
      <a-tab-pane key="1" tab="申请提交">
        <a-descriptions
          style="padding: 0px 10px"
          bordered
        >
          <a-descriptions-item label="申请单位">
            <a-select
              v-model="applyInfo.organizeUnit"
              placeholder="请选择单位"
              style="width: 100%; min-width: 100px"
            >
              <a-select-option
                v-for="org in organize"
                :key="org.organizeId"
                :value="org.organizeName">
                {{ org.organizeName }}
              </a-select-option>
            </a-select>
          </a-descriptions-item>
          <a-descriptions-item label="申请部门">
            <a-select
              v-model="applyInfo.organizeName"
              placeholder="请选择部门"
              style="width: 100%; min-width: 100px"
            >
              <a-select-option
                v-for="org in organize"
                :key="org.organizeId"
                :value="org.organizeName">
                {{ org.organizeName }}
              </a-select-option>
            </a-select>
          </a-descriptions-item>
          <a-descriptions-item label="申请人">
            <a-input
              v-model="applyInfo.staffId"
              placeholder="请输入员工编号"
            />
          </a-descriptions-item>
          <a-descriptions-item label="申请时间">
            <a-date-picker
              v-model="applyInfo.applyTime"
              :disabled-date="disabledDate"
              style="width: 100%"
            />
          </a-descriptions-item>
          <a-descriptions-item label="是否专业设备">
            <a-radio-group>
              <a-radio value="1">是</a-radio>
              <a-radio value="0">否</a-radio>
            </a-radio-group>
          </a-descriptions-item>
          <a-descriptions-item>
          </a-descriptions-item>
          <a-descriptions-item label="申请原因" :span="24">
            <a-textarea
              v-model="applyInfo.applyReason"
              type="text"
              :rows="4"
              placeholder="请输入申请原因"
            />
          </a-descriptions-item>
          <a-descriptions-item label="设备信息" :span="24">
            <a-row :style="{paddingLeft:'10px'}">
              <a-col :span="2" class="apply-title">序号</a-col>
              <a-col :span="4" class="apply-title">设备名称</a-col>
              <a-col :span="4" class="apply-title">设备规格</a-col>
              <a-col :span="4" class="apply-title">设备单价</a-col>
              <a-col :span="4" class="apply-title">申请数量</a-col>
              <a-col :span="4" class="apply-title">总额</a-col>
              <a-col :span="2" @click="addDevice" class="apply-title" style="color: #1890FF">新增</a-col>
            </a-row>
            <a-row
              v-for="(item, index) in applyInfo.applyGoodsList"
              :key="index"
              style="margin-bottom: 5px; padding-left: 10px"
            >
              <a-col :span="2" style="padding: 0px 5px">
                <div class="apply-index">{{ index }}</div>
              </a-col>
              <a-col :span="4" style="padding: 0px 15px">
                <a-select
                  v-model="item.goodsName"
                  placeholder="请选择产品"
                  @change="onChange('goods',index)"
                  style="width: 100%; min-width: 100px"
                >
                  <a-select-option
                    v-for="goods in goodsList"
                    :key="goods.goodsId"
                    :value="goods.goodsName"
                  >
                    {{ goods.goodsName }}
                  </a-select-option>
                </a-select>
              </a-col>
              <a-col :span="4" style="padding: 0px 15px">
                <a-input
                  v-model="item.goodsType"
                  :disabled="true"
                  placeholder="请选择规格"
                />
              </a-col>
              <a-col :span="4" style="padding: 0px 15px">
                <a-input-number
                  v-model="item.goodsPrice"
                  placeholder="单价"
                  :disabled="true"
                  style="width: 100%"
                />
              </a-col>
              <a-col :span="4" style="padding: 0px 10px;">
                <a-input-number
                  v-model="item.applyCount"
                  placeholder="请选择数量"
                  :min="1"
                  @change="onChange('num',index)"
                  style="width: 100%"
                />
              </a-col>
              <a-col :span="4" style="padding: 0px 15px">
                <a-input-number
                  v-model="item.costMoney"
                  placeholder="总额"
                  :disabled="true"
                  style="width: 100%"
                />
              </a-col>
              <a-col :span="2" class="apply-title">
                <a-icon
                  type="minus-circle-o"
                  @click="() => remove(item)"
                  class="apply-manage-remove"
                />
              </a-col>
            </a-row>
          </a-descriptions-item>
          <a-descriptions-item label="收件人">
            <a-input
              v-model="applyInfo.receiveName"
              placeholder="请输入收件人"
            />
          </a-descriptions-item>
          <a-descriptions-item label="收件电话" :span="2">
            <a-input
              v-model="applyInfo.receivePhone"
              placeholder="请输入收件电话"
            />
          </a-descriptions-item>
          <a-descriptions-item label="收件地址">
            <a-textarea
              v-model="applyInfo.receiveAddress"
              type="text"
              :rows="2"
              placeholder="请输入收件地址"
            />
          </a-descriptions-item>
        </a-descriptions>
        <a-row style="margin-top: 20px">
          <a-col :span="24" :style="{ textAlign: 'center' }">
            <a-button type="primary" @click="ok">完成</a-button>
            <a-button type="primary" :style="{ marginLeft: '100px' }">取消</a-button>
          </a-col>
        </a-row>
      </a-tab-pane>
      <a-tab-pane key="2" tab="我的申请">
        <MyApply v-if="tag"/>
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
import moment from 'moment'
import MyApply from "./applyInfp/myApply";
import {listOrg} from '@/api/organizeInfo'
import {listGoods} from '@/api/warehouseStorage'
import {addApplyInfo} from '@/api/assetApplyInfo'

export default {
  name: 'ApplyManage',
  components: {
    MyApply
  },
  data() {
    return {
      tag: true,
      organize: [],
      goodsList: [],
      applyInfo: {
        applyGoodsList: []
      }
    }
  },
  mounted() {
    this.getData()
  },
  methods: {
    callback(key) {
      if (key === '2') {
        this.tag = false
        this.tag = true
      }
    },
    async getData() {
      await listOrg().then(res => {
        this.organize = res.data
      })
      await listGoods().then(res => {
        this.goodsList = res.data
      })
    },
    disabledDate(current) {
      return current && current < moment().endOf('day')
    },
    ok() {
      addApplyInfo(this.applyInfo).then(res => {
        if (res.data) {
          this.$message.success('提交成功')
          this.applyInfo = {}
        } else {
          this.$message.error('提交失败，请重试')
        }
      })
    },
    onChange(type, index) {
      switch (type) {
        case 'goods':
          const goods = (this.goodsList.filter(item => item.goodsName === this.applyInfo.applyGoodsList[index].goodsName))[0]
          this.applyInfo.applyGoodsList[index].goodsType = goods.goodsType
          this.applyInfo.applyGoodsList[index].goodsPrice = goods.goodsPrice
          break
        case 'num':
          const _count = this.applyInfo.applyGoodsList[index].goodsPrice * this.applyInfo.applyGoodsList[index].applyCount
          this.applyInfo.applyGoodsList[index].costMoney = _count
          break
      }
    },
    addDevice() {
      this.applyInfo.applyGoodsList.push({
        uuid: this.guid(),
        goodsName: undefined,
        goodsType: '',
        goodsPrice: 0,
        applyCount: 0,
        costMoney: 0,
        comment: ''
      })
    },
    remove(item) {
      this.applyInfo.applyGoodsList = this.applyInfo.applyGoodsList.filter(op => (op.uuid !== item.uuid))
    },
    guid() {
      return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        const r = Math.random() * 16 | 0
        const v = c === 'x' ? r : (r & 0x3 | 0x8)
        return v.toString(16)
      })
    }
  }
}
</script>

<style scoped>
input::-ms-input-placeholder {
  text-align: center;
}

input::-webkit-input-placeholder {
  text-align: center;
}

.apply-index {
  text-align: center;
  margin-top: 3px;
  border: lightgray 2px solid;
}

.apply-title {
  padding: 0px 5px;
  text-align: center;
  margin-bottom: 10px;
}

.apply-manage-remove {
  margin-top: 10px;
}
</style>
