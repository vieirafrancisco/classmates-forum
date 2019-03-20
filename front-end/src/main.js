import Vue from 'vue'
import App from './App.vue'
import routes from './routes.js'
import VueRouter from 'vue-router';
import firebase from  'firebase';
import userStore from "./userStore.js"
import Vuex from "vuex";
import {config} from './firebase.config.json';


Vue.use(VueRouter)
Vue.use(Vuex)

const store = new Vuex.Store(userStore);

const router = new VueRouter({
  routes
});

// initialieze module firebase
firebase.initializeApp(config);

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')

