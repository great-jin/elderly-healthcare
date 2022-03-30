export const columns = [
  {
    title: '编号',
    dataIndex: 'caseId',
    ellipsis: true,
    align: 'center',
    fixed: 'left',
    scopedSlots: { customRender: 'caseId' }
  },
  {
    title: '病人编号',
    dataIndex: 'patientId',
    ellipsis: true,
    align: 'center',
    fixed: 'left',
    scopedSlots: { customRender: 'patientId' }
  },
  {
    title: '姓名',
    dataIndex: 'patientName',
    align: 'center',
    fixed: 'left',
    scopedSlots: { customRender: 'patientName' }
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
    scopedSlots: { customRender: 'inTime' }
  },
  {
    title: '是否出院',
    dataIndex: 'isLeave',
    align: 'center',
    scopedSlots: { customRender: 'isLeave' }
  },
  {
    title: '出院时间',
    dataIndex: 'outTime',
    align: 'center',
    scopedSlots: { customRender: 'outTime' }
  },
  {
    title: '操作',
    align: 'center',
    fixed: 'right',
    dataIndex: 'operation',
    scopedSlots: { customRender: 'operation' }
  }
]
