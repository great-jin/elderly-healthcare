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
            label="任务"
            prop="taskName"
            :label-col="labelCol"
            :wrapper-col="wrapperCol"
          >
            <a-select
              v-model="searchData.taskName"
              :allowClear="true"
              placeholder="请选择任务名"
              style="padding: 0 5px"
            >
              <a-select-option
                v-for="cases in taskList"
                :key="cases.taskId"
                :value="cases.taskName"
              >{{ cases.taskName }}</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="6">
          <a-form-model-item
            label="护理"
            prop="nurseId"
            :label-col="labelCol"
            :wrapper-col="wrapperCol"
          >
            <a-select
              v-model="searchData.nurseId"
              :allowClear="true"
              placeholder="请选择护理"
              style="padding: 0 5px"
            >
              <a-select-option
                v-for="cases in nurseList"
                :key="cases.staffId"
                :value="cases.staffName"
              >{{ cases.staffName }}</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
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
          <a-button @click="searchCancel" class="task-search-button">重置</a-button>
          <a-button
            @click="searchOk"
            type="primary"
            class="task-search-button"
            :style="{marginRight: '15px'}"
          >查询</a-button>
        </a-col>
      </a-row>
    </a-form-model>

    <a-button
      type="primary"
      @click="clickOption('add', null)"
      style="margin-bottom: 20px"
    >新建任务</a-button>
    <a-table
      :columns="columns"
      :data-source="taskData"
      :pagination="{ pageSize: 5 }"
    >
      <a-button slot="action" slot-scope="record" type="link" @click="clickOption('edit', record)">编辑</a-button>
      <span slot="expandedRowRender" slot-scope="record" style="margin: 0">{{ record.taskContent }}</span>
    </a-table>

    <taskModal ref="taskModal" />
  </div>
</template>

<script>
import { columns } from './const'
import taskModal from './taskModal'
import { listTask } from '@/api/dailyTask'
import { listNurse } from '@/api/staffNurse.js'
import { listCaseInfo } from '@/api/patientCaseInfo.js'

export default {
  name: 'dailyTask',
  components: {
    taskModal
  },
  data () {
    return {
      taskData: [],
      searchData: {
        taskName: undefined,
        nurseId: undefined,
        patientId: undefined
      },
      taskList: [],
      nurseList: [],
      patientCaseData: [],
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
  mounted () {
    this.getData()
  },
  methods: {
    getData () {
      listTask().then(res => {
        this.taskList = res.data
        this.taskData = res.data
      })
      listNurse().then(res => {
        this.nurseList = res.data
      })
      listCaseInfo().then(res => {
        this.patientCaseData = res.data
      })
    },
    searchOk () {
      const _searchInfo = this.searchData
      listTask(_searchInfo).then(res => {
        this.taskData = res.data
      })
    },
    searchCancel () {
      this.$refs.searchForm.resetFields()
      this.getData()
    },
    clickOption (type, data) {
      switch (type) {
        case 'add':
          this.$refs.taskModal.paramReceive(type, data)
          break
        case 'edit':
          this.$refs.taskModal.paramReceive(type, data)
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
