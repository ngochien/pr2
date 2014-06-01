/**
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a03;

/**
 * @author Le
 * 
 */
public class OrderGenerator implements Runnable {

	private WebShop webShop;
	private BoundedBuffer<Order> buffer;

	public OrderGenerator(WebShop webShop, BoundedBuffer<Order> buffer) {
		this.webShop = webShop;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		// while (!Thread.currentThread().isInterrupted()) {
		for (int i = 0; i < Simulation.NUM_OF_ORDERS; i++) {
			Order order = generateOrder();
			buffer.put(order);
		}
	}

	public Order generateOrder() {
		Customer customer = webShop.randomCustomer();
		Product product = webShop.randomProduct();
		return new Order(customer, product);
	}
}
