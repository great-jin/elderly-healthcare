import request from './utils/axios'

const prefix = '/api/healthcare/patientContact'

export function listPatientContact (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getPatientContact (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addPatientContact (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updatePatientContact (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removePatientContact (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
