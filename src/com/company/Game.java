package com.company;

import java.util.Random;

public class Game {

    private static int[] score = new int[21];
    public static int scoreGame(int scoreFirst,int scoreSec){

        int finalScore =0;
        boolean isStrike = false;
        boolean isSpare = false;
        int scoreRound = 0;

        int i;
        for(i = 0; i<10; i++) { //10 rund
//             scoreFirst =rollBall(0);
//             scoreSec = rollBall(scoreFirst);


            score[i] = scoreFirst;
            score[i+1] = scoreSec;
            if(isSpare){
                finalScore+=scoreFirst;
                isSpare = false;
                isStrike = false;
            }
            if(isStrike){
                finalScore+=10+scoreFirst+scoreSec;
                isStrike = false;
                isSpare = false;
            }

            if(checkMax(scoreFirst)) { //jesli 10
                System.out.println("\t Strike!");
                isStrike = true;
                scoreRound = score[i] + score[i+1];
                System.out.println("i: "+i);
            }
            else{ //inne niz 10
                if(checkMax(scoreFirst+scoreSec)){ //suma z dwoch to 10
                    System.out.println("\t Spare!");

                    isSpare = true;
                    scoreRound = score[i] + score[i+1];

                }
                else{

                    scoreRound = score[i] + score[i+1];

                }
            }
            if(score[9]==10 && isStrike){
                scoreRound += 10+score[i] + score[i+1];
            }
            if(checkMax(score[9]+score[8]) && isSpare){
                scoreRound +=score[i];
            }
            System.out.println("Wynik rundy: "+ scoreRound);
            finalScore+=scoreRound;
            System.out.println("Wynik cały: "+finalScore);
            System.out.println();
        }
        return finalScore;
    }

    public static int rollBall(int zbite){ // losuje ile ma byc zbitych

        int bound = 11-zbite;
        Random random = new Random();
        int roll = random.nextInt(bound);
        System.out.println("Wyrzucono: "+roll);
        return roll;
    }
    public static boolean checkMax(int score){
        if(score==10){
            return true;
        }
        return false;
    }
}
