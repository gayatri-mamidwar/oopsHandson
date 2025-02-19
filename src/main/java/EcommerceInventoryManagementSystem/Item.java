package EcommerceInventoryManagementSystem;

public class Item implements Comparable<Item> {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Item() {
    }

    public Item(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Comparable compareTo() is used for default sorting of custom/user defined datatype
    /*
    'this' obj to come before -> return -1
    'this' obj to come after -> return 1
     */
    @Override
    public int compareTo(Item other){
        //to sort name by lexicographycally (asc order) use compareTo()
        return this.name.compareTo(other.name);

        //to sort name by length
//        return this.name.length() - other.name.length();

    }
}
