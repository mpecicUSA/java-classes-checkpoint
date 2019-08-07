package com.galvanize;

public class CallingCard {
    //constructor sets up a new calling card with input value of cost per minute
    CallingCard(int costCentsPerMinute){
        this.costCentsPerMinute = costCentsPerMinute;
    }
    //add dollars to your card
    public void addDollars(int dollars){
        this.centsBalance += dollars*100;
    }
    //use minutes from your card
    public void useMinutes(int minutes){
        this.centsBalance -= minutes*this.costCentsPerMinute;
    }
    //obtain data on how much your cost per minute is
    public int getCostPerMinute(){
        return this.costCentsPerMinute;
    }
    // obtain data on how much money you have left on your prepaid card
    public int getBalance(){
        return this.centsBalance/100;
    }
    // obtain data on how many minutes you have left on your prepaid card
    public int getMinutesRemaining(){
        if(centsBalance/costCentsPerMinute < 0) return 0;
        return centsBalance/costCentsPerMinute;
    }


    private int costCentsPerMinute;
    private int centsBalance;
}
