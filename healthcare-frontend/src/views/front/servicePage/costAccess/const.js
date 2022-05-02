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

export const costColumns = (cxt) => {
  // eslint-disable-next-line no-unused-vars
  const h = cxt.$createElement
  return [
    {
      title: '编号',
      align: 'center',
      dataIndex: 'id',
      customRender: (record) => {
        return <span>{record.substr(0, 3)}</span>
      }
    },
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
}
