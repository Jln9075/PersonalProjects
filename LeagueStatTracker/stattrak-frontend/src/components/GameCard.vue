<template>
  <div id="gameCard">
    <p>Name: {{ summonerObject.summonerName }}</p>
    <p>Total Creep Score: {{ summonerObject.totalCreepScore }}</p>
    <p>Champion: {{ summonerObject.championName }}</p>
    <p id="position">Position: {{ summonerObject.individualPosition }}</p>
    <p>Game Length: {{ summonerObject.gameDuration }}</p>
  </div>
</template>

<script>
export default {
  props: { summonerObject: Object },
  name: "gameCard",
  data() {},
};
</script>

<style scoped>
#gameCard {
  background-color: rgb(161, 187, 236);
  width: 200px;
  height: auto;
  padding-left: 10px;
  margin: 20px;
  border: 3px rgb(75, 56, 3) solid;
}
</style>
