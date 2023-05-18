import { createStore } from "vuex";

export default createStore({
  state: {
    gameCardData: [],
  },
  getters: {},
  mutations: {
    SETUP_NEW_GAMECARDVIEW(state, summonerObject) {
      state.gameCardData = [];
      state.gameCardData.push(summonerObject);
    },
  },
  actions: {},
  modules: {},
});
