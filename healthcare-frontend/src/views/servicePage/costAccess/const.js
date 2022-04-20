export const columns = [
  {
    title: '产品名',
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
  }
]

export const payColumns = [
  {
    title: '产品名',
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
    title: '数量',
    align: 'center',
    dataIndex: 'goodsNumber'
  },
  {
    title: '总价',
    align: 'center',
    dataIndex: 'costCount'
  },
  {
    title: '操作',
    align: 'center',
    scopedSlots: { customRender: 'action' }
  }
]
