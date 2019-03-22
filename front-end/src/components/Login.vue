<template>
    <div>
        <button  @click="login">Login with Google</button>
        <div>
            <p>Name: {{name}}</p>

        </div>
    </div>
</template>

<script>
export default {
    name: "Login",
    data: function() {
        return {
            erros : [],
        }
    },
    methods: {
        login: function () {
            this.$store.dispatch("login").then(result => {
                
            }).catch(error => {
                alert(error.message);
                this.erros.push(error.message)
            })
            
        }
    },
    computed : {
        name(){
            return this.$store.state.name
        }
    }

}
</script>
