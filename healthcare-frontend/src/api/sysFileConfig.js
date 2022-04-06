import request from './utils/axios'

const prefix = '/api/healthcare/sysFileConfig'

export function listMinioConfig (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getBuckets () {
  return request({
    url: `${prefix}/getBuckets`,
    method: 'get'
  })
}

export function createBucket (params) {
  return request({
    url: `${prefix}/createBucket?bucketName=${params}`,
    method: 'get'
  })
}

export function deleteBucket (params) {
  return request({
    url: `${prefix}/deleteBucket?bucketName=${params}`,
    method: 'get'
  })
}

export function getMinioConfig (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addMinioConfig (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateMinioConfig (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeMinioConfig (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
