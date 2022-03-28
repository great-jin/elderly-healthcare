import request from './utils/axios'

const prefix = '/api/healthcare/patientCostDetail'

export function listPatientCostDetail () {
  return request({
    url: `${prefix}/list`,
    method: 'get'
  })
}

export function getPatientCostDetail (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addPatientCostDetail (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updatePatientCostDetail (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removePatientCostDetail (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
