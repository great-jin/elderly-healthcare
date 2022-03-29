export const columns = [
  {
    key: 'taskName',
    title: '任务名称',
    align: 'center',
    dataIndex: 'taskName'
  },
  {
    key: 'staffId',
    title: '负责人',
    align: 'center',
    dataIndex: 'staffId'
  },
  {
    key: 'patientId',
    title: '负责病人',
    align: 'center',
    dataIndex: 'patientId'
  },
  {
    key: 'createdTime',
    title: '创建时间',
    align: 'center',
    dataIndex: 'createdTime'
    /*,
    customRender: (text, record) => {
      const time = record.createdTime ? format(record.createdTime, 'YYYY-MM-DD HH:mm:ss') : '无'
      return <span>{time}</span>
    } */
  },
  {
    key: 'taskContent',
    title: '任务内容',
    align: 'center',
    dataIndex: 'taskContent',
    colSpan: 0,
    customRender: () => {
      return { attrs: { colSpan: 0 } }
    }
  },
  {
    key: 'comment',
    title: '备注',
    align: 'center',
    dataIndex: 'comment',
    scopedSlots: { customRender: 'comment' }
  },
  {
    title: '操作',
    key: 'action',
    align: 'center',
    scopedSlots: { customRender: 'action' }
  }
]

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
