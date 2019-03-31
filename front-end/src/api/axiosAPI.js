import axios from 'axios';
const pathAPI = {
  "localhost": "http://localhost:8080", 
  "pc-lab": "http://172.19.190.132:8080"
}
const api = axios.create({
  baseURL: pathAPI["pc-lab"],
  timeout: 1000,
  headers: {}
});

export default api; 