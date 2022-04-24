export const columns = [
  {
    title: '员工编号',
    dataIndex: 'staffId',
    fixed: 'left',
    align: 'center'
  },
  {
    title: '姓名',
    dataIndex: 'staffName',
    fixed: 'left',
    align: 'center'
  },
  {
    title: '性别',
    dataIndex: 'staffGender',
    align: 'center'
  },
  {
    title: '年龄',
    dataIndex: 'staffAge',
    align: 'center'
  },
  {
    title: '电话',
    dataIndex: 'staffPhone',
    align: 'center',
    ellipsis: true
  },
  {
    title: '邮箱',
    dataIndex: 'staffEmail',
    align: 'center',
    ellipsis: true
  },
  {
    title: '住址',
    dataIndex: 'staffAddress',
    align: 'center',
    ellipsis: true
  },
  {
    title: '部门编号',
    dataIndex: 'organizeId',
    align: 'center'
  },
  {
    title: '职位',
    dataIndex: 'staffPosition',
    align: 'center'
  },
  {
    title: '入职时间',
    dataIndex: 'entryTime',
    align: 'center'
  },
  {
    title: '是否离职',
    dataIndex: 'isResigned',
    align: 'center'
  },
  {
    title: '离职时间',
    dataIndex: 'resignTime',
    align: 'center'
  },
  {
    title: '操作',
    width: 170,
    fixed: 'right',
    align: 'center',
    scopedSlots: { customRender: 'action' }
  }
]
