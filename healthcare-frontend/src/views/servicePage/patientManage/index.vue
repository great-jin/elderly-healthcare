<template>
  <div style="padding: 10px">
    <a-form-model
      ref="searchForm"
      :model="searchData"
      style="margin-bottom: 10px; font-weight: bold"
    >
      <a-row>
        <a-col :span="6">
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
                v-for="cases in patientCaseData"
                :key="cases.patientId"
                :value="cases.patientId"
              >{{ cases.patientName }}</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="6">
          <a-form-model-item
            label="护理"
            prop="chargeNurse"
            :label-col="labelCol"
            :wrapper-col="wrapperCol"
          >
            <a-select
              v-model="searchData.chargeNurse"
              :allowClear="true"
              placeholder="请选择护理"
              style="padding: 0 5px"
            >
              <a-select-option
                v-for="cases in nurseList"
                :key="cases.staffId"
                :value="cases.staffId"
              >{{ cases.staffName }}</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="6">
          <a-form-model-item
            label="医师"
            prop="chargeDoctor"
            :label-col="labelCol"
            :wrapper-col="wrapperCol"
          >
            <a-select
              v-model="searchData.chargeDoctor"
              :allowClear="true"
              placeholder="请选择医师"
              style="padding: 0 5px"
            >
              <a-select-option
                v-for="cases in doctorList"
                :key="cases.staffId"
                :value="cases.staffId"
              >{{ cases.staffName }}</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
      </a-row>
    </a-form-model>
    <a-row>
      <a-col :span="12">
        <a-button @click="clickOption('add', null)" type="primary" style="margin-bottom: 15px">新增</a-button>

        <addPatientModal ref="addPatientModal" />
      </a-col>
      <a-col :span="12">
        <a-button @click="refresh" class="task-search-button">重置</a-button>
        <a-button @click="searchOk" type="primary" class="task-search-button" style="margin-right: 15px">查询</a-button>
      </a-col>
    </a-row>

    <a-table
      :columns="columns"
      :data-source="patientCaseData"
      :bordered="false"
      :scroll="{ x: 900 }"
      :pagination="{ pageSize: 5 }"
    >
      <template slot="action" slot-scope="record">
        <a-button type="link" @click="clickOption('more', record)">详情</a-button>
        <a-button type="link" @click="clickOption('edit', record)">编辑</a-button>
        <a-button type="link" @click="clickOption('update', record)">更新</a-button>
        <patientDrawer ref="patientDrawer" />
      </template>
    </a-table>
  </div>
</template>

<script>
import { columns } from "./const";
import patientDrawer from "./patientDrawer";
import addPatientModal from "./addPatientModal";
import { listNurse } from '@/api/staffNurse.js';
import { listDoctor } from '@/api/staffDoctor.js';
import { listCaseInfo } from '@/api/patientCaseInfo.js';

export default {
  inject: ['reload'],
  components: {
    patientDrawer,
    addPatientModal
  },
  data() {
    return {
      dataSource: [],
      patientCaseData: [],
      searchData: {
        patientId: undefined,
        chargeNurse: undefined,
        chargeDoctor: undefined,
      },
      nurseList: [],
      doctorList: [],
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
      listNurse().then(res =>{
        this.nurseList = res.data
      })
      listDoctor().then(res =>{
        this.doctorList = res.data
      })
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
          this.$refs.patientDrawer.paramReceive(type, data)
          break
      }
    }
  }
}
</script>

<style scoped>
  .task-search-button{
    width: 100px;
    float: right;
    z-index: 1;
  }
</style>
