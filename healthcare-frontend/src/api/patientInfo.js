import request from './utils/axios'

const prefix = '/api/healthcare/patientInfo'

export function listPatientInfo () {
  return request({
    url: `${prefix}/list`,
    method: 'get'
  })
}

export function getPatientInfo (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addPatientInfo (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updatePatientInfo (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removePatientInfo (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}