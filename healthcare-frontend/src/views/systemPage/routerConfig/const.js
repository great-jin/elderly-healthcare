export const columns = (cxt) => {
  // eslint-disable-next-line no-unused-vars
  const h = cxt.$createElement
  return [
    {
      title: '类型',
      align: 'center',
      dataIndex: 'menuType'
    },
    {
      title: '图标',
      align: 'center',
      dataIndex: 'menuIcon',
      scopedSlots: { customRender: 'icon' }
    },
    {
      title: '标题',
      align: 'center',
      dataIndex: 'menuTitle'
    },
    {
      title: '路由地址',
      align: 'center',
      dataIndex: 'routerName',
      ellipsis: true,
      customCell: (record) => {
        return {
          attrs: {
            title: record.name
          }
        }
      }
    },
    {
      title: '是否展示',
      align: 'center',
      dataIndex: 'isShow',
      customRender: (record) => {
        if (record === 1) {
          return <a-tag color="blue">是</a-tag>
        } else {
          return <a-tag color="blue">否</a-tag>
        }
      }
    },
    {
      title: '操作',
      align: 'center',
      scopedSlots: { customRender: 'action' }
    }
  ]
}
