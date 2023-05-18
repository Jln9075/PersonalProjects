<template>
  <div id="gameCard">
    <p>{{ summonerObject.summonerName }}</p>
    <p>{{ summonerObject.totalCreepScore }}</p>
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
  width: 200px;
  height: 100px;
}
</style>
