import userStore from './modules/userStore.js'
import topicStore from './modules/topicStore.js'
import postStore from './modules/postStore'
import {callService} from './actions.js'

const mainStore = {
    modules : {
        topicStore,
        userStore,
        postStore
    },

    actions : {
        callService
    }

};

export default mainStore;

