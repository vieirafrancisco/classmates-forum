<template>
    <div>
        <li v-for="error in errors" v-bind:key = "error.message">
            {{ error.message }}
        </li>
        <button>Criar topico</button>
        <TopicItemList/>
    </div>
</template>

<script>
import TopicItemList from "../components/TopicItemList.vue"
import TopicCreate from "../components/TopicCreate.vue"

export default {
    name : "Topic",
    data : function(){
        return {
            errors : []
        }
    },
    components : {
        TopicItemList,
        TopicCreate
    },

    beforeMount(){
        this.$store.dispatch("getTopics")
        .then(response => {
            
        }).catch(error => {
            alert(error);
        });
    }
} 
</script>
