<template>
    <div>
        Link : <router-link v-bind:to = "url">Ir para</router-link>
        <p>Titulo: {{ topic.description }} </p>
        <p>Autor: {{ topic.authorName }}
        <li v-for = "tag in topic.tags" v-bind:key = "tag.id">{{ tag.name }}</li>
        <p></p>
    </div>
</template>


<script>
export default {
    name: "TopicItem",
    data: function(){
        return {
        };
    }, 

    props : ["topic"],

    methods: {
    },

    computed : {
        url : function(){
            return `/topics/${this.topic.id}/posts`
        }
    }
}
</script>
