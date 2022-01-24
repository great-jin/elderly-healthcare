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
