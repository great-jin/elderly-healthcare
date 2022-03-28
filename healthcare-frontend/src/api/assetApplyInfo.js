import request from './axios'

const prefix = '/api/healthcare/assetApplyInfo'

export function listApplyInfo () {
  return request({
    url: `${prefix}/list`,
    method: 'get'
  })
}

export function getApplyInfo (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addApplyInfo (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateApplyInfo (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeApplyInfo (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
