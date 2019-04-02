<template>
    <!-- <v-toolbar>
      <v-toolbar-title><strong>Classmates Forum</strong></v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-items class="hidden-sm-and-down">
        <v-btn color="red" dark v-if="logged" v-on:click="logout">Logout
          <v-icon dark right>keyboard_arrow_right</v-icon>
        </v-btn>
        <v-btn color="green" dark v-else @click="$router.push('login')">{{"logged"}}
          <v-icon dark right>keyboard_arrow_right</v-icon>
        </v-btn>

      </v-toolbar-items>
      <router-view></router-view>
    </v-toolbar> -->

  <div id="app">
    <img alt="Vue logo" src="../assets/logo.png">
    <a href = "#" v-if = "logged" v-on:click = "logout"> Click for logout </a>
    <router-link v-else to="/login"> Click for login </router-link>
    <router-link to="/topic"> Click for topic </router-link>
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'app',
  components: {
  },
  computed : {
      logged() {
          return this.$store.state.userStore.logged;
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
 