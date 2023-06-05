package com.jnelson.SpringBoot.services;

import com.jnelson.SpringBoot.dao.SummonerNameDao;
import com.jnelson.SpringBoot.model.SummonerName;
import org.springframework.stereotype.Component;

@Component
public class SummonerNameService {

    SummonerNameDao summonerNameDao = new SummonerNameDao();

    public SummonerNameService() {
    }

    public SummonerNameService(SummonerNameDao summonerNameDao) {
        this.summonerNameDao = summonerNameDao;
    }

    public SummonerName stringToSummonerName(String userInputtedName){
        SummonerName summonerName = summonerNameDao.getSummonerName(userInputtedName);

        return summonerName;
    }
}
