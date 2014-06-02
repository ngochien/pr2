/*
 * HAW Hamburg - Studiengang Wirtschaftsinformatik
 * Programmieren II - Sommersemester 2013/2014
 *
 * Aufgabenblatt 3
 * 
 * ngochien.le@haw-hamburg.de
 * bichngoc.nguyen@haw-hamburg.de
 * 
 */
package a03;

import java.util.Timer;

/**
 * Testing class of this package.
 * <p>
 * @author Le
 * @author Nguyen
 */
public class Simulation {

    public static final int DEFAULT_BUFFER_SIZE = 5;
    public static final int NUM_OF_CUSTOMERS = 10;
    public static final int NUM_OF_PRODUCTS = 10;
    public static final int NUM_OF_ORDERS = 10;

    /**
     * Program entry point.
     */
    public static void main(String[] args) {
        new Simulation().start();
        System.out.println("--------------------Simulation done-------------------");
    }

    /**
     * Creates test objects and starts the simulation.
     */
    public void start() {
        // The shared bounded buffer object which contains orders of a web shop.
        BoundedBuffer<Order> buffer = new BoundedBuffer<>(DEFAULT_BUFFER_SIZE);

        WebShop shop = new WebShop(buffer);
        simulateData(shop);

        OrderGenerator generator = new OrderGenerator(shop, buffer);
        OrderCancel cancelTask = new OrderCancel(buffer);

        // Creates needed threads and timer for the simulation.
        Thread shopThread = new Thread(shop, "Webshop-Thread");
        Thread generatorThread = new Thread(generator, "Generator-Thread");
        Timer cancelTimer = new Timer("Cancel-Thread");

        // Start all the created threads and timer.
        shopThread.start();
        generatorThread.start();
        cancelTimer.schedule(cancelTask, OrderCancel.CANCELLING_PERIOD, OrderCancel.CANCELLING_PERIOD);

        // Wait until all other threads are finished.
        try {
            shopThread.join();
            generatorThread.join();
            cancelTimer.cancel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates customer and product data of a web shop.
     */
    private void simulateData(WebShop shop) {

        // Customer data
        for (int i = 0; i < NUM_OF_CUSTOMERS; i++) {
            String firstName = i + "";
            String lastName = "Kunde";
            try {
                shop.addCustomer(firstName, lastName);
            } catch (DuplicateKeyException e) {
                e.printStackTrace();
            }
        }

        // Product data
        for (int i = 0; i < NUM_OF_PRODUCTS; i++) {
            String name = "Product " + i;
            double price = (double) Math.round(Math.random() * NUM_OF_PRODUCTS * 100) / 100;
            try {
                shop.addProduct(name, price);
            } catch (DuplicateKeyException e) {
                e.printStackTrace();
            }
        }
    }
}
