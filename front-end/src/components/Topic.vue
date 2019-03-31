<template>
    <div>
        <button v-on:click="get">Clique aqui para o console.log</button>
        <p>{{msg}}</p>
    </div>
</template>


<script>
import * as Topic from "../services/topic.service.js";

export default {
    name: "Topic",
    data: function(){
        return {msg: ""};
    }, 


    methods: {
        get: function() {
            this.msg = Topic.get();
        } 
    }
}
</script>
