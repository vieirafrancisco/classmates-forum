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
        
      async login({dispatch,commit}){
        const responseFirebase = await dispatch("callService", {name : "signInFirebase"});
        const user_uid = responseFirebase.user.uid;
        const loginUserData = {name : "loginUser", data : {uid : user_uid}}
        const responseLoginUser = await dispatch("callService", loginUserData);

        commit("SAVE_USER_SECTION", responseFirebase.user);
        commit("SET_USER_TOKEN", responseFirebase.credential.token);

        return responseLoginUser;

      },

      async logout({dispatch,commit}){
        const responseFirebase = await dispatch("callService", {name : "logoutFirebase"});
        const responseLogoutUser = await dispatch("callService", {name : "logoutUser"});
        
        commit("DELETE_USER_SECTION");

        return responseLogoutUser;
      },

      async register({dispatch,commit}){
        const responseFirebase = await dispatch("callService", {name : "signInFirebase"});
        const userFirebase = responseFirebase.user
        const user_uid = userFirebase.uid;
        const createUserData = {name : "createUser", data : userFirebase}
        const responseCreateUser = await dispatch("callService", createUserData);
        const loginUserData = {name : "loginUser", data : {uid : user_uid}}
        const responseLoginUser = await dispatch("callService", loginUserData);
        
        commit("SAVE_USER_SECTION", userFirebase);
        commit("SET_USER_TOKEN", responseFirebase.credential.token);

        return responseCreateUser;
      },
    }
  }

  export default userStore;