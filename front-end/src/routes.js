import Login  from "./components/Login.vue";
import Logout from "./components/Logout.vue";
import Topic from "./components/Topic.vue";

const routes = [
    { path: '/login', component: Login},
    { path: '/logout', component: Logout},
    { path: '/topic', component: Topic}
]

export default routes; 

