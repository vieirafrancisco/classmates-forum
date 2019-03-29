import {sectionStatus, generalStatus} from "./../api/status.config.json"

export function apiAction(context, {errorSection, actionName, args}) {
    return new Promise((resolve, reject) => {
        context.dispatch(actionName).then((response) => {
            resolve(response);
        }).catch((error) => {
            let statusCode;
            const serverErrors = generalStatus["serveErrors"]
            const errorsActionStatus = sectionStatus[errorSection][actionName];
            const errors = []

            if(!error.response){
                statusCode = error.code;
            }else{
                statusCode = error.response.status;
            }

            if(statusCode in errorsActionStatus){
                errors.push(errorsActionStatus[statusCode]);
            }else if(statusCode in serverErrors){
                errors.push(serverErrors[statusCode])
            }

            reject(errors)
        });
    }); 
}