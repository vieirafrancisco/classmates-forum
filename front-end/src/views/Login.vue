<template>
    <div class="center-parent">
        <v-card color="blue-grey" class="center" width="400px">
            <v-container fluid grid-list-lg>
                <v-layout row wrap>
                    <v-flex xs12>
                        <v-card class="justify-center">
                            <div class="aling-center">
                                <div class="headline">Faça o login</div>
                                <v-btn  @click="login">Login with Google</v-btn>
                            </div>
                        </v-card>
                    </v-flex>
                    <v-flex xs12>
                        <v-card>
                            <div class="aling-center">
                                <div class="headline">Registre com o Google</div>
                                <v-btn @click="singUp">SingUp with Google</v-btn>        
                            </div>
                        </v-card>
                    </v-flex>
                </v-layout>
                <div v-for="error in errors" v-bind:key = "error.message">
                    <v-alert :value="true" type="error">
                        {{ error.message }}
                    </v-alert>
                </div>      
            </v-container>
        </v-card>
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
                this.$router.push("/topics")
            })
            .catch((error) => {
                this.errors.push(error);
            });
        },

        singUp: function () {
            this.$store.dispatch("register")
            .then((response) => {
                this.$router.push("/topics")                
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

