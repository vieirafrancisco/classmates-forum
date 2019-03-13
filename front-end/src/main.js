import Vue from 'vue'
import App from './App.vue'
import routes from './routes.js'
import VueRouter from 'vue-router';
import initialize from './firabase.config.js'

Vue.use(VueRouter)

const router = new VueRouter({
  routes
})

// initialieze module firebase
initialize();

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')

