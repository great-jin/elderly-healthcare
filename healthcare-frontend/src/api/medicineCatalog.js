import request from './axios'

const prefix = '/api/healthcare/medicineCatalog'

export function listMedicineCatalog () {
  return request({
    url: `${prefix}/list`,
    method: 'get'
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
