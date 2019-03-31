<template>
    <div>
        <p v-if = "loading"> loading </p>
        <TopicItem v-for = "topic in topics" v-bind:key = "topic.id" v-bind:topic = "topic" />
    </div>
</template>

<script>
import TopicItem from "./TopicItem"

export default {
    name : "TopicItemList",
    data : function(){
        return {
            
        }
    },
    components : {
        TopicItem
    },
    computed : {
        topics(){
            return this.$store.state.topicStore.topics;
        },

        loading(){
            return this.$store.state.topicStore.loading;
        }
    }
}
</script>