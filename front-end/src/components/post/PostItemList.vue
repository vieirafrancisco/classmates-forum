<template>
    <div>
        <p v-if = "loading"> loading </p>
        <PostItem v-for = "post in posts" v-bind:key = "post.id" v-bind:post = "post" />
    </div>
</template>

<script>
import PostItem from "./PostItem"

export default {
    name: "PostItemList",
    data: function(){
        return{
        }
    },

    components: {
        PostItem
    },
    computed: {
        posts() {
            return this.$store.state.postStore.currentTopicPosts;
        },

        loading() {
            return this.$store.state.topicStore.loading;
        }
    }
}
</script>
