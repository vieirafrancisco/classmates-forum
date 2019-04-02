<template>
    
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
            return this.$store.state.topicStore.posts;
        },

        loading() {
            return this.$store.state.topicStore.loading;
        }
    }
}
</script>
