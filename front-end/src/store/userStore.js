import firebase from 'firebase';
import UserStorageService from '.././services/storage.service.js'

 const userStore = {
    state: {
      uid: UserStorageService.getItem("uid"),
      displayName : UserStorageService.getItem("displayName"),
      photoUrl : UserStorageService.getItem("photoUrl"),
      phoneNumber : UserStorageService.getItem("phoneNumber"), 
      email : UserStorageService.getItem("email"),
      token : UserStorageService.getItem("token"),
      logged : !!UserStorageService.getItem("logged"),

    },

    mutations: {
      setUserProperty(state, [key, value]){
        alert(value)
        if(key in state){
          UserStorageService.setItem(key, value);
          state[key] = value;
    
        }else{
          throw "key in not in state";
        }
      },

      deleteUserState(state){
        UserStorageService.deleteSection;
        state = state.de
      }
    },

    actions : {
        login(context){
            return new Promise(function(resolve, reject){
                const provider =  new firebase.auth.GoogleAuthProvider();
                firebase.auth().signInWithPopup(provider).then((result) =>{
                    const firebaseUser = result.user; 
                    context.dispatch("saveUserSection", firebaseUser, result.credential.token)
                    context.commit("setUserProperty", ["logged", true]);
                    resolve("Resolved");
                    
                }).catch((error) => {
                    reject(error)
                })
            });
        },

        logout(context){
          context.commit("deleteUser");
        },

        saveUserSection(context, firebaseUser, token) {
          context.commit("setUserProperty", ["uid", firebaseUser.uid]);
          context.commit("setUserProperty", ["displayName", firebaseUser.displayName]);
          context.commit("setUserProperty", ["photoUrl", firebaseUser.photoUrl]);
          context.commit("setUserProperty", ["phoneNumber", firebaseUser.phoneNumber]);
          context.commit("setUserProperty", ["email", firebaseUser.email]);
          context.commit("setUserProperty", ["email", firebaseUser.email]);
          context.commit("setUserProperty", ["token", token]);
      }
    }
  }

  export default userStore;