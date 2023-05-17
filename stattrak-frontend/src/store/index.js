import { createStore } from "vuex";

export default createStore({
  state: { summonerName: String, creepScores: Object },
  getters: {},
  mutations: {
    SETUP_NEW_GAMECARDVIEW(state, summonerName, creepScores) {
      state.summonerName = summonerName;
      state.creepScores = creepScores;
    },
  },
  actions: {},
  modules: {},
});
