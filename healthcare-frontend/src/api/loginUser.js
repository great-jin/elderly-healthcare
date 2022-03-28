import request from './utils/axios'

const prefix = '/api/healthcare/loginUser'

export function getUser (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function Login (params) {
  return request({
    url: `${prefix}/login`,
    method: 'post',
    data: params
  })
}

export function addUser (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateUser (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeUser (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}

export function getAvatar (params) {
  return request({
    url: `${prefix}/getAvatar`,
    method: 'post',
    data: params
  })
}

export function updateAvatar (params) {
  return request({
    url: `${prefix}/updateAvatar`,
    method: 'post',
    data: params
  })
}
