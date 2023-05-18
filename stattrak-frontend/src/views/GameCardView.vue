<template>
  <div>
    <searchBar>Search A New Summoner Name</searchBar>
    <div
      v-for="summonerObject in this.$store.state.gameCardData"
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

<style scoped></style>
