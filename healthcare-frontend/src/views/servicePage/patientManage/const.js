export const columns = [
  {
    title: '编号',
    dataIndex: 'id',
    width: '15%',
    align: 'center',
    scopedSlots: { customRender: 'ID' }
  },
  {
    title: '账号',
    dataIndex: 'accountID',
    width: '20%',
    align: 'center',
    scopedSlots: { customRender: 'accountID' }
  },
  {
    title: '用户名',
    dataIndex: 'userName',
    width: '25%',
    ellipsis: true,
    align: 'center',
    scopedSlots: { customRender: 'userName' }
  },
  {
    title: '密码',
    dataIndex: 'password',
    width: '25%',
    ellipsis: true,
    align: 'center',
    scopedSlots: { customRender: 'password' }
  },
  {
    title: '操作',
    width: '20%',
    align: 'center',
    dataIndex: 'operation',
    scopedSlots: { customRender: 'operation' }
  }
]
