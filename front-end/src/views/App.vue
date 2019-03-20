<template>
  <div id="app">
    <img alt="Vue logo" src="../assets/logo.png">
    <router-link v-if = "logged" to="/logout"> Click for logout </router-link>
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
          return this.$store.state.logged;
      }
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
