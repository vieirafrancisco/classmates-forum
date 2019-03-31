<template>
    <div>
        <li v-for="error in errors" v-bind:key = "error.message">
            {{ error.message }}
        </li>
        <button  @click="login">Login with Google</button>
        <button  @click="singUp">SingUp with Google</button>        
    </div>
</template>

<script>

export default {
    name: "Login",
    data: function() {
        return {
            errors : [],
        }
    },
    methods: {
        login: function () {
            this.$store.dispatch("login")
            .then((response) => {
                
            })
            .catch((error) => {
                this.errors.push(error);
            });
        },

        singUp: function () {
            this.$store.dispatch("register")
            .then((response) => {
                
            })
            .catch((error) => {
                this.errors.push(error);
            });
        }
    },
    computed : {
        name(){
            return this.$store.state.userStore.name;
        },
        logged(){
            return this.$store.state.userStore.logged;
        }
    }

}
</script>

