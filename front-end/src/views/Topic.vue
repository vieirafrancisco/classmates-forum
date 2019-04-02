<template>
    <div>
        <li v-for="error in errors" v-bind:key = "error.message">
            {{ error.message }}
        </li>
        <router-link to="/topic/create">Criar topico</router-link>
        <TopicItemList/>
    </div>
</template>

<script>
import TopicItemList from "../components/topic/TopicItemList.vue"

export default {
    name : "Topic",
    data : function(){
        return {
            TopicCreate : false,
            errors : []
        }
    },
    components : {
        TopicItemList,
    },
    beforeMount(){
        this.$store.dispatch("getTopics")
        .then(response => {
            
        }).catch(error => {
            
        });
    }
} 
</script>
