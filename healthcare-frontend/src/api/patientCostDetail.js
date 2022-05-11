import request from './utils/axios'

const prefix = '/api/healthcare/patientCostDetail'

export function listCostDetail (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getCostDetail (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function getCost (params) {
  return request({
    url: `${prefix}/getCost?Id=${params}`,
    method: 'get'
  })
}

export function addCostDetail (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateCostDetail (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeCostDetail (params) {
  return request({
    url: `${prefix}/delete?id=${params}`,
    method: 'get'
  })
}
