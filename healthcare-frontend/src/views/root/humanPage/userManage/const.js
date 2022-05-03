import moment from 'moment'

export const columns = (cxt) => {
  // eslint-disable-next-line no-unused-vars
  const h = cxt.$createElement
  return [
    {
      title: '姓名',
      width: 100,
      fixed: 'left',
      align: 'center',
      dataIndex: 'staffName'
    },
    {
      title: '员工编号',
      width: 100,
      fixed: 'left',
      align: 'center',
      dataIndex: 'staffId'
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
      title: '性别',
      align: 'center',
      dataIndex: 'staffGender'
    },
    {
      title: '年龄',
      align: 'center',
      dataIndex: 'staffAge'
    },
    {
      title: '电话',
      width: 150,
      align: 'center',
      ellipsis: true,
      dataIndex: 'staffPhone'
    },
    {
      title: '邮箱',
      align: 'center',
      ellipsis: true,
      dataIndex: 'staffEmail'
    },
    {
      title: '入职时间',
      width: 150,
      align: 'center',
      dataIndex: 'entryTime',
      customRender: (record) => {
        const _time = record !== null ? moment(record).format('YYYY-MM-DD') : '无'
        return <span>{_time}</span>
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
      title: '是否离职',
      align: 'center',
      dataIndex: 'isResigned',
      customRender: (record) => {
        if (record === 1) {
          return <a-tag color="blue">是</a-tag>
        } else {
          return <a-tag color="red">否</a-tag>
        }
      }
    },
    {
      title: '离职时间',
      width: 150,
      align: 'center',
      dataIndex: 'resignTime',
      customRender: (record) => {
        const _time = record !== null ? moment(record).format('YYYY-MM-DD') : '无'
        return <span>{_time}</span>
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
      title: '家庭住址',
      width: 200,
      align: 'center',
      ellipsis: true,
      dataIndex: 'staffAddress'
    },
    {
      title: '操作',
      fixed: 'right',
      width: 165,
      align: 'center',
      scopedSlots: { customRender: 'action' }
    }
  ]
}
