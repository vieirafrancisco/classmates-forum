<template>
    <div>
        Link : <router-link v-bind:to = "url">Ir para</router-link>
        <p>Titulo: {{post.name}} </p>
        <p>Autor: Annonimus:|</p>
        <p>{{post.content}}</p>
        <p></p>
    </div>
</template>


<script>
export default {
    name: "PostItem",
    data: function(){
        return {
        };
    },

    props: ["post"],

    methods: {
    },

    computed : {
        url : function(){
            return `/topics/${this.$route.params.topicId}/posts/${this.post.id}`
        }
    }
}
</script>
