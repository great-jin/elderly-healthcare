import request from './utils/axios'

const prefix = '/api/healthcare/organizeStaff'

export function listOrganizeStaff () {
  return request({
    url: `${prefix}/list`,
    method: 'get'
  })
}

export function getOrganizeStaff (params) {
  return request({
    url: `${prefix}/get?id=${params}`,
    method: 'get'
  })
}

export function addOrganizeStaff (params) {
  return request({
    url: `${prefix}/add`,
    method: 'post',
    data: params
  })
}

export function updateOrganizeStaff (params) {
  return request({
    url: `${prefix}/update`,
    method: 'post',
    data: params
  })
}

export function removeOrganizeStaff (params) {
  return request({
    url: `${prefix}/delete`,
    method: 'post',
    data: params
  })
}
