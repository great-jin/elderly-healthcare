import request from './utils/axios'

const prefix = '/api/healthcare/patientBodyInfo'

export function listBodyInfo (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getBodyInfo (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function getCharData (params) {
  return request({
    url: `${prefix}/getChar?patientId=${params}`,
    method: 'get'
  })
}

export function addBodyInfo (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function addBatchInfo (params) {
  return request({
    url: `${prefix}/addBatch`,
    method: 'post',
    data: params
  })
}

export function updateBodyInfo (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeBodyInfo (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
