package com.galvanize;

import java.util.ArrayList;

public class CellPhone{

    private boolean isOnCall = false;
    private String callHistory = "";
    public CallingCard phonesCard;
    private int minutesOnCall = 0;
    private boolean wasCutOff = false;
    ArrayList<String> callHistory2 = new ArrayList<String>();

    CellPhone(CallingCard card){
        this.phonesCard = card;
    }

    public void call(String phoneNumber){
        this.callHistory2.add(phoneNumber);
        this.isOnCall = true;
    }
    public boolean isTalking(){
        return this.isOnCall;
    }
    public void tick(){
        if(phonesCard.getMinutesRemaining() > 0) {
            this.minutesOnCall++;
            this.phonesCard.useMinutes(1);
        }
        else {
            this.wasCutOff = true;
            endCall();
        }
    }
    public void endCall(){
        if(this.minutesOnCall >1){
            if(this.wasCutOff){
                this.callHistory2.add("(cut off at" + this.minutesOnCall + " minutes)");
            }else
            this.callHistory2.add("(" + this.minutesOnCall + " minutes)");
        }else{
            if(this.wasCutOff){
                this.callHistory2.add("(cut off at" + this.minutesOnCall + " minute)");
            }
        this.callHistory2.add("(" + this.minutesOnCall + " minute)");
        }
        this.isOnCall = false;
        this.minutesOnCall = 0;
        this.wasCutOff = false;
    }
    public String getCallHistory(){
        String allHistory = "";
        for(int i=0; i < callHistory2.size(); i++){
            // if its even and not the first number
            if((i+1)%2 == 0 && callHistory2.size() > i+1 ) {
                allHistory += callHistory2.get(i) + ", ";
            }else {
                allHistory += callHistory2.get(i) + " ";
            }
        }
        return allHistory;
    }

}
