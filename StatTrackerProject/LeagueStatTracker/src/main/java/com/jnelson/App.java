package com.jnelson;

import com.jnelson.classes.MatchData;
import com.jnelson.classes.MatchHistory;
import com.jnelson.classes.SummonerName;
import com.jnelson.dao.MatchDataDao;
import com.jnelson.dao.MatchHistoryDao;
import com.jnelson.dao.SummonerNameDao;
import com.jnelson.services.ConsolePrintService;
import com.jnelson.services.CreepScoreService;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ConsolePrintService consolePrintService = new ConsolePrintService();
        SummonerNameDao summonerNameDao = new SummonerNameDao();
        SummonerName summonerName;
        MatchData matchData;
        MatchData[] matchDataArray;
        MatchDataDao matchDataDao = new MatchDataDao();
        MatchHistory[] matchHistoryArray;
        MatchHistoryDao matchHistoryDao = new MatchHistoryDao();
        DecimalFormat dcf = new DecimalFormat("###.##");
        CreepScoreService creepScoreService = new CreepScoreService();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input your summoner name: ");


        summonerName = summonerNameDao.getSummonerName(keyboard.next());

        String menuSelector = "-1";
        try{
            while(!menuSelector.equals("0")) {
                System.out.println();
                consolePrintService.printMenu();
                menuSelector = keyboard.next();

                //Creep Score for most recent match
                if (menuSelector.equals("1")) {
                    System.out.println();
                    System.out.println("Your total creep score last match was: " + creepScoreService.getCreepScoreForUser(summonerName));
                }
                //Creep Score / Minute for most recent match
                else if (menuSelector.equals("2")) {
                    System.out.println();
                    System.out.println("Your Creep Score / Minute last match was: " + dcf.format(creepScoreService.getCreepScorePerMinuteForUser(summonerName)));
                }
                //Creep Score / Minute average over last X matches
                else if (menuSelector.equals("3")) {
                    double totalCreepScore = 0.00;
                    int amountOfMatches;
                    System.out.println("How many matches are you looking for?");
                    amountOfMatches = Integer.parseInt(keyboard.next());
                    totalCreepScore += creepScoreService.getCspmForXMatches(summonerName, amountOfMatches);
                    System.out.println();
                    System.out.println("Your average Creep Score / Minute over your last " + amountOfMatches + " matches was: " + dcf.format(totalCreepScore));
                }
            }

        }
        catch(Exception e ){

        }

    }
}







