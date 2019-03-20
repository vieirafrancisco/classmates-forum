import firebase from 'firebase';



 const userStore = {
    state: {
      uid: localStorage.getItem("uid"),
      name : localStorage.getItem("name"),
      photoUrl : localStorage.getItem("photoUrl"),
      phoneNumber : localStorage.getItem("phoneNumber"), 
      email : localStorage.getItem("email"),
      token : localStorage.getItem("token"),
      logged : !!localStorage.getItem("logged"),

    },
    mutations: {
      saveUser (state, firebaseUser, token) {
        state.uid = firebaseUser.uid;
        state.name = firebaseUser.displayName;
        state.photoUrl = firebaseUser.photoURL;
        state.phoneNumber = firebaseUser.phoneNumber;
        state.email = firebaseUser.email;
        state.token = token;    
        state.logged = true;

        localStorage.setItem("uid", state.uid);
        localStorage.setItem("name", state.name);
        localStorage.setItem("photoUrl", state.photoURL);
        localStorage.setItem("phoneNumber", state.phoneNumber);
        localStorage.setItem("email", state.email);
        localStorage.setItem("token", state.token);
        localStorage.setItem("logged", state.logged);
      }
    },

    actions : {
        login(context){
            return new Promise(function(resolve, reject){
                const provider =  new firebase.auth.GoogleAuthProvider();
                firebase.auth().signInWithPopup(provider).then((result) =>{
                    const firebaseUser = result.user; 
                    context.commit("saveUser", firebaseUser, result.credential.accessToken)
                    resolve();
                    
                }).catch((error) => {
                    reject(error)
                })
            });
        }

    }
  }

  export default userStore;