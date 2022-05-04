import request from './utils/axios'

const prefix = '/api/healthcare/employeeSalary'

export function listEmployeeSalary (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getEmployeeSalary (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addEmployeeSalary (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateEmployeeSalary (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeEmployeeSalary (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}

export function download (params) {
  return request({
    url: `${prefix}/download`,
    method: 'post',
    data: params,
    responseType: 'blob'
  }).then((res) => {
    // 获取文件名
    let fileName = res.headers['content-disposition']
    fileName = decodeURI(fileName)
    fileName = fileName.substring(fileName.lastIndexOf('='))
    fileName = fileName.slice(1)

    const content = res.data
    const blob = new Blob([content])
    if ('download' in document.createElement('a')) {
      // 非IE下载
      const elink = document.createElement('a')
      elink.download = fileName
      elink.style.display = 'none'
      elink.href = URL.createObjectURL(blob)
      document.body.appendChild(elink)
      elink.click()
      URL.revokeObjectURL(elink.href) // 释放URL 对象
      document.body.removeChild(elink)
    } else {
      // IE10+下载
      navigator.msSaveBlob(blob, fileName)
    }
  }).catch(error => {
    console.log(error)
  })
}
