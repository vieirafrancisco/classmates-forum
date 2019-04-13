<template>
    <v-container>
        <v-data-iterator :items="topics" :rows-per-page-items="rowsPerPageItems" :pagination.sync="pagination" content-tag="v-layout" row wrap>
            
            <template v-slot:header>
                <v-toolbar class="mb-2" color="blue-grey" dark flat>
                    <v-toolbar-title><strong>Tópicos</strong></v-toolbar-title>
                </v-toolbar>
            </template>

            <template v-slot:item="props">
                <v-flex xs12 sm6 md4 lg4>
                    <TopicItem v-bind:key = "props.item.id" v-bind:topic = "props.item" />
                </v-flex>
            </template>

        </v-data-iterator>
    </v-container>
    <!-- <div>
        <p v-if = "loading"> loading </p>
        <TopicItem v-for = "topic in topics" v-bind:key = "topic.id" v-bind:topic = "topic" />
    </div> -->
</template>

<script>
import TopicItem from "./TopicItem"

export default {
    name : "TopicItemList",
    data : function(){
        return {
            rowsPerPageItems: [4, 8, 12],
            pagination: {
                rowsPerPage: 8
            },
        }
    },
    components : {
        TopicItem
    },
    computed : {
        topics(){
            return this.$store.state.topicStore.topics;
        },

        loading(){
            return this.$store.state.topicStore.loading;
        }
    }
}
</script>