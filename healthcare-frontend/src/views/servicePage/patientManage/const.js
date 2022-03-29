export const columns = [
  {
    title: '编号',
    dataIndex: 'id',
    width: 100,
    align: 'center',
    fixed: 'left',
    scopedSlots: { customRender: 'ID' }
  },
  {
    title: '账号',
    dataIndex: 'accountID',
    width: 100,
    align: 'center',
    fixed: 'left',
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
    width: 180,
    align: 'center',
    fixed: 'right',
    dataIndex: 'operation',
    scopedSlots: { customRender: 'operation' }
  }
]
