<template>
    <v-layout fill-height class="element-padding">
        <v-card
            class="mx-auto blue-grey--text"
            color="#f2f5f7"
            width="100%"
            hover>

            <v-layout row wrap>
                <v-flex xs12>
                    <v-card-title primary-title>
                        <div>
                            <div class="headline">{{post.name}}</div>
                        </div>
                    </v-card-title>
                </v-flex>
            </v-layout>
            
            <v-divider light></v-divider>
            <v-card-actions>
                <v-btn flat @click="$router.push(url)" class="blue-grey">Explore post</v-btn>
            </v-card-actions>

        </v-card>
    </v-layout>
        <!-- Link : <router-link v-bind:to = "url">Ir para</router-link>
        <p>Titulo: {{ topic.description }} </p>
        <p>Autor: {{ topic.authorName }}
        <li v-for = "tag in topic.tags" v-bind:key = "tag.id">{{ tag.name }}</li>
        <p></p> -->
</template>


<script>
export default {
    name: "TopicItem",
    data: function(){
        return {
        };
    }, 

    props : ["post"],

    methods: {
    },

    computed : {
        url : function(){
            return `/topics/${this.$route.params.topicId}/posts/${this.post.id}`
        }
    }
}
</script>

