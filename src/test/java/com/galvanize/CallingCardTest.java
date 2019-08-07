package com.galvanize;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CallingCardTest {


    @Test
    public void doesTheCardHaveAStartingCost(){
        CallingCard firstCard = new CallingCard(10);

        int costPerMinute = firstCard.getCostPerMinute();

        assertEquals(10, costPerMinute);

    }

    @Test
    public void canYouAddABalanceToTheCard(){
        CallingCard firstCard = new CallingCard(10);

        firstCard.addDollars(100);

        int balance = firstCard.getBalance();


        assertEquals(100, balance);
    }

    @Test
    public void canYouCheckMinutesRemaining(){
        CallingCard firstCard = new CallingCard(10);

        firstCard.addDollars(5);

        int minutesRemaining = firstCard.getMinutesRemaining();

        assertEquals(50, minutesRemaining);
    }

    @Test
    public void doesUsingMinutesReduceMinutesRemaining(){
        CallingCard firstCard = new CallingCard(100);

        firstCard.addDollars(5);

        firstCard.useMinutes(3);

        int minutesRemaining = firstCard.getMinutesRemaining();

        assertEquals(2, minutesRemaining);
    }
    @Test
    public void doesUsingAllYourMinutesBringMinutesToZero(){
        CallingCard firstCard = new CallingCard(100);

        firstCard.addDollars(5);

        firstCard.useMinutes(6);

        int minutesRemaining = firstCard.getMinutesRemaining();

        assertEquals(0, minutesRemaining);
    }


    @Test
    public void doesGetCostPerMinuteWork() {
        CallingCard firstCard = new CallingCard(10);

        assertEquals(10, firstCard.getCostPerMinute());
    }

    @Test
    public void doesGetBalanceWork() {
        CallingCard firstCard = new CallingCard(10);

        firstCard.addDollars(2);

        int balance = firstCard.getBalance();

        assertEquals(2, balance);
    }
}
