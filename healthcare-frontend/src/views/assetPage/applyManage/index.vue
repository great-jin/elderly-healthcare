<template>
  <div>
    <a-tabs type="card" @change="callback">
      <a-tab-pane key="1" tab="信息填写">
        <a-descriptions title="资产申请" style="padding: 0px 10px" bordered>
          <a-descriptions-item label="申请单位">
            <a-select placeholder="请选择单位" style="width: 100%; min-width: 100px">
              <a-select-option v-for="org in organize" :key="org.organizeId" :value="org.organizeName">
                {{ org.organizeName }}
              </a-select-option>
            </a-select>
          </a-descriptions-item>
          <a-descriptions-item label="申请部门">
            <a-select placeholder="请选择部门" style="width: 100%; min-width: 100px">
              <a-select-option v-for="org in organize" :key="org.organizeId" :value="org.organizeName">
                {{ org.organizeName }}
              </a-select-option>
            </a-select>
          </a-descriptions-item>
          <a-descriptions-item label="申请人">
            <a-input placeholder="请输入姓名" />
          </a-descriptions-item>
          <a-descriptions-item label="申请时间">
            <a-date-picker
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
              type="text"
              :rows="4"
              placeholder="请输入申请原因"
            />
          </a-descriptions-item>

          <a-descriptions-item label="设备信息" :span="24">
            <a-row>
              <a-col :span="2" class="apply-title">序号</a-col>
              <a-col :span="4" class="apply-title">设备名称</a-col>
              <a-col :span="3" class="apply-title">设备规格</a-col>
              <a-col :span="3" class="apply-title">设备单价</a-col>
              <a-col :span="3" class="apply-title">申请数量</a-col>
              <a-col :span="3" class="apply-title">总额</a-col>
              <a-col :span="4" class="apply-title">备注</a-col>
              <a-col :span="2" @click="addDevice" class="apply-title" style="color: #1890FF">新增</a-col>
            </a-row>
            <a-row
              v-for="(item, index) in applyInfo.orderList"
              :key="index"
              style="margin-bottom: 5px"
            >
              <a-col :span="2" style="padding: 0px 5px">
                <div class="apply-index">{{ index }}</div>
              </a-col>
              <a-col :span="4" style="padding: 0px 10px">
                <a-select
                  v-model="item.device"
                  placeholder="请选择设备"
                  style="width: 100%; min-width: 100px"
                >
                  <a-select-option v-for="goods in goodsList" :key="goods.goodsId" :value="goods.goodsName">
                    {{ goods.goodsName }}
                  </a-select-option>
                </a-select>
              </a-col>
              <a-col :span="3" style="padding: 0px 10px">
                <a-input
                  v-model="item.type"
                  placeholder="请选择规格"
                />
              </a-col>
              <a-col :span=3 style="padding: 0px 10px">
                <a-input
                  v-model="item.price"
                  placeholder="单价"
                  prefix="￥"
                  :disabled="true"
                />
              </a-col>
              <a-col :span="3" style="padding: 0px 10px;">
                <a-input-number
                  v-model="item.amount"
                  placeholder="请选择数量"
                  :min="1"
                  style="width: 100%"
                />
              </a-col>
              <a-col :span="3" style="padding: 0px 10px">
                <a-input
                  v-model="item.money"
                  placeholder="总额"
                  prefix="￥"
                  :disabled="true"
                />
              </a-col>
              <a-col :span="4" style="padding: 0px 10px">
                <a-input
                  v-model="item.comment"
                  placeholder="请输入备注"
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
            <a-input placeholder="请输入收件人" />
          </a-descriptions-item>
          <a-descriptions-item label="收件电话">
            <a-input placeholder="请输入收件电话" />
          </a-descriptions-item>
          <a-descriptions-item label="收件地址">
            <a-input placeholder="请输入收件地址" />
          </a-descriptions-item>
          <a-descriptions-item label="总金额" :span="24">
            <span>￥&nbsp;&nbsp;&nbsp;&nbsp;{{account}}&nbsp;&nbsp;&nbsp;&nbsp;RMB</span>&nbsp;
          </a-descriptions-item>
        </a-descriptions>
        <a-row style="margin-top: 20px">
          <a-col :span="24" :style="{ textAlign: 'center' }">
            <a-button type="primary" @click="ok">完成</a-button>
            <a-button type="primary" :style="{ marginLeft: '100px' }">取消</a-button>
          </a-col>
        </a-row>
      </a-tab-pane>

      <a-tab-pane key="2" tab="流程日志" style="padding: 20px 30px">
        <a-steps direction="vertical" :current="1">
          <a-step title="Finished" description="This is a description." />
          <a-step title="In Progress" description="This is a description." />
          <a-step title="Waiting" description="This is a description." />
        </a-steps>
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
import moment from 'moment'
import { listOrg } from '@/api/organizeInfo'
import { listGoods } from '@/api/warehoseStorage'

export default {
  name: 'ApplyManage',
  data () {
    return {
      organize: [],
      goodsList: [],
      applyInfo: {
        orderList: []
      },
      account: '1000'
    }
  },
  mounted () {
    this.getDict()
  },
  methods: {
    getDict () {
      listOrg().then(res => {
        this.organize = res.data
      })
      listGoods().then(res => {
        this.goodsList = res.data
        console.log(this.goodsList)
      })
    },
    callback (key) {
      console.log(key)
    },
    disabledDate (current) {
      return current && current < moment().endOf('day')
    },
    ok () {
      console.log(this.applyInfo.orderList)
    },
    addDevice () {
      this.applyInfo.orderList.push({
        uuid: this.guid(),
        device: '',
        type: '',
        price: '',
        amount: '',
        money: '',
        comment: ''
      })
    },
    remove (item) {
      this.applyInfo.orderList = this.applyInfo.orderList.filter(op => (op.uuid !== item.uuid))
    },
    guid () {
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
  input::-ms-input-placeholder{
    text-align: center;
  }
  input::-webkit-input-placeholder{
    text-align: center;
  }
  .apply-index{
    text-align: center;
    margin-top: 3px;
    border: lightgray 2px solid;
  }
  .apply-title{
    padding: 0px 5px;
    text-align: center;
    margin-bottom: 10px;
  }
  .apply-manage-remove{
    margin-top: 10px;
  }
</style>
