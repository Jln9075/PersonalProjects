<template>
  <form>
    <input
      type="text"
      id="userInputtedSummonerName"
      v-model="userInputtedName"
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
      returnData: [
        {
          summonerName: "",
          totalCreepScore: 0,
          championName: "",
          individualPosition: "",
          gameDuration: "",
        },
      ],
      userInputtedName: "",
    };
  },
  methods: {
    getCreepScore() {
      creepScoreService
        .getCreepScore(this.userInputtedName)
        .then((response) => {
          response.data.forEach((element) => {
            this.returnData.push(element);
          });
          console.log(response.data);
          this.$store.commit("SETUP_NEW_GAMECARDVIEW", this.returnData);
        })
        .catch((error) => alert(error.message));
    },
  },
};
</script>

<style scoped>
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
