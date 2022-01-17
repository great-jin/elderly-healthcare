import request from './axios';

export function List(params) {
  return request({
    url: '/users/list',
    method: 'get',
  })
}
