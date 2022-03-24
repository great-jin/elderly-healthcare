import request from './axios'

const prefix = '/api/healthcare/dailyTask'

export function listTask () {
  return request({
    url: `${prefix}/list`,
    method: 'get'
  })
}

export function getTask (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addTask (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateTask (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeTask (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
