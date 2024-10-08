package module2.ss17.manage_product.model;

public class Product {
    private static int count =1;
    private int id;
    private String name;
    private double price;
    private String manufacture;
    private String description;

    public Product( String name, double price, String manufacture, String description) {
        this.id = Product.getCount();
        this.name = name;
        this.price = price;
        this.manufacture = manufacture;
        this.description = description;
    }

    public Product() {
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return
                id +
                "," + name +
                "," + price +
                "," + manufacture +
                "," + description ;
    }
}
