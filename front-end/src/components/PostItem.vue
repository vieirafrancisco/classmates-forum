<template>
    <div>
        <p>Titulo: {{post.name}} </p>
        <p>Autor: {{post.authorName}}</p>
        <p>{{post.content}}</p>
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
    }
}
</script>
