package com.galvanize;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellPhoneTest {

    @Test
    public void callUpdatesOnCallToTrue() {
        CallingCard card1 = new CallingCard(10);
        card1.addDollars(5);
        CellPhone myPhone = new CellPhone(card1);

        myPhone.call("555-5555");


        assertEquals(true, myPhone.isTalking());
    }

    @Test
    public void callsThatTickReduceMinutes() {
        CallingCard card1 = new CallingCard(100);
        card1.addDollars(5);
        CellPhone myPhone = new CellPhone(card1);

        myPhone.call("555-5555");
        myPhone.tick();
        myPhone.tick();


        assertEquals(3, card1.getMinutesRemaining());
    }

    @Test
    public void endCallUpdatesOnCallToFalse(){
        CallingCard card1 = new CallingCard(100);
        card1.addDollars(5);
        CellPhone myPhone = new CellPhone(card1);

        myPhone.call("555-5555");
        myPhone.endCall();

        assertEquals(false, myPhone.isTalking());

    }


    @Test
    public void doesGetCallHistoryReturnPhoneNumbersAndTimeOnCall() {
        CallingCard card1 = new CallingCard(100);
        card1.addDollars(5);
        CellPhone myPhone = new CellPhone(card1);

        myPhone.call("555-5555");
        myPhone.tick();
        myPhone.endCall();
        assertEquals("555-5555 (1 minute) ", myPhone.getCallHistory());



        myPhone.call("555-5557");
        myPhone.tick();
        myPhone.tick();
        myPhone.endCall();

//        System.out.println(myPhone.getCallHistory());

        assertEquals("555-5555 (1 minute), 555-5557 (2 minutes) ", myPhone.getCallHistory());
    }
}