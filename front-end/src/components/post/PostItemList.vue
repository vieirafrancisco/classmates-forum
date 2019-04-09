<template>
    <v-container>
        <v-data-iterator :items="posts" :rows-per-page-items="rowsPerPageItems" :pagination.sync="pagination" content-tag="v-layout" row wrap>
            
            <template v-slot:header>
                <v-toolbar class="mb-2" color="blue-grey" dark flat>
                    <v-toolbar-title><strong>Postagens</strong></v-toolbar-title>
                </v-toolbar>
            </template>

            <template v-slot:item="props">
                <v-flex xs12 sm6 md4 lg4>
                    <PostItem v-bind:key = "props.item.id" v-bind:post = "props.item" />
                </v-flex>
            </template>

        </v-data-iterator>
    </v-container>
    <!-- <div>
        <p v-if = "loading"> loading </p>
        <PostItem v-for = "post in posts" v-bind:key = "post.id" v-bind:post = "post" />
    </div> -->
</template>

<script>
import PostItem from "./PostItem"

export default {
    name: "PostItemList",
    data: function(){
        return{
            rowsPerPageItems: [4, 8, 12],
            pagination: {
                rowsPerPage: 8
            },
        }
    },

    components: {
        PostItem
    },
    computed: {
        posts() {
            if(this.$store.state.postStore.currentTopicPosts != null){
                return this.$store.state.postStore.currentTopicPosts;
            }
            
            return [];
        },

        loading() {
            return this.$store.state.topicStore.loading;
        }
    },
}
</script>
