import request from './axios';

export function List(params) {
  return request({
    url: '/api/healthcare/users/list',
    method: 'get',
  })
}

export function getUser(params) {
  return request({
    url: `/api/healthcare/users/get?code=${params}`,
    method: 'get'
  })
}

export function Login(params) {
  return request({
    url: '/api/healthcare/users/login',
    method: 'post',
    data: params
  })
}

export function addUser(params) {
  return request({
    url: '/api/healthcare/users/register',
    method: 'post',
    data: params
  })
}
