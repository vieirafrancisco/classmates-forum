import firebase from 'firebase';

const LOGIN_METHOD = "pop-up"

export const signInFirebase= () => {
    const provider =  new firebase.auth.GoogleAuthProvider();
    if(LOGIN_METHOD == "pop-up") {
        return firebase.auth().signInWithPopup(provider);
    } 
}

export const logoutFirebase = () => {
    return firebase.auth().signOut();
}