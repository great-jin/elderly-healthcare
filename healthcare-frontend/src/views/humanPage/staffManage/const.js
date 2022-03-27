export const columns = [
  { title: 'Full Name', width: 100, dataIndex: 'name', key: 'name', fixed: 'left' },
  { title: 'Age', width: 100, dataIndex: 'age', key: 'age', fixed: 'left' },
  { title: 'Column 1', dataIndex: 'address', key: '1' },
  { title: 'Column 2', dataIndex: 'address', key: '2' },
  { title: 'Column 3', dataIndex: 'address', key: '3' },
  { title: 'Column 4', dataIndex: 'address', key: '4' },
  { title: 'Column 5', dataIndex: 'address', key: '5' },
  { title: 'Column 6', dataIndex: 'address', key: '6' },
  { title: 'Column 7', dataIndex: 'address', key: '7' },
  { title: 'Column 8', dataIndex: 'address', key: '8' },
  {
    title: 'Action',
    key: 'operation',
    fixed: 'right',
    width: 100,
    scopedSlots: { customRender: 'action' }
  }
]

export const staffData = [
  {
    key: '1',
    name: 'John Brown',
    age: 32,
    address: 'New York Park'
  },
  {
    key: '2',
    name: 'Jim Green',
    age: 40,
    address: 'London Park'
  },
  {
    key: '3',
    name: 'Jim Green',
    age: 40,
    address: 'London Park'
  },
  {
    key: '4',
    name: 'Jim Green',
    age: 40,
    address: 'London Park'
  },
  {
    key: '5',
    name: 'Jim Green',
    age: 40,
    address: 'London Park'
  },
  {
    key: '6',
    name: 'Jim Green',
    age: 40,
    address: 'London Park'
  },
  {
    key: '7',
    name: 'Jim Green',
    age: 40,
    address: 'London Park'
  },
  {
    key: '8',
    name: 'Jim Green',
    age: 40,
    address: 'London Park'
  },
  {
    key: '9',
    name: 'Jim Green',
    age: 40,
    address: 'London Park'
  },
  {
    key: '10',
    name: 'Jim Green',
    age: 40,
    address: 'London Park'
  },
  {
    key: '11',
    name: 'Jim Green',
    age: 40,
    address: 'London Park'
  },
  {
    key: '12',
    name: 'Jim Green',
    age: 40,
    address: 'London Park'
  }
]
