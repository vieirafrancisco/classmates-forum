<template>
    <div>
        <p>Titulo topico :</p>
        <input v-model = "titulo">
        <p>Tags :</p>
        <input v-model = "tags_text">
        <button v-on:click = "createTopic">Criar</button>
    </div>
</template>

<script>
export default {
    name : "TopicCreate",
    data : function(){
        return {
            titulo : "",
            tags_text : [],
            errors : []
        }
    },
    computed : {
        tags : function(tags_text){
            return this.tags_text.split(",").map(tagName => {
                return {name : tagName};
            });
        }
    },
    methods : {
        createTopic(){
            this.$store.dispatch("createTopic", {
                description : this.titulo,
                tags : this.tags
            }).then(response => {
                alert(response);
            }).catch(error => {
                alert(JSON.stringify(error));
                this.errors.push(error);
            });
        }
    }
}
</script>