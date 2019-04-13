import api from "../api/axiosAPI"
import {commentRoutes} from '../api/routes.config.json' 
import { Comment, Comments } from "../ApiMock.json";


export function createComment(postId, comment){
    api.post(commentRoutes["createComment"] + postId, comment);
}

export function get() {
    return JSON.stringify(Comment);
}

export function getAll() {
    return JSON.stringify(Comments);
}

export function create() {

}

export function remove() {

}

export function update() {

}