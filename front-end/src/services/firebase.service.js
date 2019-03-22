import firebase from 'firebase';

const LOGIN_METHOD = "pop-up"

export const signIn = () => {
    const provider =  new firebase.auth.GoogleAuthProvider();
    if(LOGIN_METHOD == "pop-up") {
        return firebase.auth().signInWithPopup(provider);
    } 
}