<template>
  <div style="padding: 10px">
    <a-form-model
      ref="searchForm"
      v-model="searchData"
      style="margin-bottom: 15px; font-weight: bold"
    >
      <a-row>
        <a-col :span="6">
          <a-form-model-item
            label="病人"
            :label-col="labelCol"
            :wrapper-col="wrapperCol"
          >
            <a-select
              v-model="searchData.patientId"
              :allowClear="true"
              placeholder="请选择病人"
              :value="null"
              style="padding: 0 5px"
            >
              <a-select-option
                v-for="cases in patientCaseData"
                :key="cases.patientId"
                :value="cases.patientId"
              >{{ cases.patientName }}</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="6">
          <a-form-model-item
            label="护理员"
            :label-col="labelCol"
            :wrapper-col="wrapperCol"
          >
            <a-select
              v-model="searchData.chargeNurse"
              :allowClear="true"
              placeholder="请选择护理员"
              :value="undefined"
              style="padding: 0 5px"
            >
              <a-select-option
                v-for="cases in patientCaseData"
                :key="cases.chargeNurse"
                :value="cases.chargeNurse"
              >{{ cases.chargeNurse }}</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="12">
          <a-button @click="refresh" class="task-search-button">重置</a-button>
          <a-button @click="searchOk" type="primary" class="task-search-button" style="margin-right: 15px">查询</a-button>
        </a-col>
      </a-row>
    </a-form-model>

    <a-table
      :columns="columns"
      :data-source="patientCaseData"
      :bordered="false"
      :scroll="{ x: 900 }"
      :pagination="{ pageSize: 5 }"
    >
      <template slot="action" slot-scope="record">
        <a-button type="link" @click="clickOption('more', record)">详情</a-button>
        <a-button type="link" @click="clickOption('edit', record)">新增</a-button>
        <patientDrawer ref="patientDrawer" />
      </template>
    </a-table>
  </div>
</template>

<script>
import { columns } from "./const";
import patientDrawer from "./patientDrawer";
import { listCaseInfo } from '@/api/patientCaseInfo.js';

export default {
  inject: ['reload'],
  components: {
    patientDrawer,
  },
  data() {
    return {
      dataSource: [],
      patientCaseData: [],
      searchData: {
        patientId: '',
        chargeNurse: '',
        chargeDoctor: ''
      },
      labelCol: {
        xs: { span: 24 },
        sm: { span: 5 }
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
  mounted() {
    this.getData()
  },
  methods: {
    getData() {
      listCaseInfo().then(res =>{
        this.patientCaseData = res.data
      })
    },
    searchOk () {
      const _searchInfo = this.searchData
      listCaseInfo(_searchInfo).then(res =>{
        this.patientCaseData = res.data
      })
    },
    async refresh () {
      await this.clickOption('reset')
    },
    async clickOption (type, data) {
      switch (type) {
        case 'reset':
          this.$refs.searchForm.resetFields()
          this.getData()
          break
        case 'edit':
          console.log('edit', data.patientId)
          this.$refs.patientDrawer.paramReceive(type, data)
          break
        case 'more':
          console.log('more', data.patientId)
          this.$refs.patientDrawer.paramReceive(type, data)
          break
      }
    }
  }
}
</script>

<style scoped>
  .task-search-button{
    float: right;
    z-index: 1;
  }
</style>
