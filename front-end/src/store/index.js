import userStore from './modules/userStore.js'
import topicStore from './modules/topicStore.js'
import {apiAction} from './actions.js'

const mainStore = {
    modules : {
        topicStore,
        userStore
    },

    actions : {
        apiAction
    }
};

export default mainStore;

