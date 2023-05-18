<template>
  <div id="gameCard">
    <p>{{ summonerObject.summonerName }}</p>
    <p>{{ summonerObject.totalCreepScore }}</p>
    <p>{{ summonerObject.championName }}</p>
    <p>{{ summonerObject.individualPosition }}</p>
    <p>{{ summonerObject.gameDuration }}</p>
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
  background-color: white;
  width: 150px;
  height: auto;
  padding-left: 10px;
  margin: 20px;
  border: 1px black solid;
}
</style>
