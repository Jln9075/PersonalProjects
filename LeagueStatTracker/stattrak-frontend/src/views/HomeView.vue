<template>
  <div class="home">
    <searchBar>Search My Summoner Name</searchBar>
  </div>
</template>

<script>
import searchBar from "@/components/SearchBar.vue";

export default {
  name: "HomeView",
  components: {
    searchBar,
  },
};
</script>

<style scoped>
.home {
  height: 200px;
  position: relative;
  padding-left: 40%;
  padding-bottom: 50px;
}
searchBar {
  margin: 0;
  position: absolute;
  top: 50%;
}
</style>
