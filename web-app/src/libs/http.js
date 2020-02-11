import axios from 'axios';

const client = axios.create({
    baseURL: 'http://localhost:8999'
});


export default client;