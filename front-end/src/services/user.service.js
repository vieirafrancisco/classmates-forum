// import { User, Users } from "../ApiMock.json";
import api from "../api/axiosAPI.js"
import {userRoutes} from "../api/routes.config.json" 

/**
 * Create an user
 * 
 * @param {Object} user
 * @param {string} user.uid
 * @param {string} user.displayName
 * @param {string} user.photoUrl
 * @param {string} user.email
 * 
 * @returns {Promise}
 */
export const createUser = ({uid, displayName, photoUrl, email}) => {
    return api.post(userRoutes["create"], {
        uid: uid, 
        name: displayName
    });
}


export function removeUser() {

}


export function updateUser() {

}

/**
 * Login an user in api 
 * 
 * @param {string} uid
 * 
 * @returns {Promise}
 */
export const loginUser = ({uid}) => {
    api.defaults.headers.common['token'] = uid;
    return api.post(userRoutes["login"], {uid}) 
}

/**
 * Logout an user in api 
 * 
 * @param {string} uid
 * 
 * @returns {Promise}
 */
export const logoutUser = ({uid}) => {
    return api.post(userRoutes["logout"], {
        uid:uid
    }) 
}