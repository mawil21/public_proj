public class Store{

    private String name;
    private int inventory;
    private double cost;
    private double price;
    private int quantitySold;

    private static double receipt;
    private static double totalCost;
    private static double totalRevenue;

    public Store(String name, int inventory, double cost, double price) {
        this.name = name;
        this.inventory = inventory;
        this.cost = cost;
        this.price = price;
        totalCost += inventory * cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInventory() {
        return inventory;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static double getTotalCost() {
        return totalCost;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getReceipt() {
        return receipt;
    }

    public static void setReceipt() {
        receipt = 0;
    }

    public void setInventory() {
        inventory = 0;
    }
    public void setQuantity(int inventory){
        this.inventory = inventory;
    }

    public void setQuantitySold() {
        quantitySold = 0;
    }

    public static double getProfit() {
        return totalRevenue - totalCost;
    }

    public void buy(int quantity) {
        quantitySold += quantity;
        inventory -= quantity;
        totalRevenue += price * quantity;
        receipt += price * quantity;

    }

    public void restock(int quantity) {

        totalCost += quantity * cost;
        inventory += quantity;
    }


}