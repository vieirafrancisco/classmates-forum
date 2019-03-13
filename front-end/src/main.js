import Vue from 'vue'
import App from './App.vue'
import routes from './routes.js'
import VueRouter from 'vue-router';
import firebase from  'firebase';
import {config} from './firebase.config.json';

Vue.use(VueRouter)

const router = new VueRouter({
  routes
})

// initialieze module firebase
firebase.initializeApp(config);

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')

