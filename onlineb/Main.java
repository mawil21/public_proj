import java.util.*;
public class Main {

    public static ArrayList<Store> store = new ArrayList<Store>();
    public static int buyIn = -300;
    public static int newIn = -1;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Store item0 = new Store("Special", 20, 0.1, 1.0);
        Store item1 = new Store("Soda", 20, 0.2, 2.0);
        Store item2 = new Store("Soup", 20, 0.3, 3.0);
        Store item3 = new Store("Beef", 20, 0.4, 4.0);
        Store item4 = new Store("Candy", 20, 0.5, 5.0);
        Store item5 = new Store("Hot Balls", 20, 0.6, 6.0);
        Store item6 = new Store("Cheeros", 20, 0.7, 7.0);
        Store item7 = new Store("Flammin' Pizza", 20, 0.8, 8.0);
        Store item8 = new Store("Veggies", 20, 0.9, 9.0);
        Store item9 = new Store("Water", 20, 1.0, 10.0);

        store.add(item0);
        store.add(item1);
        store.add(item2);
        store.add(item3);
        store.add(item4);
        store.add(item5);
        store.add(item6);
        store.add(item7);
        store.add(item8);
        store.add(item9);
        boolean everything = true;
        System.out.println("\nWelcome to the BBC Restaurant!");
        while(everything) {
            choice();
            int choice = input.nextInt();
            System.out.println();
            if (choice == 1) {
                System.out.println("Welcome! What would you like from our menu? \n");
                boolean position = true;
                while (position) {
                    display2();
                    String buy = "";
                    boolean purchase = true;
                    while (purchase) {
                        System.out.print("What would you like to buy? ");
                        buy = input.next();
                        for (int i = 0; i < store.size(); i++) {
                            if (buy.equals(store.get(i).getName())) {
                                buyIn = i;
                            }
                        }
                        if (buyIn < 0 || store.get(buyIn).getInventory() == 0) {
                            System.out.println("Sorry we don't sell that item");
                        } else {
                            purchase = false;
                        }
                    }

                    boolean inStock = true;
                    while (inStock) {
                        System.out.print("How many would you like? ");
                        int quantity = input.nextInt();
                        if (quantity > store.get(buyIn).getInventory()) {
                            System.out.println("We do not have that many " + store.get(buyIn).getName() + "!");
                        } else {
                            store.get(buyIn).buy(quantity);
                            System.out.println();
                            inStock = false;
                        }
                    }
                    input.nextLine();
                    System.out.print("Would you like to buy anything else? (yes/no) ");
                    String j = input.nextLine();
                    if (j.equals("yes") || j.equals("Yes")) {
                        System.out.println();
                    } else {
                        position = false;
                        System.out.println();
                        System.out.println("Thank you for dining at BBC Restaurant.");
                        System.out.println("TOTAL:\t$" + Store.getReceipt() + "0\n");
                        Store.setReceipt();
                    }
                }
                recap();
                System.out.println();
            } else if (choice == 2) {

                System.out.println("You have sold $" + Store.getTotalRevenue() + "0 worth of items.");
                System.out.println("You have made $" + Store.getProfit() + "0 in profit.");
                System.out.println();
                System.out.println("ITEM\t\t\tPRICE\tCOST\tQTY \tSOLD");
                for (int i = 0; i < store.size(); i++) {
                    String space = "";
                    if (store.get(i).getName().length() < 4) {
                        space = "\t\t\t\t";
                    } else if (store.get(i).getName().length() < 8) {
                        space = "\t\t\t";
                    } else if (store.get(i).getName().length() < 12 ){
                        space = "\t\t";
                    } else {
                        space = "\t";
                    }
                    System.out.println(store.get(i).getName() + space + "$" + store.get(i).getPrice() + "0\t$" + store.get(i).getCost() + "0\t" + store.get(i).getInventory() + "\t\t" + store.get(i).getQuantitySold());
                }
                System.out.println();
            } else if (choice == 3) {
                restocking();
            } else if (choice == 4) {
                System.out.println("ITEM\t\t\tPRICE\tCOST\tQTY \tSOLD");
                for (int i = 0; i < store.size(); i++) {
                    String space = "";
                    if (store.get(i).getName().length() < 4) {
                        space = "\t\t\t\t";
                    } else if (store.get(i).getName().length() < 8) {
                        space = "\t\t\t";
                    } else if (store.get(i).getName().length() < 12 ){
                        space = "\t\t";
                    } else {
                        space = "\t";
                    }
                    System.out.println(store.get(i).getName() + space + "$" + store.get(i).getPrice() + "0\t$" + store.get(i).getCost() + "0\t" + store.get(i).getInventory() + "\t\t" + store.get(i).getQuantitySold());
                }
                System.out.println();
                removeProduct();
            } else if (choice == 5) {
                changePrices();
            } else if (choice == 6) {
                changeCost();
            } else if (choice == 7)
            {
                inventory();
            } else if (choice == 8) {
                System.out.println("ITEM\t\t\tPRICE\tCOST\tQTY \tSOLD");
                for (int i = 0; i < store.size(); i++) {
                    String space = "";
                    if (store.get(i).getName().length() < 4) {
                        space = "\t\t\t\t";
                    } else if (store.get(i).getName().length() < 8) {
                        space = "\t\t\t";
                    } else if (store.get(i).getName().length() < 12 ){
                        space = "\t\t";
                    } else {
                        space = "\t";
                    }
                    System.out.println(store.get(i).getName() + space + "$" + store.get(i).getPrice() + "0\t$" + store.get(i).getCost() + "0\t" + store.get(i).getInventory() + "\t\t" + store.get(i).getQuantitySold());
                }
                System.out.println();
                changeQuantity();
            } else if (choice == 9){
                System.out.println("ITEM\t\t\tPRICE\tCOST\tQTY \tSOLD");
                for (int i = 0; i < store.size(); i++) {
                    String space = "";
                    if (store.get(i).getName().length() < 4) {
                        space = "\t\t\t\t";
                    } else if (store.get(i).getName().length() < 8) {
                        space = "\t\t\t";
                    } else if (store.get(i).getName().length() < 12 ){
                        space = "\t\t";
                    } else {
                        space = "\t";
                    }
                    System.out.println(store.get(i).getName() + space + "$" + store.get(i).getPrice() + "0\t$" + store.get(i).getCost() + "0\t" + store.get(i).getInventory() + "\t\t" + store.get(i).getQuantitySold());
                }
                System.out.println();
                addProduct();
                System.out.println("ITEM\t\t\tPRICE\tCOST\tQTY \tSOLD");
                for (int i = 0; i < store.size(); i++) {
                    String space = "";
                    if (store.get(i).getName().length() < 4) {
                        space = "\t\t\t\t";
                    } else if (store.get(i).getName().length() < 8) {
                        space = "\t\t\t";
                    } else if (store.get(i).getName().length() < 12 ){
                        space = "\t\t";
                    } else {
                        space = "\t";
                    }
                    System.out.println(store.get(i).getName() + space + "$" + store.get(i).getPrice() + "0\t$" + store.get(i).getCost() + "0\t" + store.get(i).getInventory() + "\t\t" + store.get(i).getQuantitySold());
                }
                System.out.println();
            } else if(choice == 10) {
                popular();
            } else {
                System.out.println("ITEM\t\t\tPRICE\tCOST\tQTY \tSOLD");
                for (int i = 0; i < store.size(); i++) {
                    String space = "";
                    if (store.get(i).getName().length() < 4) {
                        space = "\t\t\t\t";
                    } else if (store.get(i).getName().length() < 8) {
                        space = "\t\t\t";
                    } else if (store.get(i).getName().length() < 12 ){
                        space = "\t\t";
                    } else {
                        space = "\t";
                    }
                    System.out.println(store.get(i).getName() + space + "$" + store.get(i).getPrice() + "0\t$" + store.get(i).getCost() + "0\t" + store.get(i).getInventory() + "\t\t" + store.get(i).getQuantitySold());
                }
                System.out.println();
                System.out.println("Not a valid number...Try again...");
            }
        }

    }



    // store data
    public static void choice() {
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1. Customer ");
        System.out.println("2. Display");
        System.out.println("3. Restock");
        System.out.println("4. Remove an item.");
        System.out.println("5. Change the prices");
        System.out.println("6. Change the costs ");
        System.out.println("7. Inventory Warnings");
        System.out.println("8. Changing Item's Quantity");
        System.out.println("9. Add an item");
        System.out.println("10. Best Selling Product");
    }

    public static void recap() {
        System.out.println("You have sold $" + Store.getTotalRevenue() + "0 worth of items.");
        System.out.println("You have made $" + Store.getProfit() + "0 in profit.");
        System.out.println();
        System.out.println("Food\t\t\tPrice\tCost\tQty \tSold");
        for (int i = 0; i < store.size(); i++) {
            String space = "";
            if (store.get(i).getName().length() < 4) {
                space = "\t\t\t\t";
            } else if (store.get(i).getName().length() < 8) {
                space = "\t\t\t";
            } else if (store.get(i).getName().length() < 12 ){
                space = "\t\t";
            } else {
                space = "\t";
            }
            System.out.println(store.get(i).getName() + space + "$" + store.get(i).getPrice() + "0\t$" + store.get(i).getCost() + "0\t" + store.get(i).getInventory() + "\t\t" + store.get(i).getQuantitySold());
        }
        System.out.println();
    }



    public static void inventory() {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getInventory() == 0 || store.get(i).getInventory() < 5) {
                System.out.println("You have run out of or you have ran out of " + store.get(i).getName() + "! You need to restock this item.");
            } else
            {
                System.out.println("You currently have " + store.get(i).getName() + " with a quantity of " + store.get(i).getInventory() + " in stock...");
            }

        }
    }

    public static void display2() {
        System.out.println("Food\t\t\tPrice\tQty");
        for (int i = 0; i < store.size(); i++) {
            String space = "";
            if (store.get(i).getName().length() < 4) {
                space = "\t\t\t\t";
            } else if (store.get(i).getName().length() < 8) {
                space = "\t\t\t";
            } else if (store.get(i).getName().length() < 12 ){
                space = "\t\t";
            } else {
                space = "\t";
            }
            System.out.println(store.get(i).getName() + space + "$" + store.get(i).getPrice() + "0\t" + store.get(i).getInventory());
        }
        System.out.println();
    }

    public static void display() {
        System.out.println("ITEM\t\t\tCOST\tQTY");
        for (int i = 0; i < store.size(); i++) {
            String space = "";
            if (store.get(i).getName().length() < 4) {
                space = "\t\t\t\t";
            } else if (store.get(i).getName().length() < 8) {
                space = "\t\t\t";
            } else if (store.get(i).getName().length() < 12 ){
                space = "\t\t";
            } else {
                space = "\t";
            }
            System.out.println(store.get(i).getName() + space + "$" + store.get(i).getCost() + "0\t" + store.get(i).getInventory());
        }
        System.out.println();
    }

    public static void customer() {
        System.out.println("Welcome, customer!\n");
        boolean position = true;
        while (position) {
            display2();
            String buy = "";
            boolean purchase = true;
            while (purchase) {
                System.out.print("What would you like to buy? ");
                buy = input.nextLine();
                for (int i = 0; i < store.size(); i++) {
                    if (buy.equals(store.get(i).getName())) {
                        buyIn = i;
                    }
                }
                if (buyIn < 0 || store.get(buyIn).getInventory() == 0) {
                    System.out.println("We do not stock that item.");
                } else {
                    purchase = false;
                }
            }

            boolean inStock = true;
            while (inStock) {
                System.out.print("How many would you like? ");
                int quantity = input.nextInt();
                if (quantity > store.get(buyIn).getInventory()) {
                    System.out.println("We do not have that many " + store.get(buyIn).getName() + "!");
                } else {
                    store.get(buyIn).buy(quantity);
                    System.out.println();
                    inStock = false;
                }
            }
            input.nextLine();
            System.out.print("Would you like to buy anything else? (yes/no) ");
            String j = input.nextLine();
            if (j.equals("Yes") || j.equals("yes")) {
                System.out.println();
            } else {
                position = false;
                System.out.println();
                System.out.println("Thank you for shopping at Whole Foods! Here is your receipt.");
                System.out.println("TOTAL:\t$" + Store.getReceipt() + "0\n");
                Store.setReceipt();
            }
        }
    }

    public static void restocking() {
        display();
        input.nextLine();
        String restock = "";
        boolean stock = true;
        int restockIndex = -1;
        while (stock) {
            System.out.print("What item would you like to restock? ");
            restock = input.nextLine();
            restockIndex = -1;
            for (int i = 0; i < store.size(); i++) {
                if (restock.equals(store.get(i).getName())) {
                    restockIndex = i;
                }
            }
            if (restockIndex < 0) {
                System.out.println("You don't even sell " + restock + "!");
            } else {
                stock = false;
            }
        }

        boolean inStock = true;
        while (inStock) {
            System.out.print("How many would you like to order? ");
            int quantity = input.nextInt();
            if (quantity * store.get(restockIndex).getCost() > Store.getTotalRevenue()) {
                System.out.println("You do not have enough money to order that much " + store.get(restockIndex).getName());
            } else {
                store.get(restockIndex).restock(quantity);
                System.out.println();
                inStock = false;
            }
        }
        input.nextLine();
        System.out.print("Would you like to order anything else? (yes/no) ");
        String j = input.nextLine();
        if (j.equals("yes")) {
            System.out.println();
            restocking();
        }
    }

    public static void removeProduct() {
        System.out.println("What item would you like to remove? ");
        String answer10 = input.next();
        newIn = -1;
        for(int i = 0; i < store.size(); i++)
        {
            if(answer10.equals(store.get(i).getName()))
            {
                newIn = i;
            }
        }
        store.remove(newIn);
    }
    public static void addProduct() {
        System.out.println("As of now you can only add one item. Please input 1! ");
        int num = input.nextInt();
        System.out.println("What item would you like to add? ");
        String answer11 = input.next();
        newIn = -1;
        for(int i = 0; i < store.size(); i++)
        {
            if(answer11.equals(store.get(i).getName()))
            {
                newIn = i;
            }
        }
        System.out.println("What is the desired selling price of this product? ");
        double answer12 = input.nextDouble();
        System.out.println("What is the desired cost price of this product? ");
        double answer13 = input.nextDouble();
        System.out.println("What is the desired quantity for this product? ");
        int answer14 = input.nextInt();
        for(int i = 0; i < num; i++)
        {
            Store item10  = new Store(answer11, answer14, answer13, answer12);
            store.add(item10);
        }

    }


    //issue with the print statements
    public static void changeCost() {
        display();
        String change = "";
        boolean changeF = true;
        while (changeF) {
            System.out.print("What item would you like to change suppliers for? ");
            change = input.nextLine();
            newIn = -1;
            for (int i = 0; i < store.size(); i++) {
                if (change.equals(store.get(i).getName())) {
                    newIn = i;
                }
            }
            if (newIn < 0) {
                System.out.println("You can't change the costs of an item you cannot sell!");
            } else {
                changeF = false;
            }
        }
        System.out.print("How much would you like to buy this item for now? ");
        double newCost = input.nextDouble();
        store.get(newIn).setCost(newCost);
        System.out.println("You are now buying " + change + " for " + newCost + ".");
    }
    //issue with the print statements
    public static void changePrices() {
        display2();
        String change = "";
        boolean changeF = true;
        while (changeF) {
            System.out.print("What item would you like to change the price? ");
            change = input.nextLine();
            newIn = -1;
            for (int i = 0; i < store.size(); i++) {
                if (change.equals(store.get(i).getName())) {
                    newIn = i;
                }
            }
            if (newIn < 0) {
                System.out.println("You can't mark up an item that you do not sell!");
            } else {
                changeF = false;
            }
        }
        System.out.print("What is the desired price for this item? ");
        double newPrice = input.nextDouble();
        store.get(newIn).setPrice(newPrice);
        System.out.println("You are now selling " + change + " for $" + newPrice + "0");
    }

    public static void changeQuantity()
    {
        System.out.println("What item would you like to change it's quantity? ");
        String answer = input.next();
        for(int i = 0; i < store.size(); i++)
        {
            if(answer.equals(store.get(i).getName()))
            {
                newIn = i;
            }
        }
        System.out.println("What is the desired quantity? ");
        int num = input.nextInt();
        store.get(newIn).setQuantity(num);
    }

    public static void popular()
    {

        for(int i = 0; i < store.size(); i++)
        {
            if(store.get(i).getQuantitySold() < 2)
            {
                System.out.println(store.get(i).getName() +
                        " is not selling well with a quantity of " + store.get(i).getQuantitySold() + " sold..." );
            } else {
                System.out.println(store.get(i).getName() + " is selling really well with a quantity of " + store.get(i).getQuantitySold() + " items sold. You might want to consider to restock or make the quantity greater");
            }
        }
        System.out.println("If an item is not selling well, you might want to reduce the selling price...");

    }

}