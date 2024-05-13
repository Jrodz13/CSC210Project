package org.example.chapter12;

public class PizzaStore {
    private final static double tax = 0.08;
    private static String [][] userPasswd = {{"Username", "Password"},{"Kylian", "50"}};
    private static String [] items = {"Regular","Pepperoni","Chicken","Cheese"};
    private static int [] prices = {17,20,22,19};
    public static String getUsername()
    {
       return userPasswd[1][0];
    }
    public static String getPasswd()
    {
        return userPasswd[1][1];
    }

    public static int getPrice(String item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equalsIgnoreCase(item)) {
                return prices[i];
            }
        }
        return -1; // Item not found
    }

    public static String[] getItems() {
        return items;
    }
    public static double calculateCost(int[] quantities)
    {
        double totalCost = 0;
        for (int i = 0; i < quantities.length; i++)
        {
            totalCost += quantities[i] * prices[i];
        }
        return totalCost;
    }

    public static double calculateTaxes(double cost)
    {
        return cost * tax;
    }

    public static double calculateTotalCost(double cost)
    {
        return cost + (cost * tax);
    }
}

