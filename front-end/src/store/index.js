import userStore from './modules/userStore.js'
import topicStore from './modules/topicStore.js'
import {callService} from './actions.js'

const mainStore = {
    modules : {
        topicStore,
        userStore
    },

    actions : {
        callService
    }

};

export default mainStore;

