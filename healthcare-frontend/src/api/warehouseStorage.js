import request from './utils/axios'

const prefix = '/api/healthcare/warehouseStorage'

export function listGoods (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getStorage (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addStorage (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateStorage (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeStorage (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
