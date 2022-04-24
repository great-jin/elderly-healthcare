import moment from 'moment'

export const columns = (cxt) => {
  // eslint-disable-next-line no-unused-vars
  const h = cxt.$createElement
  return [
    {
      title: '编号',
      align: 'center',
      fixed: 'left',
      dataIndex: 'goodsId',
      customRender: (record) => {
        return <span>{record.substring(0, 8)}</span>
      }
    },
    {
      title: '产品名',
      fixed: 'left',
      width: 120,
      align: 'center',
      dataIndex: 'goodsName'
    },
    {
      title: '产品类别',
      align: 'center',
      dataIndex: 'goodsType'
    },
    {
      title: '单价',
      align: 'center',
      dataIndex: 'goodsPrice'
    },
    {
      title: '库存',
      align: 'center',
      dataIndex: 'goodsCount'
    },
    {
      title: '预警线',
      align: 'center',
      dataIndex: 'warnLine'
    },
    {
      title: '购买人',
      align: 'center',
      dataIndex: 'purchaseStaff'
    },
    {
      title: '购买日期',
      align: 'center',
      dataIndex: 'purchaseTime',
      customRender: (record) => {
        const _time = record !== null ? moment(record).format('YYYY-MM-DD') : '无'
        return <span>{_time}</span>
      }
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
      title: '生产厂商',
      align: 'center',
      dataIndex: 'produceVendor',
      customRender: (record) => {
        if (record !== null) {
          return <span>{record.substring(0, 10)}</span>
        }
      },
      customCell: (record) => {
        return {
          attrs: {
            title: record.produceVendor
          }
        }
      }
    },
    {
      title: '操作',
      width: 170,
      fixed: 'right',
      align: 'center',
      scopedSlots: { customRender: 'action' }
    }
  ]
}
