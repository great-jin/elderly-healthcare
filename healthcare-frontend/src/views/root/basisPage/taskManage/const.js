import moment from 'moment'

export const columns = (cxt) => {
  // eslint-disable-next-line no-unused-vars
  const h = cxt.$createElement
  return [
    {
      key: 'taskId',
      title: '编号',
      width: '10%',
      align: 'center',
      dataIndex: 'taskId',
      customRender: (record) => {
        return <span>{record.substr(0, 8)}</span>
      }
    },
    {
      key: 'taskName',
      title: '任务名称',
      width: '10%',
      align: 'center',
      dataIndex: 'taskName'
    },
    {
      key: 'patientName',
      title: '病人',
      width: '15%',
      align: 'center',
      dataIndex: 'patientName'
    },
    {
      key: 'nurseName',
      title: '负责人',
      width: '15%',
      align: 'center',
      dataIndex: 'nurseName'
    },
    {
      key: 'createdTime',
      title: '创建时间',
      align: 'center',
      width: '15%',
      dataIndex: 'createdTime',
      customRender: (record) => {
        const _time = record !== null ? moment(record).format('YYYY-MM-DD') : '无'
        return <span>{_time}</span>
      }
    },
    {
      key: 'isFinished',
      title: '是否完成',
      width: '10%',
      align: 'center',
      dataIndex: 'isFinished',
      customRender: (record) => {
        if (record === 1) {
          return <a-tag color="blue">是</a-tag>
        } else {
          return <a-tag color="red">否</a-tag>
        }
      }
    },
    {
      key: 'comment',
      title: '备注',
      align: 'center',
      width: '15%',
      ellipsis: true,
      dataIndex: 'comment',
      customRender: (record) => {
        if (record === null || record === '') {
          return <span>无</span>
        } else {
          return <span>{record}</span>
        }
      },
      customCell: (record) => {
        return {
          attrs: {
            title: record.name
          }
        }
      }
    },
    {
      key: 'taskContent',
      title: '任务内容',
      align: 'center',
      ellipsis: true,
      dataIndex: 'taskContent'
    },
    {
      title: '操作',
      key: 'action',
      width: '10%',
      align: 'center',
      scopedSlots: { customRender: 'action' }
    }
  ]
}
