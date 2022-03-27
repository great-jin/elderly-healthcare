export const columns = [
  {
    key: 'name',
    width: '20%',
    dataIndex: 'name',
    slots: { title: 'customTitle' },
    scopedSlots: { customRender: 'name' }
  },
  {
    key: 'age',
    width: '15%',
    title: 'Age',
    dataIndex: 'age'
  },
  {
    key: 'address',
    width: '20%',
    title: 'Address',
    dataIndex: 'address'
  },
  {
    key: 'tags',
    width: '15%',
    title: 'Tags',
    dataIndex: 'tags',
    scopedSlots: { customRender: 'tags' }
  },
  {
    key: 'action',
    width: '30%',
    title: 'Action',
    align: 'center',
    scopedSlots: { customRender: 'action' }
  }
]

export const taskData = [
  {
    key: '1',
    name: 'John Brown',
    age: 32,
    address: 'New York No. 1 Lake Park',
    tags: ['nice', 'developer']
  },
  {
    key: '2',
    name: 'Jim Green',
    age: 42,
    address: 'London No. 1 Lake Park',
    tags: ['loser']
  },
  {
    key: '3',
    name: 'Joe Black',
    age: 32,
    address: 'Sidney No. 1 Lake Park',
    tags: ['cool', 'teacher']
  }
]
