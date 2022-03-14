import request from './axios';

export function getUser(params) {
  return request({
    url: `/api/healthcare/loginUser/get?id=${params}`,
    method: 'get'
  })
}

export function Login(params) {
  return request({
    url: '/api/healthcare/loginUser/login',
    method: 'post',
    data: params
  })
}

export function addUser(params) {
  return request({
    url: '/api/healthcare/loginUser/add',
    method: 'post',
    data: params
  })
}
