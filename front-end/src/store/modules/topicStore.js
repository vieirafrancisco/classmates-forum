import {getAllTopics} from "../../services/topic.service"

const topicStore = {
    state : {
        topics : [],
        loading : false
    },

    mutations : {
        SET_TOPICS(state, topics) {
            state.topics = topics;
        },
        SET_LOADING(state){
            state.loading = !state.loading
        }

    },

    actions : {
        async getTopics({dispatch,commit}) {
            commit("SET_LOADING");

            const responseAllTopics = await dispatch("callService", {"name" : "getAllTopics"});

            commit("SET_LOADING");
            commit("SET_TOPICS", responseAllTopics.data);
        },

        createTopic({commit}, topic){
            apicall("admin",function(uid){
            });
        }
    }
}

export default topicStore;