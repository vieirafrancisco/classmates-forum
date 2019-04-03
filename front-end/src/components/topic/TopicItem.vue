<template>
    <v-layout>
        <v-hover>
            <v-card
                slot-scope="{ hover }"
                :class="`elevation-${hover ? 12 : 2}`"
                class="mx-auto white--text"
                color="blue-grey darken-2"
                width=300px>
                <v-layout>
                    <v-card-title primary-title>
                        <div>
                            <div class="headline">{{topic.description}}</div>
                            <span>Autor: {{topic.authorName}}</span>
                        </div>
                        <div>
                            <v-chip v-for="tag in topic.tags" v-bind:key="tag.id" label color="white" text-color="pink">
                                <v-icon left>label</v-icon> {{tag.name}}
                            </v-chip>
                        </div>
                    </v-card-title>
                </v-layout>
                <v-divider light></v-divider>
                <v-card-actions>
                    <v-btn flat dark>Explore topic</v-btn>
                </v-card-actions>
            </v-card>
        </v-hover>
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
