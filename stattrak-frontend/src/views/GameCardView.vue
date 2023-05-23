<template>
  <div>
    <div id="searchBar">
      <searchBar>Search A New Summoner Name</searchBar>
    </div>
    <div
      v-for="summonerObject in this.$store.state.gameCardData[0]"
      :key="summonerObject"
    >
      <gameCard :summonerObject="summonerObject" />
    </div>
  </div>
</template>

<script>
import searchBar from "@/components/SearchBar.vue";
import gameCard from "@/components/GameCard.vue";
export default {
  components: {
    searchBar,
    gameCard,
  },
};
</script>

<style scoped>
#searchBar {
  height: 200px;
  position: relative;
  padding-left: 40%;
  padding-bottom: 20px;
}
</style>
