import request from './utils/axios'

const prefix = '/api/healthcare/patientCaseFiles'

export function listCaseFiles (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getCaseFiles (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addCaseFiles (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateCaseFiles (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeCaseFiles (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
