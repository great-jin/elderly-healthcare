import request from './axios';

export function List(params) {
  return request({
    url: '/users/list',
    method: 'get',
  })
}

export function Login(params) {
  return request({
    url: '/users/login',
    method: 'post',
    data: params
  })
}

export function addUser(params) {
  return request({
    url: '/users/register',
    method: 'post',
    data: params
  })
}
