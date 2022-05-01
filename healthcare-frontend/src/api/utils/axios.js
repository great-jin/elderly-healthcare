import axios from 'axios'

function request (axiosConfig) {
  const service = axios.create({
    // 设置统一的请求前缀
    baseURL: '/api',
    // 超时时间60秒
    timeout: 60000
  })

  service.interceptors.request.use(config => {
    return config
  }, err => {
    console.log(err)
  })

  // 响应拦截
  service.interceptors.response.use(res => {
    return res
  }, err => {
    console.log(err)
  })

  return service(axiosConfig)
}

export default request
