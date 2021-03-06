import Vue from 'vue'
import Vuex from 'vuex'

import App from './views/App.vue'
import routes from './routes.js'
import VueRouter from 'vue-router';
import firebase from  'firebase';
import mainStore from './store/index.js'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import {config} from './firebase.config.json'

Vue.use(Vuex)
Vue.use(VueRouter)
Vue.use(Vuetify, {
  iconfont: "md", 
})

const store = new Vuex.Store(mainStore);
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

