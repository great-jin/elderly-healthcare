import request from './utils/axios'

const prefix = '/api/healthcare/organizeInfo'

export function listOrg (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function get (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function add (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function update (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function remove (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
