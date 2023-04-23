<template>
    <div id="gameCard">
        {{ creepScore }}
    </div>
</template>

<script>
export default {
  name: 'gameCard',
props: {
    creepScore: Number
}
}

</script>

<style scoped>

</style>