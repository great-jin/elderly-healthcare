export const columns = (cxt) => {
  // eslint-disable-next-line no-unused-vars
  const h = cxt.$createElement
  return [
    {
      title: '编号',
      width: 100,
      fixed: 'left',
      align: 'center',
      dataIndex: 'staffId'
    },
    {
      title: '姓名',
      width: 100,
      fixed: 'left',
      align: 'center',
      dataIndex: 'staffName'
    },
    {
      title: '部门',
      align: 'center',
      dataIndex: 'organizeId'
    },
    {
      title: '职位',
      align: 'center',
      dataIndex: 'staffPosition'
    },
    {
      title: '月份',
      align: 'center',
      dataIndex: 'workDate'
    },
    {
      title: '工作天数',
      align: 'center',
      dataIndex: 'workDays'
    },
    {
      title: '请假天数',
      align: 'center',
      dataIndex: 'offDays'
    },
    {
      title: '罚款金额',
      align: 'center',
      dataIndex: 'deductCount'
    },
    {
      title: '保险金额',
      align: 'center',
      dataIndex: 'insuranceCount'
    },
    {
      title: '补贴金额',
      align: 'center',
      dataIndex: 'allowanceCount'
    },
    {
      title: '总金额',
      align: 'center',
      dataIndex: 'salaryCount'
    },
    {
      title: '操作',
      fixed: 'right',
      width: 170,
      align: 'center',
      scopedSlots: { customRender: 'action' }
    }
  ]
}
