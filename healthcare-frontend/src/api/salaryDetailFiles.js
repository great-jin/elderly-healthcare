import request from './utils/axios'

const prefix = '/api/healthcare/salaryDetailFiles'

export function listSalaryDetailFiles (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getSalaryDetailFiles (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addSalaryDetailFiles (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateSalaryDetailFiles (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeSalaryDetailFiles (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
