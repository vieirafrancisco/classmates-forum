<template>
    <div>
        <p>Titulo: {{ topic.description }} </p>
        <p>Autor: {{ topic.authorName }}
        <li v-for = "tag in topic.tags">{{ tag.name }}</li>
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
    }
}
</script>
