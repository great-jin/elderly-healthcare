import request from './utils/axios'

const prefix = '/api/healthcare/staffDoctor'

export function listStaffDoctor () {
  return request({
    url: `${prefix}/list`,
    method: 'get'
  })
}

export function getStaffDoctor (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addStaffDoctor (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateStaffDoctor (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeStaffDoctor (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
