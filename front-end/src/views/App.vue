<template>
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
      this.$store.dispatch("apiAction", {
        errorSection : "userStatus",
        actionName : "logout"
      }).then((response) => {

      }).catch((error) => {

      });
    }
  },
  beforeMount() {
    this.$store.commit("LOAD_USER_SECTION");
    this.$store.dispatch("apiAction", {
      errorSection : "topicStatus",
      actionName : "getTopics"
    }).then((response) => {
        alert(JSON.stringify(response))
    }).catch(error => {
      
    });
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
 