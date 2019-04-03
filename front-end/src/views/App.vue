<template>
  <div>
    <v-toolbar color="blue-grey" class="white--text">


      <v-toolbar-title class="title"><strong>Classmates Forum</strong></v-toolbar-title>

      <v-spacer></v-spacer>

      <v-chip v-if="logged" label color="white" text-color="blod">
        <v-avatar>
          <img :src="photoURL" alt="">
        </v-avatar>
        <strong>{{displayName}}</strong>
      </v-chip>
      
      <v-spacer></v-spacer>

      <v-toolbar-items class="hidden-sm-and-down">
        <v-btn @click="$router.push('/topics')" flat class="white--text">
          Topics
        </v-btn>
        <v-btn @click="$router.push('/posts')" flat class="white--text">
          Posts
        </v-btn>
        <v-btn color="red" dark v-if="logged" v-on:click="logout"><Strong>Logout</Strong>
          <v-icon dark right>keyboard_arrow_left</v-icon>
        </v-btn>
        <v-btn color="white" class="green--text" dark v-else @click="$router.push('login')"><strong>Login</strong>
          <v-icon dark right>keyboard_arrow_right</v-icon>
        </v-btn>
      </v-toolbar-items>
    </v-toolbar>

    <v-container fluid>
      <router-view></router-view>
    </v-container>

    <v-footer class="pa-3" fixed>
      <v-spacer></v-spacer>
      <div>&copy; {{ new Date().getFullYear() }}</div>
    </v-footer>
   
  </div>
  <!-- <div id="app">
    <img alt="Vue logo" src="../assets/logo.png">
    <a href = "#" v-if = "logged" v-on:click = "logout"> Click for logout </a>
    <router-link v-else to="/login"> Click for login </router-link>
    <router-link to="/topics"> Click for topic </router-link>
    <router-view></router-view>
  </div> -->
</template>

<script>

export default {
  name: 'app',
  components: {
  },
  computed : {
      logged() {
          return this.$store.state.userStore.logged;
      },

      displayName() {
        return this.$store.state.userStore.displayName 
      },
      
      photoURL() {
        return this.$store.state.userStore.photoURL 
      }
  },

  methods : {
    logout(){
      this.$store.dispatch("logout")
      .then((response) => {
        
      }).catch((error) => {
        
      });
    }
  },
  beforeMount() {
    this.$store.commit("LOAD_USER_SECTION");
  }

}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
 