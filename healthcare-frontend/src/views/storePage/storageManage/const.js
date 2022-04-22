import moment from 'moment'

export const columns = (cxt) => {
  // eslint-disable-next-line no-unused-vars
  const h = cxt.$createElement
  return [
    {
      title: '编号',
      align: 'center',
      dataIndex: 'patientId',
      customRender: (record) => {
        return <span>{record.substr(0, 8)}</span>
      }
    },
    {
      title: '备注',
      align: 'center',
      dataIndex: 'comment',
      customRender: (record) => {
        if (record === null || record === '') {
          return <span>无</span>
        } else {
          return <span>{record}</span>
        }
      }
    }
  ]
}
