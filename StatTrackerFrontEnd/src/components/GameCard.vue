<template>
  <div id="gameCard">
    <p>{{ creepScore.userAddedSummonerName }}</p>

    <p>{{ creepScore.creepScoreThisMatch }}</p>
  </div>
</template>

<script>
export default {
  name: "gameCard",
  props: {
    creepScore: {
      userAddedSummonerName: String,
      creepScoreThisMatch: Number,
    },
  },
};
</script>

<style scoped></style>
