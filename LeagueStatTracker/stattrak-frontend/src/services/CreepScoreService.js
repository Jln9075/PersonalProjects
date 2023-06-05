import axios from "axios";

const http = axios.create({
  baseURL: "http://localhost:4000/",
});

export default {
  getCreepScore(summonerName, searchQuantity) {
    return http.get(`/creepScore/${summonerName}/${searchQuantity}`);
  },
};
