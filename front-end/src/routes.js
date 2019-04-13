import Login  from "./views/Login.vue";
import Topic from "./views/Topic.vue";
import Posts from "./views/Posts.vue"
import Post from "./views/Post.vue"
import TopicCreate from './components/topic/TopicCreate.vue'

const routes = [
    { path: '/login', component: Login},
    { path: '/topics', component: Topic},
    { path: '/topics/:topicId/posts', component : Posts},
    { path: '/topics/:topicId/posts/:postId', component : Post},
    { path: '/topic/create', component: TopicCreate},
]

export default routes; 

