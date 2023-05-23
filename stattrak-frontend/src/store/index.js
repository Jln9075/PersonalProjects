import { createStore } from "vuex";

export default createStore({
  state: {
    //TODO write program to allow for multiple pieces of returnData to be accepted
    gameCardData: [],
  },
  getters: {},
  mutations: {
    SETUP_NEW_GAMECARDVIEW(state, returnData) {
      state.gameCardData = [];
      state.gameCardData.push(returnData);
    },
  },
  actions: {},
  modules: {},
});
