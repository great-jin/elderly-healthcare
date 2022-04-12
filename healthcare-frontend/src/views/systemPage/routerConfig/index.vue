<template>
  <div :style="{padding: '15px'}">
      <a-radio-group
        default-value="top"
        style="margin-bottom: 20px"
      >
        <a-radio-button
          v-for="(option, index) in titleData"
          :key="index"
          :value="option.key"
          @click="titleOption(option.key)"
        >{{option.title}}
        </a-radio-button>
      </a-radio-group>
      <a-config-provider :locale="zhCN">
        <a-table
          :columns="columns"
          :data-source="data"
          :pagination="pagination"
        >
          <template slot="icon" slot-scope="menuIcon">
            <span v-if="menuIcon === null || menuIcon === ''">无</span>
            <a-tag v-else color="green">
              <a-icon :type="menuIcon" />
            </a-tag>
          </template>
          <template slot="action" slot-scope="record">
            <a-button type="link" @click="clickOption('more', record)">详情</a-button>
            <a-button type="link" @click="clickOption('edit', record)">编辑</a-button>
          </template>
        </a-table>
      </a-config-provider>
      <routerModal ref="routerModal" />
  </div>
</template>

<script>
import routerModal from './routerModal'
import { columns } from './const'
import { listHomeMenu } from '@/api/homeMenu'
import zhCN from 'ant-design-vue/lib/locale-provider/zh_CN'

export default {
  name: 'RouterManage',
  components: {
    routerModal
  },
  data () {
    return {
      zhCN,
      data: [],
      routerData: [],
      titleData: [
        {
          key: 'top',
          title: '导航模块'
        }, {
          key: 'setting',
          title: '设置模块'
        }, {
          key: 'service',
          title: '公共服务'
        }, {
          key: 'human',
          title: '人事模块'
        }, {
          key: 'asset',
          title: '资产模块'
        }, {
          key: 'store',
          title: '后勤模块'
        }, {
          key: 'system',
          title: '系统模块'
        }
      ],
      pagination: {
        total: 0,
        defaultPageSize: 5,
        showSizeChanger: true,
        pageSizeOptions: ['5', '10', '20', '30'],
        showTotal: total => `共 ${total} 条数据`,
        onShowSizeChange: (current, pageSize) => this.pageSize = pageSize
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
      listHomeMenu().then(res => {
        this.routerData = res.data
        this.data = this.routerData.filter(item => item.menuType === 'top')
      })
    },
    titleOption (data) {
      this.data = this.routerData.filter(item => item.menuType === data)
    },
    clickOption (type, data) {
      this.$refs.routerModal.paramReceive(type, data)
    }
  }
}
</script>
