import { signInFirebase, logoutFirebase } from "../../services/firebase.service"
import { createUser, loginUser, logoutUser } from "../../services/user.service"
import UserStorageService from '../../services/storage.service.js'

const userStore = {
    state: {
      uid: null,
      displayName : null,
      photoURL : null,
      phoneNumber : null, 
      email : null,
      token : null,
      logged : false,
    },

    mutations: {
      SAVE_USER_SECTION(state, firebaseUser){
        Object.keys(state).forEach(function(key,index) {
          if(key in firebaseUser){
            state[key] = firebaseUser[key]
            UserStorageService.setItem(key, firebaseUser[key]);
          }
        });
      },
      LOAD_USER_SECTION(state){
        Object.keys(state).forEach(function(key) {
          state[key] = UserStorageService.getItem(key);
        });
      },
      DELETE_USER_SECTION(state){
        UserStorageService.deleteSection();
        Object.keys(state).forEach(function(key,index) {
          state[key] = null;
        });
      },
      SET_USER_TOKEN(state, token){
        state["token"] = token;
        state["logged"] = true;
        UserStorageService.setItem("token", token);
        UserStorageService.setItem("logged", true);
      }
    },

    actions : {
        login({commit}){
          return new Promise(function(resolve, reject){

            signInFirebase().then((result) =>{
              const uid = result.user.uid;
              loginUser(uid).then((response) => {
                commit("SAVE_USER_SECTION", result.user);
                commit("SET_USER_TOKEN", result.credential.token)

                resolve(response);
              }).catch((error) => {
                reject(error);
              }); 

            }).catch((error) => {
                reject(error);
            })
          });
        },

        logout({commit,state}){
          return new Promise(function(resolve, reject){
            
            if(state.logged){

              logoutFirebase().then(el => {
                logoutUser(state.uid).then((response) => {
                  commit("DELETE_USER_SECTION");
                  resolve(response);

                }).catch((error) => {
                  reject(error);
                })
              
              }).catch(error => {
                reject(error)
              })

              
            }else{
              reject("User not logged");
            }
          });

        },

        register({commit}){
          return new Promise(function(resolve, reject) {
            signInFirebase().then((result) => {
              const uid = result.user.uid;
              const displayName = result.user.displayName;
              const photoURL = result.user.photoURL;
              const email = result.user.email;
              createUser(uid, displayName, photoURL, email).then((response) => {
                commit("SAVE_USER_SECTION", result.user);
                commit("SET_USER_TOKEN", result.credential.token);
                
                resolve(response);
              }).catch((error) => {
                reject(error);
              })

            }).catch((error) => {
              reject(error);
            });
          })
        },
    }
  }

  export default userStore;