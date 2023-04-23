<template>
  <div id="app">
    <header class="fullWidth">
      <h1>LeagueStatTracker</h1>
    </header>
    <main>
      <form>
        <input type="submit" @click.prevent="setSummonerName" />
        <input id="userInputtedSummonerName" type="text" />
      </form>
      <article v-for="creepScore in creepScores" :key="creepScore">
        <gameCard :creepScore="creepScore" />
      </article>
    </main>

    <footer>© James Nelson 2023</footer>
  </div>
</template>

<script>
import gameCard from "./components/GameCard.vue";
import creepScoreService from "./services/CreepScoreService.js";

export default {
  name: "App",

  components: {
    gameCard,
  },
  data() {
    return {
      creepScores: [],
      summonerName: "",
    };
  },

  methods: {
    getCreepScore(summonerName) {
      creepScoreService.getCreepScore(summonerName).then((response) => {
        this.creepScore = response.data;
        console.log(response.data);
      });
    },

    setSummonerName() {
      this.summonerName = document.getElementById(
        "userInputtedSummonerName"
      ).innertext;
    },
  },
};
</script>

<style>
h1 {
  margin: 0px;
}

header {
  color: black;
  background-color: #92a8d1;
  text-align: center;
}

.fullWidth {
  width: 100vw;
}

#app {
  display: grid;
  grid-row: 50px, 1fr, 1em;
}

body {
  margin: 0;
  padding: 0;
}

html {
  height: 100%;
  background-image: linear-gradient(#92a8d1, #ffffff);
}
</style>
