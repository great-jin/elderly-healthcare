<template>
  <div>
    <a-tabs type="card">
      <a-tab-pane key="1" tab="登记信息">
        <a-row style="margin: 0 0 30px 10px; ">
          <a-col :span="6">
            <b>账号：</b>
            <a-auto-complete
              placeholder="输入查询账号"
              :allowClear="true"
              class="task-search"
            />
          </a-col>
          <a-col :span="6">
            <b>任务名：</b>
            <a-select :allowClear="true" placeholder="请选择负责人" class="task-search">
              <a-select-option
                v-for="staff in staffList"
                :key="staff.staffId"
                :value="staff.staffId"
              >{{ staff.staffName }}</a-select-option>
            </a-select>
          </a-col>
          <a-col :span="6">
            <b>负责人：</b>
            <a-select :allowClear="true" placeholder="请选择负责人" class="task-search">
              <a-select-option
                v-for="staff in staffList"
                :key="staff.staffId"
                :value="staff.staffId"
              >{{ staff.staffName }}</a-select-option>
            </a-select>
          </a-col>
          <a-col :span="6">
            <a-button @click="searchCancel" class="task-search-button">重置</a-button>
            <a-button @click="searchOk" type="primary" class="task-search-button" style="margin-right: 7px">查询</a-button>
          </a-col>
        </a-row>

        <a-table
          :columns="columns"
          :data-source="accessData"
        >
          <template slot="action" slot-scope="record">
            <a-button type="link" @click="openDrawer('detail', record)">详情</a-button>
            <a-button type="link" @click="openDrawer('edit', record)">编辑</a-button>
            <patientDrawer ref="patientDrawer" />
          </template>
        </a-table>
      </a-tab-pane>
      <a-tab-pane key="2" tab="入住登记">
        <accessForm />
      </a-tab-pane>
    </a-tabs>
  </div>
</template>

<script>
import accessForm from './accessForm'
import patientDrawer from './patientDrawer'
import { columns, accessData } from './const'

export default {
  name: 'index',
  components: {
    accessForm,
    patientDrawer
  },
  data () {
    return {
      columns,
      accessData,
      staffList: [
        {
          staffId: '123',
          staffName: 'AA'
        }
      ]
    }
  },
  methods: {
    openDrawer (type, record) {
      this.$refs.patientDrawer.paramReceive(type, record)
    },
    searchOk () {

    },
    searchCancel () {

    }
  }
}
</script>

<style scoped>
  .task-search{
    width: 65%;
    margin-right: 5px;
  }
  .task-search-button{
    float: right;
    z-index: 1;
  }
</style>
