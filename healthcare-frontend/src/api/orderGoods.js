import request from './axios'

const prefix = '/api/healthcare/orderGoods'

export function listOrderGoods () {
  return request({
    url: `${prefix}/list`,
    method: 'get'
  })
}

export function getOrderGoods (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addOrderGoods (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateOrderGoods (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeOrderGoods (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
