import api from "../api/axiosAPI"
import {topicRoutes} from "../api/routes.config.json" 
import { Topic, Topics } from "../ApiMock.json";

export function get() {
    return JSON.stringify(Topic);
}

export function getAllTopics( ) {
    return api.get(topicRoutes["getTopics"])
}


export function create() {

}

export function remove() {

}

export function update() {

}