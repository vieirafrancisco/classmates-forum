import Login  from "./views/Login.vue";
import Topic from "./views/Topic.vue";
import TopicCreate from './components/TopicCreate.vue'

const routes = [
    { path: '/login', component: Login},
    { path: '/topic', component: Topic},
    { path: '/topic/create', component: TopicCreate}
]

export default routes; 

