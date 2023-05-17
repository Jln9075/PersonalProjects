<template>
  <form>
    <input
      type="text"
      id="userInputtedSummonerName"
      v-model="summonerName"
      class="roundedCorners"
    /><br />
    <RouterLink to="/stats"
      ><button class="fancyButton" @click="getCreepScore()">
        <slot></slot></button
    ></RouterLink>
  </form>
</template>

<script>
import creepScoreService from "@/services/CreepScoreService.js";
export default {
  name: "searchBar",
  data() {
    return {
      creepScores: {
        userAddedSummonerName: String,
        creepScoreThisMatch: Number,
      },
      summonerName: "",
    };
  },
  methods: {
    getCreepScore() {
      creepScoreService
        .getCreepScore(this.summonerName)
        .then((response) => {
          this.creepScores = response.data;
          this.$store.commit("SETUP_NEW_GAMECARDVIEW");
        })
        .catch((error) => alert(error.message));
    },
  },
};
</script>

<style scoped>
form {
  margin: 0;
  position: absolute;
  top: 50%;
}
.roundedCorners {
  border-radius: 25px;
  border: 3px solid #024c69;
  padding: 20px;
  width: 375px;
  height: 10px;
  margin-bottom: 5px;
}
.fancyButton {
  width: 300px;
  height: 5px;
  padding-bottom: 25px;
  padding-top: 15px;
  margin-left: 59px;
}
</style>
