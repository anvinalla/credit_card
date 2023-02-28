package com.lbg.credit.card.karate;

import com.intuit.karate.junit5.Karate;

public class KarateTests {

    @Karate.Test
    public Karate runTest(){
        return Karate.run("addAccountHappyPath").relativeTo(getClass());

    }
}
