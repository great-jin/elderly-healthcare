import request from '../utils/axios'

const prefix = '/api/healthcare/users'

export function List (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get'
  })
}

export function getUser (params) {
  return request({
    url: `${prefix}/get?code=${params}`,
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
    url: `${prefix}/register`,
    method: 'post',
    data: params
  })
}
