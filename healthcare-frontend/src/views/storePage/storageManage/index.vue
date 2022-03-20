<template>
  <div style="background-color: white;">
    <a-row>
      <a-form
        :form="form"
        :label-col="labelCol"
        :wrapper-col="wrapperCol"
      >
        <a-form-item label="上报计划" class="required">
          <a-button type="link" style="margin-right: 30px" @click="addReport">新增</a-button>
          <a-button type="link" style="margin-right: 30px" @click="ok">完成</a-button>
        </a-form-item>
        <div
          v-for="(item, index) in dynamicInfo"
          :key="index"
          style="margin-bottom: 15px; margin-left: 50px"
        >
          <a-row>
            <a-col :span="2" />
            <a-col :span="7">
              <a-form-item
                label="上报周期"
                :label-col="formItemLayout.labelCol"
                :wrapper-col="formItemLayout.wrapperCol"
                :prop="`dynamicInfo[${index}].selectReportPeriod`"
                class="required"
              >
                <a-select
                  placeholder="请选择上报周期"
                  v-decorator="[
                    `${index}.reportPeriod`,
                    { rules: [{ required: false, message: '上报周期不能为空' }] }
                  ]"
                >
                  <a-select-option value="年">年</a-select-option>
                  <a-select-option value="月">月</a-select-option>
                  <a-select-option value="日">日</a-select-option>
                </a-select>
              </a-form-item>
            </a-col>
            <a-col :span="7">
              <a-form-item
                label="上报时间"
                :label-col="formItemLayout.labelCol"
                :wrapper-col="formItemLayout.wrapperCol"
                :prop="`dynamicInfo[${index}].reportPeriod`"
                class="required"
              >
                <a-select
                  placeholder="请选择上报时间"
                  v-decorator="[
                    `${index}.reportDate`,
                    { rules: [{ required: false, message: '上报时间不能为空' }] }
                  ]"
                  class="required"
                >
                  <a-select-option value="每月10号">每月10号</a-select-option>
                </a-select>
              </a-form-item>
            </a-col>
            <a-icon
              class="dynamic-delete-button"
              type="minus-circle-o"
              @click="() => remove(item)"
            />
          </a-row>
          <a-row>
            <a-col :span="2" />
            <a-col :span="12">
              <a-form-item
                label="上报单位"
                :wrapper-col="formItemLayout.wrapperCol"
                :prop="`dynamicInfo[${index}].orgList[]`"
                class="required"
              >
                <a-tree-select
                  :tree-data="treeData"
                  class="tree"
                  v-decorator="[
                    `${index}.orgList[]`,
                    { rules: [{ required: false, message: '上报单位不能为空' }] }
                  ]"
                  style="width: 100%;"
                  tree-checkable
                  :show-checked-strategy="SHOW_PARENT"
                  search-placeholder="Please select"
                />
              </a-form-item>
            </a-col>
            <a-col>
              <a-button type="link" @click="openOrgModal(index, item.uuid)">选择</a-button>
              <orgModal ref="orgModal" @getOrg="getModalValues" />
            </a-col>
          </a-row>
        </div>
      </a-form>
    </a-row>
  </div>
</template>

<script>
import orgModal from './orgModal'
import { TreeSelect } from 'ant-design-vue';
const SHOW_PARENT = TreeSelect.SHOW_PARENT;

const treeData = [
  {
    title: 'Node1',
    value: '0-0',
    key: '0-0',
    children: [
      {
        title: 'Child Node1',
        value: '0-0-0',
        key: '0-0-0',
      },
    ],
  },
  {
    title: 'Node2',
    value: '0-1',
    key: '0-1',
    children: [
      {
        title: 'Child Node3',
        value: '0-1-0',
        key: '0-1-0',
        disabled: true,
      },
      {
        title: 'Child Node4',
        value: '0-1-1',
        key: '0-1-1',
      },
      {
        title: 'Child Node5',
        value: '0-1-2',
        key: '0-1-2',
      },
    ],
  },
];

export default {
  name: 'index',
  components: {
    orgModal
  },
  data () {
    return {
      value: ['0-0-0'],
      treeData,
      SHOW_PARENT,
      dynamicInfo: [
        {
          reportPeriod: '',
          reportDate: '',
          orgList: []
        }
      ],
      labelCol: { span: 4 },
      wrapperCol: { span: 14 },
      formItemLayout: {
        labelCol: { span: 7 },
        wrapperCol: { span: 14 }
      },
      form: this.$form.createForm(this)
    }
  },
  methods: {
    openOrgModal (index, data) {
      this.$refs.orgModal[index].paramReceive(data)
    },
    getModalValues (pram) {
      console.log(pram)
    },
    ok () {
      this.form.validateFields((errors, values) => {
        if (!errors) {
          console.log(values)
        }
      })
    },
    cancel () {
      this.dynamicInfo = []
      this.form.resetFields()
    },
    guid () {
      return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        var r = Math.random() * 16 | 0
        var v = c === 'x' ? r : (r & 0x3 | 0x8)
        return v.toString(16)
      })
    },
    addReport () {
      this.dynamicInfo.push({
        uuid: this.guid(),
        reportPeriod: '',
        reportDate: '',
        orgName: ''
      })
    },
    remove (item) {
      console.log('item', item)
      this.dynamicInfo = this.dynamicInfo.filter(op => (op.uuid !== item.uuid))
    }
  }
}
</script>

<style>
  .required .ant-form-item-label label::before {
    content: '*';
    line-height: 1;
    display: inline-block;
    margin-right: 4px;
    color: #f5222d;
    font-size: 14px;
    font-family: SimSun, sans-serif;
  }
  .tree .ant-select-selection__rendered{
    height: 100px;
  }
  .ant-select-tree-dropdown{
    display: none;
  }
</style>
