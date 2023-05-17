import axios from "axios";

const http = axios.create({
  baseURL: "http://localhost:4000/",
});

export default {
  getCreepScore(summonerName) {
    return http.get(`/creepScore/${summonerName}`);
  },

  getAverageCreepScore(summonerName) {
    return http.get(`/averageCreepScore/${summonerName}`);
  },
};
