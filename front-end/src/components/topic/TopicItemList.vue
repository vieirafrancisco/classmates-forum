<template>
<v-data-iterator
      :items="topics"
      :rows-per-page-items="rowsPerPageItems"
      :pagination.sync="pagination"
      content-tag="v-layout"
      row
      wrap
    >
      <template v-slot:item="props">
        <v-flex
          xs12
          sm6
          md4
          lg3
        >
            <TopicItem v-bind:key = "props.item.id" v-bind:topic = "props.item" />
        </v-flex>
      </template>
    </v-data-iterator>

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
                rowsPerPage: 4
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