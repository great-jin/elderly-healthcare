import moment from 'moment'

export const columns = (cxt) => {
  // eslint-disable-next-line no-unused-vars
  const h = cxt.$createElement
  return [
    {
      title: '编号',
      align: 'center',
      dataIndex: 'applyId',
      customRender: (record) => {
        const result = record.substring(0, 8)
        return <span>{result}</span>
      }
    },
    {
      title: '员工编号',
      align: 'center',
      dataIndex: 'staffId',
      customRender: (record) => {
        const result = record.substring(0, 8)
        return <span>{result}</span>
      }
    },
    {
      title: '部门',
      align: 'center',
      dataIndex: 'organizeName'
    },
    {
      title: '申请时间',
      align: 'center',
      dataIndex: 'applyTime',
      customRender: (record) => {
        const _time = record !== null ? moment(record).format('YYYY-MM-DD') : '无'
        return <span>{_time}</span>
      }
    },
    {
      title: '审批状态',
      align: 'center',
      dataIndex: 'isFinished',
      customRender: (record) => {
        if (record === 1) {
          return <a-tag color="green">已批准</a-tag>
        } else if (record === 2) {
          return <a-tag color="red">未通过</a-tag>
        } else {
          return <a-tag color="blue">待审批</a-tag>
        }
      }
    },
    {
      title: '收件人',
      align: 'center',
      dataIndex: 'receiveName'
    },
    {
      title: '收件电话',
      align: 'center',
      dataIndex: 'receivePhone'
    },
    {
      title: '收件地址',
      align: 'center',
      ellipsis: true,
      dataIndex: 'receiveAddress'
    },
    {
      title: '操作',
      width: 160,
      align: 'center',
      scopedSlots: {
        customRender: 'action'
      }
    }
  ]
}

export const detailColumns = [
  {
    title: '资产名',
    align: 'center',
    dataIndex: 'goodsName'
  },
  {
    title: '资产规格',
    align: 'center',
    dataIndex: 'goodsType'
  },
  {
    title: '资产单价',
    align: 'center',
    dataIndex: 'goodsPrice'
  },
  {
    title: '申请数量',
    align: 'center',
    dataIndex: 'applyCount'
  },
  {
    title: '总金额',
    align: 'center',
    dataIndex: 'costMoney'
  }
]
