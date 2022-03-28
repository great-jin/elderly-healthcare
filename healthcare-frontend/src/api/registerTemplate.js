import request from './utils/axios'

const prefix = '/api/healthcare/registerTemplate'

export function listRegisterTemplate () {
  return request({
    url: `${prefix}/list`,
    method: 'get'
  })
}

export function getRegisterTemplate (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addRegisterTemplate (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateRegisterTemplate (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeRegisterTemplate (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
