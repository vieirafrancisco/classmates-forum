import { async } from "q";

const postStore = {
    state : {
        posts : {},
        topicPosts : {},
        currentPost : null,
        currentTopicPosts : null
    },

    mutations : {
        SET_POST(state, post){
            state.currentPost = post;
            state.posts[post.id] = post;
        },

        SET_TOPICPOSTS(state, [topicId,topicPosts]){
            state.currentTopicPosts = topicPosts;
            state.topicPosts[topicId] = topicPosts;
        }
    },

    actions : {
        async getPost({dispatch,commit}, postId){
            const getPostData = {name : "getPost", data : {postId : postId}};
            const responseGetPost = await dispatch("callService", getPostData);

            commit("SET_POST", responseGetPost.data);
            alert(JSON.stringify(responseGetPost))
            return responseGetPost;
        },

        async getTopicPosts({dispatch,commit,state}, topicId){   
            const getTopicPostsData = {name : "getTopic", data : {topicId : topicId}};
            const responsegetTopicPosts = await dispatch("callService", getTopicPostsData);

            commit("SET_TOPICPOSTS", [topicId, responsegetTopicPosts.data.posts]);

            return responsegetTopicPosts;
        }
    }
}

export default postStore;