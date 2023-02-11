package agh.ics.oop;

import javafx.application.Platform;

import java.util.Random;
import static java.lang.Math.max;

public class Engine{
    private Integer trustPoints;
    private final Map map;
    private Integer days=1;
    private final Integer daysOfGame;
    private final Integer dayOfMayorSelfiesProblem;
    private Integer dayOfNextProblemToOccur=0;
    private boolean lost=false;
    private boolean won=false;

    public Engine(Integer trustPoints, Integer daysOfGame) {
        this.trustPoints = trustPoints;
        this.daysOfGame=daysOfGame;
        map=new Map();
        generateProblemsAtStart();
        Random generator = new Random();
        dayOfMayorSelfiesProblem=generator.nextInt(daysOfGame);
        updateDayOfNextProblem();
    }
    public Engine(){
        this(3,60);
    }

    public void dayRitual(){
        days+=1;
        if (days>daysOfGame) gameWon();
        map.fightProblems();
        map.removeSolvedProblems(this);
        map.destructProblems(this);
        if (trustPoints<=0) gameOver();
        map.renewHeroesEnergy();
        checkToGenerateMayorSelfiesProblem();
        checkToGenerateProblem();
    }

    private void checkToGenerateMayorSelfiesProblem(){
        MayorSelfies mayorSelfies=new MayorSelfies(days);
        if (days == dayOfMayorSelfiesProblem) map.placeProblemOnMap(mayorSelfies);
    }
    private void checkToGenerateProblem(){
        if (days == dayOfNextProblemToOccur) {
            generateProblem();
            updateDayOfNextProblem();
        }
    }

    public void removeTrustPoints(Integer n){
        trustPoints-=n;
    }

    public void gameOver(){
        lost=true;
    }
    public void gameWon(){
        won=true;
    }
    private void generateProblem(){
        Random generator = new Random();
        IProblem problem;
        if (generator.nextInt(101) <= 85){ //typical problem

            problem= switch (generator.nextInt(3)){
                case 0 -> new Fire(days);
                case 1-> new DetectivePuzzle(days);
                default -> new TechnicalIssue(days);
            };
        }
        else{ //supervillain problem
            problem= new SupervilainProblem(days);
        }
        map.placeProblemOnMap(problem);
    }

    private void generateProblemsAtStart(){
        for (int i = 0; i < 3; i++){
            generateProblem();
        }
    }
    private Integer updateDayOfNextProblem(){
        Random generator = new Random();
        int x=5-(days%5);
        if (generator.nextInt(2)==0){
            dayOfNextProblemToOccur+=max(x-1,1);
        }
        else{dayOfNextProblemToOccur+=x+1;}
        return dayOfNextProblemToOccur;
    }


    public Map getMap(){
        return map;
    }

    public void addTrustPoints(int n) {
        trustPoints+=n;
    }
    public void removeTrustPoint() {
        trustPoints-=1;
    }

    public MoveCoordinates moveHero(HeroType hero, MoveDirection direction) {
        return map.moveHeroOnMap(hero,direction);
    }

    public Integer getDayNumber() {
        return days;
    }

    public boolean isGameWon() {
        return won;
    }
    public boolean isGameLost(){return lost;}

    public Integer getTrustPoints() {
        return trustPoints;
    }

    public IHero getHero(HeroType hero) {
        return map.getHero(hero);
    }
}

