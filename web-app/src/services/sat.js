import http from '../libs/http';

export default class satService {

    static consultar() {
        return http.get('/sat/emulator/consultar');
    }

}