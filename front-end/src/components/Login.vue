<template>
    <form @submit="login">
        <input type="text" placeholder="Username">
        <input type="text" placeholder="Password">
        <input type="submit" v-on:click="login" value="Login">
    </form>
</template>

<script>
export default {
    name: "Login",
    data: function() {
        return {
            username: null, 
            passwor: null
        }
    },
    methods: {
        checkForm: function () {
            return true;
        },

        login: function () {
            
        }
    }
}
</script>
