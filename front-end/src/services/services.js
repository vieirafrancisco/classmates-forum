import {signInFirebase, logoutFirebase} from './firebase.service'
import {createUser, loginUser, logoutUser} from './user.service'
import {getTopic, getAllTopics, createTopic} from './topic.service'
import {getPost, getTopicPosts} from './post.service'

const firebaseServices = {
    signInFirebase : {
        func : signInFirebase,
        params : {},
        heading : {},
        permition : "public"
    },

    logoutFirebase : {
        func : logoutFirebase,
        params : {},
        heading : {},
        permition : "public"
    },
}

const userServices = {
    createUser : {
        func : createUser,
        params : { uid : String, displayName : String},
        heading : {},
        permition : "public"
    },

    loginUser : {
        func : loginUser,
        params : { uid : String },
        heading : {},
        permition : "public"
    },

    logoutUser : {
        func : logoutUser,
        params : { uid : String},
        heading : {},
        permition : "user"
    }

}

const topicsServices = {
    getTopic : {
        func : getTopic,
        params : {topicId : Number},
        heading : {},
        permition : "public"
    },

    getAllTopics : {
        func : getAllTopics,
        params : {},
        heading : {},
        permition : "public"
    },

    createTopic : {
        func : createTopic,
        params : {uid : String, description : String, tags : Object},
        heading : {},
        permition : "user"
    }
}

const postServices = {
    getPost : {
        func : getPost,
        params : {postId : Number},
        heading : {},
        permition : "public"
    },

    getTopicPosts : {
        func : getTopicPosts,
        params : {topicId : Number},
        heading : {},
        permition : "public"
    }
}

const services = [firebaseServices,userServices,topicsServices,postServices].reduce((acc, cur) => {
    return {...acc, ...cur}
})

export default services;