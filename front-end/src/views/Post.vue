<template> 
    <div>
        <Posting v-bind:post = "post"/>
    </div>
</template>

<script>
import Posting from '../components/post/Posting.vue'

export default {
    name : "Post",
    components : {
        Posting
    },
    methods : {

    },
    computed : {
        post : function(){
            return this.$store.state.postStore.currentPost;
        }
    },
    beforeMount(){
        this.$store.dispatch("getPost", this.$route.params.postId)
        .then(response => {
            
        }).catch(error => {
            
        })
    }
}
</script>