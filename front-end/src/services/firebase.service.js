import firebase from 'firebase';

const LOGIN_METHOD = "redirect"

export const signInFirebase= () => {
    const provider =  new firebase.auth.GoogleAuthProvider();
    if(LOGIN_METHOD == "redirect") {
        return firebase.auth().signInWithRedirect(provider);
    } 
}

export const logoutFirebase = () => {
    return firebase.auth().signOut();
}
