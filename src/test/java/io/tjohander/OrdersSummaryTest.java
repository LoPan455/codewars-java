package io.tjohander;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrdersSummaryTest {

    @Test
    public void test1() {
        String l = "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B";
        assertEquals("Buy: 29499 Sell: 0",
                OrdersSummary.balanceStatements(l));
        String z = "GOOG 300 542.0 B, AAPL 50 145.0 B, CSCO 250.0 29 B, GOOG 200 580.0 S";
        assertEquals("Buy: 169850 Sell: 116000", OrdersSummary.balanceStatements(z));
    }
}
