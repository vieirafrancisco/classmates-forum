<template>
    <div>
        <button  @click="logout">Logout</button>
        <div>
            <p>{{message}}</p>
        </div>
    </div>
</template>

<script>
import firebase from 'firebase';

export default {
    name: "Logout",
    data: function() {
        return {
            message: null
        }
    },
    methods: {
        logout: function () {

            firebase.auth().signOut().then(() => {
                this.message = "Successful logout"
            }).catch(() => {
                this.message = "Unsuccessful logout";
            })
        }
    }
}
</script>
