import {getAllTopics} from "../../services/topic.service"

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
        getTopics({commit}) {
            return new Promise((resolve, rejected) => {
                getAllTopics().then((response) => {
                    commit("SET_TOPICS", response.data)
                    resolve(response.data);
                }).catch((error) => {
                    rejected(error);
                });
            })
        }
    }
}

export default topicStore;