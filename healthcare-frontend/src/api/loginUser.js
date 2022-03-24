import request from './axios'

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
