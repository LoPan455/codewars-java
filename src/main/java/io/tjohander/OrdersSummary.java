package io.tjohander;

/*
https://www.codewars.com/kata/ease-the-stockbroker/train/java
 */
public class OrdersSummary {

    public static String balanceStatements(String lst) {
        // your code
        double totalBought = 0.0;
        double totalSold = 0.0;
        int badlyFormattedOrdersCount = 0;
        StringBuilder badlyFormattedOrdersList = new StringBuilder();

        if (lst != null) {
            String[] orders = lst.split(",\\s?");
            for (String order : orders) {
                String[] orderElements = order.split(" ");
                if (validate(orderElements)) {
                    double transactionValue = Integer.parseInt(orderElements[1]) * Double.parseDouble(orderElements[2]);
                    if (orderElements[3].equals("B")) {
                        totalBought += transactionValue;
                    }
                    if (orderElements[3].equals("S")) {
                        totalSold += transactionValue;
                    }
                } else {
                    badlyFormattedOrdersCount++;
                    badlyFormattedOrdersList.append(order).append(";");
                }
            }
        }
        String incorrectOrders = badlyFormattedOrdersCount > 0 ? "; Badly formed " + badlyFormattedOrdersCount + ": " + badlyFormattedOrdersList : "";
        return "Buy: " + String.format("%.0f", totalBought) + " Sell: " + String.format("%.0f", totalSold) + incorrectOrders;
    }

    private static boolean validate(String[] elements) {
        boolean result = true;

        if (elements.length != 4) result = false;
        else if (elements[1].contains(".") || elements[1].contains("[^\\d]")) result = false;
        else if ((!elements[2].contains(".")) || elements[2].contains("[^\\d]")) result = false;
        else if (!(elements[3].equals("B") || elements[3].equals("S"))) result = false;

        return result;
    }
}
