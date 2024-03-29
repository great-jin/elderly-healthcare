import request from './utils/axios'

const prefix = '/api/healthcare/sysLogs'

export function listSysLogs (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getSysLogs (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addSysLogs (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateSysLogs (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeSysLogs (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
