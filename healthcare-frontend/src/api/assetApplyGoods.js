import request from './axios'

const prefix = '/api/healthcare/assetApplyGoods'

export function listApplyGoods () {
  return request({
    url: `${prefix}/list`,
    method: 'get'
  })
}

export function getApplyGoods (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function getStaffApplyGoods (params) {
  return request({
    url: `${prefix}/getByID?id=${params}`,
    method: 'get'
  })
}

export function addApplyGoods (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateApplyGoods (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeApplyGoods (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
