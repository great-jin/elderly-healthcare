import request from './utils/axios'

const prefix = '/api/healthcare/vacateInfo'

export function listVacateInfo (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getVacateInfo (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addVacateInfo (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateVacateInfo (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeVacateInfo (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
