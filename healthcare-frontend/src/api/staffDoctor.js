import request from './utils/axios'

const prefix = '/api/healthcare/staffDoctor'

export function listDoctor (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getDoctor (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addDoctor (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateDoctor (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeDoctor (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
