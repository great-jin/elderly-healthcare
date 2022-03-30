import request from './utils/axios'

const prefix = '/api/healthcare/patientCaseInfo'

export function listCaseInfo () {
  return request({
    url: `${prefix}/list`,
    method: 'get'
  })
}

export function getCaseInfo (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addCaseInfo (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateCaseInfo (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeCaseInfo (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
