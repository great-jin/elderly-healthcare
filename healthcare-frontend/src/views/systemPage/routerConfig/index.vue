<template>
  <div>
    <a-card title="路由配置">
      <a-radio-group
        style="margin-bottom: 10px"
      >
        <a-radio-button
          v-for="(option, index) in titleData"
          :key="index"
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
          <template slot="action" slot-scope="record">
            <a-button type="link" @click="clickOption('more', record)">详情</a-button>
            <a-button type="link" @click="clickOption('edit', record)">编辑</a-button>
          </template>
        </a-table>
      </a-config-provider>
      <routerModal ref="routerModal" />
    </a-card>
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
          title: '导航'
        }, {
          key: 'setting',
          title: '设置'
        }, {
          key: 'service',
          title: '服务'
        }, {
          key: 'human',
          title: '人事'
        }, {
          key: 'asset',
          title: '资产'
        }, {
          key: 'store',
          title: '后勤'
        }, {
          key: 'system',
          title: '系统'
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
    this.titleOption('top')
  },
  methods: {
    getData () {
      listHomeMenu().then(res => {
        this.data = res.data
        this.routerData = res.data
      })
    },
    titleOption (data) {
      console.log(data)
      this.data = this.routerData.filter(item => item.menuType === data)
    },
    clickOption (type, data) {
      this.$refs.routerModal.paramReceive(type, data)
    }
  }
}
</script>
