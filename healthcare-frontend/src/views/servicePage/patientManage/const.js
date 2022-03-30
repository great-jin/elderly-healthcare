import moment from 'moment'

export const columns = cxt => {
  // eslint-disable-next-line no-unused-vars
  const h = cxt.$createElement
  return [
    {
      title: '编号',
      dataIndex: 'caseId',
      ellipsis: true,
      align: 'center',
      fixed: 'left',
      width: 100,
      scopedSlots: { customRender: 'caseId' }
    },
    {
      title: '姓名',
      dataIndex: 'patientName',
      align: 'center',
      fixed: 'left',
      width: 100,
      scopedSlots: { customRender: 'patientName' }
    },
    {
      title: '病人编号',
      dataIndex: 'patientId',
      ellipsis: true,
      align: 'center',
      scopedSlots: { customRender: 'patientId' }
    },
    {
      title: '主治医师',
      dataIndex: 'chargeDoctor',
      align: 'center',
      scopedSlots: { customRender: 'chargeDoctor' }
    },
    {
      title: '护理员',
      dataIndex: 'chargeNurse',
      align: 'center',
      scopedSlots: { customRender: 'chargeNurse' }
    },
    {
      title: '入住时间',
      dataIndex: 'inTime',
      align: 'center',
      ellipsis: true,
      customRender: (record) => {
        const _time = record !== null ? moment(record).format('YYYY-MM-DD HH:mm:ss') : '无'
        return <span>{_time}</span>
      },
      customCell: (record) => {
        const _time = record !== null ? moment(record).format('YYYY-MM-DD HH:mm:ss') : '无'
        return {
          attrs: {
            title: _time
          }
        }
      }
    },
    {
      title: '是否出院',
      dataIndex: 'isLeave',
      align: 'center',
      customRender: (record) => {
        if (record === 1) {
          return <a-tag color="blue">是</a-tag>
        } else {
          return <a-tag color="blue">否</a-tag>
        }
      }
    },
    {
      title: '出院时间',
      dataIndex: 'outTime',
      align: 'center',
      ellipsis: true,
      customRender: (record) => {
        const _time = record !== null ? moment(record).format('YYYY-MM-DD HH:mm:ss') : '无'
        return <span>{_time}</span>
      },
      customCell: (record) => {
        const _time = record !== null ? moment(record).format('YYYY-MM-DD HH:mm:ss') : '无'
        return {
          attrs: {
            title: _time
          }
        }
      }
    },
    {
      title: '操作',
      align: 'center',
      fixed: 'right',
      width: 200,
      scopedSlots: { customRender: 'action' }
    }
  ]
}
