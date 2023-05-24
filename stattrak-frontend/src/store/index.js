import { createStore } from "vuex";

export default createStore({
  state: {
    gameCardData: [],
  },
  getters: {},
  mutations: {
    SETUP_NEW_GAMECARDVIEW(state, returnData) {
      console.log(state, returnData);
      state.gameCardData = returnData;
      //state.gameCardData.push(returnData);
    },
  },
  actions: {},
  modules: {},
});
