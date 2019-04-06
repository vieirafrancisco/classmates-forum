<template>
    <div>
        <PostItemList/>
    </div>
</template>

<script>
import PostItemList from '../components/post/PostItemList.vue'

export default {
    name : "Posts",
    components : {
        PostItemList
    },

    beforeMount(){
        this.$store.dispatch("getTopicPosts", this.$route.params.topicId)
        .then(response => {
        }).catch(error => {
            alert(JSON.stringify(error));
        })
    }
}
</script>