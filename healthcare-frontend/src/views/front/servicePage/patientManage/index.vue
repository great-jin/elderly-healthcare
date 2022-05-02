<template>
  <div style="padding: 10px">
    <a-form-model
      ref="searchForm"
      :model="searchData"
      labelAlign="left"
      style="margin-bottom: 10px; font-weight: bold"
    >
      <a-row style="padding-left: 5px">
        <a-col :span="5">
          <a-form-model-item
            label="病人"
            prop="patientId"
            :label-col="labelCol"
            :wrapper-col="wrapperCol"
          >
            <a-select
              v-model="searchData.patientId"
              :allowClear="true"
              placeholder="请选择病人"
              style="padding: 0 5px"
            >
              <a-select-option
                v-for="option in patientCaseData"
                :key="option.patientId"
                :value="option.patientId"
              >{{ option.patientName }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="5">
          <a-form-model-item
            label="护理"
            prop="nurseName"
            :label-col="labelCol"
            :wrapper-col="wrapperCol"
          >
            <a-select
              v-model="searchData.nurseName"
              :allowClear="true"
              placeholder="请选择护理"
              style="padding: 0 5px"
            >
              <a-select-option
                v-for="option in (patientCaseData.map(item => item.nurseName)).filter(function (element, index, array) { return array.indexOf(element) === index })"
                :key="option"
                :value="option"
              >{{ option }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="5">
          <a-form-model-item
            label="医师"
            prop="doctorName"
            :label-col="labelCol"
            :wrapper-col="wrapperCol"
          >
            <a-select
              v-model="searchData.doctorName"
              :allowClear="true"
              placeholder="请选择医师"
              style="padding: 0 5px"
            >
              <a-select-option
                v-for="option in (patientCaseData.map(item => item.doctorName)).filter(function (element, index, array) { return array.indexOf(element) === index })"
                :key="option"
                :value="option"
              >{{ option }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="9">
          <a-button @click="refresh" class="task-search-button">重置</a-button>
          <a-button @click="searchOk" type="primary" class="task-search-button" style="margin-right: 15px">查询</a-button>
        </a-col>
      </a-row>
    </a-form-model>
    <a-row>
      <a-col :span="12">
        <a-button
          type="primary"
          @click="clickOption('add', null)"
          style="margin-bottom: 15px; width: 100px"
        >新增
        </a-button>

        <AddPatientModal ref="addPatientModal"/>
      </a-col>
    </a-row>

    <a-table
      :columns="columns"
      :data-source="patientCaseData"
      :bordered="false"
      :scroll="{ x: 900 }"
      :pagination="pagination"
    >
      <template slot="action" slot-scope="record">
        <a-button type="link" @click="clickOption('more', record)">详情</a-button>
        <a-button type="link" @click="clickOption('edit', record)">更新</a-button>
        <a-button type="link" @click="clickOption('update', record)">记录</a-button>

        <DataDrawer ref="dataDrawer"/>
        <PatientDrawer ref="patientDrawer"/>
      </template>
    </a-table>
  </div>
</template>

<script>
import { columns } from './const'
import DataDrawer from './addBodyInfo/dataDrawer'
import PatientDrawer from './addBodyInfo/patientDrawer'
import AddPatientModal from './addPatientModal'
import { listCaseInfo } from '@/api/patientCaseInfo.js'

export default {
  inject: ['reload'],
  components: {
    DataDrawer,
    PatientDrawer,
    AddPatientModal
  },
  data () {
    return {
      searchData: {
        patientId: undefined,
        nurseName: undefined,
        doctorName: undefined
      },
      patientCaseData: [],
      pagination: {
        total: 0,
        defaultPageSize: 5,
        showSizeChanger: true,
        pageSizeOptions: ['5', '10', '20', '30'],
        showTotal: total => `共 ${total} 条数据`,
        onShowSizeChange: (current, pageSize) => this.pageSize = pageSize
      },
      labelCol: {
        xs: { span: 24 },
        sm: { span: 4 }
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 18 }
      }
    }
  },
  computed: {
    columns () {
      return columns(this)
    }
  },
  mounted () {
    this.getData()
  },
  methods: {
    getData () {
      listCaseInfo().then(res => {
        this.patientCaseData = res.data
      })
    },
    searchOk () {
      const _searchInfo = this.searchData
      listCaseInfo(_searchInfo).then(res => {
        this.patientCaseData = res.data
      })
    },
    refresh () {
      this.clickOption('reset')
    },
    clickOption (type, data) {
      switch (type) {
        case 'reset':
          this.$refs.searchForm.resetFields()
          this.getData()
          break
        case 'add':
          this.$refs.addPatientModal.paramReceive(type, data)
          break
        case 'edit':
          this.$refs.addPatientModal.paramReceive(type, data)
          break
        case 'update':
          this.$refs.patientDrawer.paramReceive(type, data)
          break
        case 'more':
          this.$refs.dataDrawer.paramReceive(data.patientId)
          break
      }
    }
  }
}
</script>

<style scoped>
.task-search-button {
  width: 100px;
  float: right;
  z-index: 1;
}
</style>
