import userStore from './modules/userStore.js'
import {apiAction} from './actions.js'

const mainStore = {
    modules : {
        userStore
    },

    actions : {
        apiAction
    }
};

export default mainStore;

