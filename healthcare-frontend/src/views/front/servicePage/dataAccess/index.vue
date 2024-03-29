<template>
  <div>
    <a-tabs type="card" @change="callback">
      <a-tab-pane key="1" tab="登记信息">
        <a-form-model
          ref="searchForm"
          :model="searchData"
          labelAlign="left"
          style="font-weight: bold"
        >
          <a-row style="padding-left: 10px">
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
                    v-for="cases in accessData"
                    :key="cases.patientId"
                    :value="cases.patientId"
                  >{{ cases.patientName }}
                  </a-select-option>
                </a-select>
              </a-form-model-item>
            </a-col>
            <a-col :span="10"/>
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
        <a-table
          :columns="columns"
          :data-source="accessData"
          :pagination="pagination"
          :style="{padding: '0 15px'}"
        >
          <template slot="action" slot-scope="record">
            <a-button type="link" @click="clickOption('more', record)">详情</a-button>
            <a-button type="link" @click="clickOption('edit', record)">更新</a-button>
          </template>
        </a-table>
        <patientDrawer ref="patientDrawer"/>
      </a-tab-pane>
      <a-tab-pane key="2" tab="入住登记">
        <accessForm />
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
import { columns } from './const'
import accessForm from './accessForm'
import patientDrawer from './patientDrawer'
import { listPatientInfo } from '@/api/patientInfo'

export default {
  name: 'dataAccess',
  components: {
    accessForm,
    patientDrawer
  },
  data () {
    return {
      searchData: {
        patientId: undefined
      },
      accessData: [],
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
    callback (key) {
      // 页面缓存刷新
      if (key === '1') {
        this.getData()
      }
    },
    getData () {
      listPatientInfo().then(res => {
        this.accessData = res.data
      })
    },
    clickOption (type, data) {
      this.$refs.patientDrawer.paramReceive(type, data)
    },
    searchOk () {
      const _searchInfo = this.searchData
      listPatientInfo(_searchInfo).then(res => {
        this.accessData = res.data
      })
    },
    searchCancel () {
      this.$refs.searchForm.resetFields()
      this.getData()
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
