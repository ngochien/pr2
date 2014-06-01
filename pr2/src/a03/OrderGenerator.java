/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */

package a03;

/**
 * An order generator which randomly generates orders from customer data and
 * product data of a web shop and puts the generated orders in a bounded buffer.
 * 
 * @author Le
 */
public class OrderGenerator implements Runnable {

	/**
	 * Takes data from this web shop to generate orders.
	 */
	private WebShop webShop;
	
	/**
	 * Saves all generated orders in this buffer.
	 */
	private BoundedBuffer<Order> buffer;

	/**
	 * Constructs an order generator with the specified web shop as data source
	 * and the given bounded buffer as data storage.
	 * 
	 * @param webShop the web shop from which data are taken.
	 * @param buffer the bounded buffer to store generated orders.
	 */
	public OrderGenerator(WebShop webShop, BoundedBuffer<Order> buffer) {
		this.webShop = webShop;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			Order order = generateOrder();
			
			/* While checking number of added elements and trying to put an
			 * order in the bounded buffer, other threads are not allowed to
			 * access this buffer, or it may lead to inconsistent states.
			 * Here : enter critical section -> synchronized.
			 */
			synchronized (buffer) {
				if (buffer.getNumOfAddedElements() < Simulation.NUM_OF_ORDERS) {
					buffer.put(order);
				} else {
					/*
					 * When all orders needed for the simulation have been put in the
					 * buffer, exits the run method.
					 */
					System.out.println(Thread.currentThread().getName() + " - Exiting");
					return;
				}
			}
		}
	}

	/**
	 * Generates an order with a customer and a product randomly picked from web shop.
	 * 
	 * @return an order.
	 */
	public Order generateOrder() {
//		System.out.println(Thread.currentThread().getName() + " - Generating order");
		Customer customer = webShop.randomCustomer();
		Product product = webShop.randomProduct();
//		System.out.println(Thread.currentThread().getName() + " - Generated order from " + customer + product);
		return new Order(customer, product);
	}
}
