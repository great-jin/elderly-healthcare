import moment from 'moment'

export const columns = (cxt) => {
  // eslint-disable-next-line no-unused-vars
  const h = cxt.$createElement
  return [
    {
      key: 'taskName',
      title: '任务名称',
      align: 'center',
      width: '15%',
      dataIndex: 'taskName'
    },
    {
      key: 'staffId',
      title: '负责人',
      align: 'center',
      width: '15%',
      dataIndex: 'staffId'
    },
    {
      key: 'patientId',
      title: '负责病人',
      align: 'center',
      width: '20%',
      dataIndex: 'patientId'
    },
    {
      key: 'createdTime',
      title: '创建时间',
      align: 'center',
      width: '20%',
      dataIndex: 'createdTime',
      customRender: (record) => {
        const _time = record !== null ? moment(record).format('YYYY-MM-DD') : '无'
        return <span>{_time}</span>
      }
    },
    {
      key: 'comment',
      title: '备注',
      align: 'center',
      dataIndex: 'comment',
      ellipsis: true,
      width: '15%',
      customCell: (record) => {
        return {
          attrs: {
            title: record
          }
        }
      }
    },
    {
      key: 'taskContent',
      title: '任务内容',
      align: 'center',
      dataIndex: 'taskContent',
      ellipsis: true
    },
    {
      title: '操作',
      key: 'action',
      width: '15%',
      align: 'center',
      scopedSlots: { customRender: 'action' }
    }
  ]
}

export const taskData = [
  {
    key: '1',
    taskId: '123',
    taskName: '123',
    staffId: '23',
    patientId: '12',
    createdTime: '34g',
    taskContent: '是法国的是法国是是法国的是法国是法国的是法国是法国的是法国是法国的是法国国的是法国ebffffffb',
    comment: 'fgfffxddd'
  }, {
    key: '2',
    taskId: '123',
    taskName: '123',
    staffId: '23',
    patientId: '12',
    createdTime: '34g',
    taskContent: '是法国的是法国是是法国的是法国是法国的是法国是法国的是法国是法国的是法国国的是法国ebffffffb',
    comment: 'fgfffxddd'
  }, {
    key: '3',
    taskId: '123',
    taskName: '123',
    staffId: '23',
    patientId: '12',
    createdTime: '34g',
    taskContent: '是法国的是法国是是法国的是法国是法国的是法国是法国的是法国是法国的是法国国的是法国ebffffffb',
    comment: 'fgfffxddd'
  }, {
    key: '4',
    taskId: '123',
    taskName: '123',
    staffId: '23',
    patientId: '12',
    createdTime: '34g',
    taskContent: '是法国的是法国是是法国的是法国是法国的是法国是法国的是法国是法国的是法国国的是法国ebffffffb',
    comment: 'fgfffxddd'
  }, {
    key: '5',
    taskId: '123',
    taskName: '123',
    staffId: '23',
    patientId: '12',
    createdTime: '34g',
    taskContent: '是法国的是法国是是法国的是法国是法国的是法国是法国的是法国是法国的是法国国的是法国ebffffffb',
    comment: 'fgfffxddd'
  }, {
    key: '6',
    taskId: '123',
    taskName: '123',
    staffId: '23',
    patientId: '12',
    createdTime: '34g',
    taskContent: '是法国的是法国是是法国的是法国是法国的是法国是法国的是法国是法国的是法国国的是法国ebffffffb',
    comment: 'fgfffxddd'
  }, {
    key: '7',
    taskId: '123',
    taskName: '123',
    staffId: '23',
    patientId: '12',
    createdTime: '34g',
    taskContent: '是法国的是法国是是法国的是法国是法国的是法国是法国的是法国是法国的是法国国的是法国ebffffffb',
    comment: 'fgfffxddd'
  }
]
