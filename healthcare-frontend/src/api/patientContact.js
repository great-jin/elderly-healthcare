import request from './axios'

const prefix = '/api/healthcare/patientContact'

export function listPatientContact () {
  return request({
    url: `${prefix}/list`,
    method: 'get'
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
