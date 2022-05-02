import moment from 'moment'

export const columns = (cxt) => {
  // eslint-disable-next-line no-unused-vars
  const h = cxt.$createElement
  return [
    {
      title: '编号',
      key: 'patientId',
      align: 'center',
      dataIndex: 'patientId',
      customRender: (record) => {
        return <span>{record.substr(0, 8)}</span>
      }
    },
    {
      title: '姓名',
      key: 'patientName',
      align: 'center',
      dataIndex: 'patientName'
    },
    {
      title: '年龄',
      key: 'patientAge',
      align: 'center',
      dataIndex: 'patientAge'
    },
    {
      title: '登记时间',
      key: 'inTime',
      align: 'center',
      dataIndex: 'inTime',
      customRender: (record) => {
        const _time = record !== null ? moment(record).format('YYYY-MM-DD') : '无'
        return <span>{_time}</span>
      }
    },
    {
      title: '备注',
      key: 'comment',
      align: 'center',
      dataIndex: 'comment',
      customRender: (record) => {
        if (record === null || record === '') {
          return <span>无</span>
        } else {
          return <span>{record}</span>
        }
      }
    },
    {
      title: '操作',
      key: 'x',
      align: 'center',
      scopedSlots: { customRender: 'action' }
    }
  ]
}
