import axios from 'axios';

function request(axiosConfig) {
  const service = axios.create({
    baseURL: '/api',   // 设置统一的请求前缀
    timeout: 10000,    // 设置统一的超时时长
  });

  service.interceptors.request.use(config => {
    return config
  }, err => {
    console.log(err);
  })

  // 响应拦截
  service.interceptors.response.use(res => {
    return res.data
  }, err => {
    console.log(err);
  })

  return service(axiosConfig)
}

export default request;
