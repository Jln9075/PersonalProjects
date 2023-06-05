<template>
  <form>
    <input
      type="text"
      id="userInputtedSummonerName"
      v-model="userInputtedName"
      class="roundedCorners"
    />
    <input
      type="number"
      id="quantity"
      min="1"
      max="10"
      v-model="searchQuantity"
    />
    <br />
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
      returnData: [],
      userInputtedName: "",
      searchQuantity: 1,
    };
  },
  methods: {
    getCreepScore() {
      this.returnData = [];

      creepScoreService
        .getCreepScore(this.userInputtedName, this.searchQuantity)
        .then((response) => {
          response.data.forEach((element) => {
            this.returnData.push(element);
          });
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

#quantity {
  margin-left: 10px;
}
.fancyButton {
  width: 300px;
  height: 5px;
  padding-bottom: 25px;
  padding-top: 15px;
  margin-left: 59px;
}
</style>
