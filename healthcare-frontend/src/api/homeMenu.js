import request from './utils/axios'

const prefix = '/api/healthcare/homeMenu'

export function listHomeMenu (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getHomeMenu (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addHomeMenu (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateHomeMenu (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeHomeMenu (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
