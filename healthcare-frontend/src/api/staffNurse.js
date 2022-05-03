import request from './utils/axios'

const prefix = '/api/healthcare/staffNurse'

export function listNurse (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getNurse (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function getCount (params) {
  return request({
    url: `${prefix}/getCount`,
    method: 'get'
  })
}

export function addNurse (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateNurse (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeNurse (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
