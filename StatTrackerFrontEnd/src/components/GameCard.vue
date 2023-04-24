<template>
  <div id="gameCard">
    {{ creepScores.userAddedSummonerName }}
    {{ creepScores.creepScoreThisMatch }}
  </div>
</template>

<script>
export default {
  name: "gameCard",
  props: {
    creepScores: Object,
  },
};
</script>

<style scoped></style>
