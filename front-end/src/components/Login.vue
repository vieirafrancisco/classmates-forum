<template>
    <div>
        <li v-for="error in errors">
            {{ error.message }}
        </li>
        <button  @click="login">Login with Google</button>
        <button  @click="singUp">SingUp with Google</button>        
        <div>
            <p>Name: {{name}}</p>

        </div>
    </div>
</template>

<script>
import {userStatus} from "../api/status.config.json"

export default {
    name: "Login",
    data: function() {
        return {
            errors : [],
        }
    },
    methods: {
        
        login: function () {
            this.$store.dispatch("login").then(result => {
                
            }).catch(error => {
                const statusCode = error.response.status;
                const loginStatus = userStatus.login
                if(statusCode >= 500){
                    this.errors.push({message : "Try again!!!"});
                }else{
                    if(statusCode in loginStatus){
                        this.errors.push(loginStatus[statusCode]);
                    }else{
                        this.errors.push({message : "Erro não esperado"});
                    }
                }
            })
            
        },

        singUp: function () {
            this.$store.dispatch("register").then(result => {
                
            }).catch(error => {
                const statusCode = error.response.status;
                const createStatus = userStatus.login

                if(statusCode == 500){
                    this.errors.push({message : "Try again!!!"});
                }else{
                    if(statusCode in createStatus){
                        this.errors.push(createStatus[statusCode]);
                    }else{
                        this.errors.push({message : "Erro não esperado"});
                    }
                }
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
