<template>
    <div>
        <button  @click="login">Login with Google</button>
        <div>
            <img :src=photoUrl alt="">
            <p>Name: {{name}}</p>
            <p>Email: {{email}}</p>
            <p>Token: {{token}}</p>

        </div>
    </div>
</template>

<script>
import firebase from 'firebase';

export default {
    name: "Login",
    data: function() {
        return {
            name: null, 
            email: null,
            photoUrl: null, 
            phoneNumber: null,  
            token: null
        }
    },
    methods: {
        login: function () {
            const provider =  new firebase.auth.GoogleAuthProvider();

            firebase.auth().signInWithPopup(provider).then((result) =>{
                const user = result.user; 
                this.name = user.displayName;
                this.photoUrl = user.photoURL;
                this.phoneNumber = user.phoneNumber;
                this.email = user.email;
                this.token = result.credential.accessToken;                

            }).catch((error) => {
                alert(error.message); 
            })
        }
    }
}
</script>
