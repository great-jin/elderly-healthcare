import moment from 'moment'

export const columns = (cxt) => {
  // eslint-disable-next-line no-unused-vars
  const h = cxt.$createElement
  return [
    {
      title: '编号',
      width: 100,
      fixed: 'left',
      align: 'center',
      dataIndex: 'drugId',
      customRender: (record) => {
        return <span>{record.substr(0, 8)}</span>
      }
    },
    {
      title: '药品名',
      width: 100,
      fixed: 'left',
      align: 'center',
      dataIndex: 'drugName'
    },
    {
      title: '药品类别',
      align: 'center',
      dataIndex: 'drugType'
    },
    {
      title: '单价',
      align: 'center',
      dataIndex: 'drugPrice'
    },
    {
      title: '库存数量',
      align: 'center',
      dataIndex: 'goodsCount'
    },
    {
      title: '生产日期',
      align: 'center',
      dataIndex: 'produceTime',
      customRender: (record) => {
        const _time = record !== null ? moment(record).format('YYYY-MM-DD') : '无'
        return <span>{_time}</span>
      }
    },
    {
      title: '是否过期',
      align: 'center',
      dataIndex: 'isOverdue',
      customRender: (record) => {
        if (record === 1) {
          return <a-tag color="blue">是</a-tag>
        } else {
          return <a-tag color="red">否</a-tag>
        }
      }
    },
    {
      title: '过期时间',
      align: 'center',
      dataIndex: 'overdueTime',
      customRender: (record) => {
        const _time = record !== null ? moment(record).format('YYYY-MM-DD') : '无'
        return <span>{_time}</span>
      }
    },
    {
      title: '生产厂商',
      align: 'center',
      dataIndex: 'produceVendor'
    },
    {
      title: '操作',
      width: 200,
      align: 'center',
      fixed: 'right',
      scopedSlots: { customRender: 'action' }
    }
  ]
}
