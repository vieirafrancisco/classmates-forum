import api from "../api/axiosAPI"
import {postRoutes} from "../api/routes.config.json" 
import { Post, Posts } from "../ApiMock.json";

export function getPost({postId}) {
    return api.get(postRoutes["getPost"] + postId)
}

export function getTopicPosts({topicId}) {
    return JSON.stringify(Posts)
}

export function create() {

}

export function remove() {

}

export function update() {

}