import {getAll} from "../../services/topic.service"

const topicStore = {
    state : {
        topics : []
    },

    mutations : {
        SET_TOPICS(state, topics) {
            state.topics = topics;
        }
    },

    actions : {
        fecth_topics({commit}) {
            return new Promise(function(resolve, reject){
                getAllTopics().then((response) => {
                    resolve(response.data);
                }).catch((error) => {
                    reject(error);
                });
            });
        }
    }
}