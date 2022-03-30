import request from './utils/axios'

const prefix = '/api/healthcare/medicineCatalog'

export function listMedicineCatalog (params) {
  return request({
    url: `${prefix}/list`,
    method: 'get',
    params: params
  })
}

export function getMedicineCatalog (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addMedicineCatalog (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateMedicineCatalog (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeMedicineCatalog (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
