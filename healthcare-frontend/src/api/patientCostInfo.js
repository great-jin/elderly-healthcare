import request from './utils/axios'

const prefix = '/api/healthcare/patientCostInfo'

export function listCostInfo (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getCostInfo (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addCostInfo (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateCostInfo (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeCostInfo (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
