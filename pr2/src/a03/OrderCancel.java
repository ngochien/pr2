/**
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a03;

import java.util.TimerTask;

/**
 * @author Le
 * 
 */
public class OrderCancel extends TimerTask {

	public static final int CANCELLING_PERIOD = 1200;

	private BoundedBuffer<Order> buffer;

	/**
	 * @param buffer
	 */
	public OrderCancel(BoundedBuffer<Order> buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
//		if (WebShop.processedOrder < Simulation.NUM_OF_ORDERS) {
//			Order order = buffer.take();
//			System.out.println("Cancelled: " + order);
//			WebShop.processedOrder++;
//		}
	}
}
