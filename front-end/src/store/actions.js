import services from '../services/services'
import {sectionStatus, generalStatus} from "./../api/status.config.json"
import { async } from "q";

export async function callService({state}, {name, data = {}}){
    try{
        if(name in services){
            const service = services[name]
            const callback = service.func;

            if(service.permition == "user"){
                if(state.userStore.logged){
                    data.uid = state.userStore.uid;
                }else{
                    throw {code : 403}
                } 
            }

            return await callback(data);
        }else{
            throw {code : 503};
        }

    }catch(error){
        const serveErrors = generalStatus["serveErrors"]
        const statusCode = !error.response ? error.code : error.response.status
        const sectionStatusName = Object.keys(sectionStatus).find(key => {
            return name in sectionStatus[key];
        })
        const errorsService = !!sectionStatusName ? sectionStatus[sectionStatusName][name] : {}
        let _error = {message : "Error not found", info : JSON.stringify(error)}

        if(statusCode in errorsService){
            _error = errorsService[statusCode];
        }else if(statusCode in serveErrors){
            _error = serveErrors[statusCode]
        }

        _error["code"] = statusCode;
        _error["service"] = name;
        _error["data"] = data;

        throw _error
    }
    
}