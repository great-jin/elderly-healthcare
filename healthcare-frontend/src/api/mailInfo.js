import request from './utils/axios'

const prefix = '/api/healthcare/mailInfo'

export function listMailInfo (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getMailInfo (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addMailInfo (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateMailInfo (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeMailInfo (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
