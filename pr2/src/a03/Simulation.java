/**
 * HAW Hamburg - Studiengang Wirtschaftsinformatik
 * Programmieren II - Wintersemester 2013/2014
 *
 * Aufgabenblatt 1
 * 
 * ngochien.le@haw-hamburg.de
 * bichngoc.nguyen@haw-hamburg.de
 * 
 */

package a03;

import java.util.Timer;

/**
 * Testing class of this package.
 * 
 * @author Le
 * @author Nguyen
 */
public class Simulation {

	public static final int DEFAULT_BUFFER_SIZE = 5;
	public static final int NUM_OF_CUSTOMERS = 10;
	public static final int NUM_OF_PRODUCTS = 10;
	public static final int NUM_OF_ORDERS = 10;

	public static void main(String[] args) {
		new Simulation().start();
	}

	/**
	 * Create test objects and starts the simulation.
	 */
	public void start() {
		// The shared buffer object which contains orders of a web shop.
		BoundedBuffer<Order> buffer = new BoundedBuffer<>(DEFAULT_BUFFER_SIZE);

		WebShop shop = new WebShop(buffer);
		simulateWebShopData(shop);

		OrderGenerator generator = new OrderGenerator(shop, buffer);
		OrderCancel ruiner = new OrderCancel(buffer);

		Thread shopThread = new Thread(shop, "Web shop");
		shopThread.start();

		Thread generatorThread = new Thread(generator, "Generator");
		generatorThread.start();

		Timer ruinerTimer = new Timer("Ruiner");
		ruinerTimer.schedule(ruiner, OrderCancel.CANCELLING_PERIOD, OrderCancel.CANCELLING_PERIOD);

		try {
			shopThread.join();
			generatorThread.join();
			ruinerTimer.cancel();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Generates customer and product data of a web shop.
	 */
	private void simulateWebShopData(WebShop shop) {

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
			double price = (double) Math.round(Math.random() * NUM_OF_PRODUCTS
					* 100) / 100;
			try {
				shop.addProduct(name, price);
			} catch (DuplicateKeyException e) {
				e.printStackTrace();
			}
		}
	}
}
