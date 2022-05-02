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
            prop="patientName"
            :label-col="labelCol"
            :wrapper-col="wrapperCol"
          >
            <a-select
              v-model="searchData.patientName"
              :allowClear="true"
              placeholder="请选择病人"
              style="padding: 0 5px"
            >
              <a-select-option
                v-for="option in (taskData.map(item => item.patientName)).filter(function (element, index, array) { return array.indexOf(element) === index })"
                :key="option"
                :value="option"
              >{{ option }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="5">
          <a-form-model-item
            label="负责人"
            prop="nurseName"
            :label-col="labelCol"
            :wrapper-col="wrapperCol"
          >
            <a-select
              v-model="searchData.nurseName"
              :allowClear="true"
              placeholder="请选择负责人"
              style="padding: 0 5px"
            >
              <a-select-option
                v-for="option in (taskData.map(item => item.nurseName)).filter(function (element, index, array) { return array.indexOf(element) === index })"
                :key="option"
                :value="option"
              >{{ option }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="5">
          <a-form-model-item
            label="是否完成"
            :label-col="labelCol"
            :wrapper-col="wrapperCol"
          >
            <a-select
              v-model="searchData.isFinished"
              :allowClear="true"
              placeholder="是否完成"
              style="padding: 0 5px"
            >
              <a-select-option key="0" :value="0">否</a-select-option>
              <a-select-option key="1" :value="1">是</a-select-option>
            </a-select>
          </a-form-model-item>
        </a-col>
        <a-col :span="9">
          <a-button @click="searchCancel" class="task-search-button">重置</a-button>
          <a-button
            @click="searchOk"
            type="primary"
            class="task-search-button"
            :style="{marginRight: '15px'}"
          >查询
          </a-button>
        </a-col>
      </a-row>
    </a-form-model>

    <a-button
      type="primary"
      @click="clickOption('add', null)"
      style="margin-bottom: 20px"
    >新建任务
    </a-button>
    <a-table
      :columns="columns"
      :data-source="taskData"
      :pagination="pagination"
    >
      <a-button
        slot="action"
        slot-scope="record"
        type="link"
        @click="clickOption('edit', record)"
      >编辑
      </a-button>
      <span slot="expandedRowRender" slot-scope="record">
          <b>任务内容：</b>{{ record.taskContent }}
        </span>
    </a-table>
    <taskModal ref="taskModal"/>
  </div>
</template>

<script>
import { columns } from './const'
import taskModal from './taskModal'
import { listTask } from '@/api/dailyTask'

export default {
  name: 'DailyTask',
  components: {
    taskModal
  },
  data () {
    return {
      taskData: [],
      searchData: {
        nurseName: undefined,
        patientName: undefined,
        isFinished: undefined
      },
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
        sm: { span: 6 }
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 16 }
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
        this.taskData = res.data
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
.task-search-button {
  width: 100px;
  float: right;
  z-index: 1;
}
</style>
