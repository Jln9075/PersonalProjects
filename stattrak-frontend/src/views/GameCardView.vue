<template>
  <div>
    <gameCard />
    <searchBar>Search A New Summoner Name</searchBar>
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
