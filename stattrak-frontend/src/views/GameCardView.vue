<template>
  <div>
    <div id="searchBar">
      <searchBar>Search A New Summoner Name</searchBar>
    </div>
    <article>
      <div
        class="flexbox"
        v-for="summonerObject in this.$store.state.gameCardData"
        :key="summonerObject"
      >
        <gameCard class="gameCard" :summonerObject="summonerObject" />
      </div>
    </article>
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
.gameCard {
  width: fit-content;
}
.flexbox {
  display: inline-flex;
}
</style>
