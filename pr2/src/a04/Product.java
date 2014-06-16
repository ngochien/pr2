/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a04;

/**
 * A product with name and price.
 * <p>
 * @author Le
 * @author Nguyen
 */
public class Product {

    private String name;
    private double price;

    /**
     * Constructs a product with the given name and price.
     * <p>
     * @param name  name of the product to be created.
     * @param price price of the product to be created.
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Returns name of this product.
     * <p>
     * @return name of this product.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns price of this product.
     * <p>
     * @return price of this product.
     */
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + price + " EURO)";
    }
}
