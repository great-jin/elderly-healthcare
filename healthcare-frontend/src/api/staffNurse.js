import request from './utils/axios'

const prefix = '/api/healthcare/staffNurse'

export function listStaffNurse (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getStaffNurse (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addStaffNurse (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateStaffNurse (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeStaffNurse (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
