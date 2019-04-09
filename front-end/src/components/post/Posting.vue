<template>
    <div>
        <p>{{ post.name }}</p>
        <p>{{ post.content }}</p>
    </div>
</template>

<script>
export default {
    name : "Posting",
    props : ["post"],
    methods : {

    }

}

</script>
