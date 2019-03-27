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
            this.$store.dispatch("apiAction", {
                errorSection : "userStatus",
                actionName : "login"
            })
            .then((response) => {

            }).catch((errors) => {
                this.errors = this.errors.concat(errors);
            });
        },

        singUp: function () {
            this.$store.dispatch("apiAction", {
                errorSection : "userStatus",
                actionName : "register"
            })
            .then((response) => {

            }).catch((errors) => {
                this.errors = this.errors.concat(errors);
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

