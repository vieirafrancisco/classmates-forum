import api from "../api/axiosAPI"
import {topicRoutes} from "../api/routes.config.json" 
import { Topic, Topics } from "../ApiMock.json";

export function get() {
    return JSON.stringify(Topic);
}

/**
 * Get all of created topics
 * 
 * @param {Object} topics
 * @param {Int} topic.id
 * @param {String} topic.description
 * @param {Object} topic.tags
 * @param {Object} topic.posts
 * @param {String} topic.author
 * 
 * @returns {Promise}
 */
export function getAllTopics( ) {
    return api.get(topicRoutes["getTopics"])
}

/**
 * Create an topic 
 * 
 * @param {Object} topic
 * @param {String} topic.author.uid
 * @param {String} topic.description
 * @param {Object} topic.tags
 * 
 * @returns {Promise}
 */
export function createTopic({uid, description, tags}) {
    return api.post(topicRoutes["createTopic"], {
        author: {uid : uid}, 
        description : description,
        tags : tags
    });
}


export function remove() {

}

export function update() {

}