/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a03;

import java.util.TimerTask;

/**
 * Objects of this class remove an order from a bounded buffer and cancel this order.
 * <p>
 * @author Le
 */
public class OrderCancel extends TimerTask {

    /**
     * To be cancelled orders are taken from this buffer.
     */
    private BoundedBuffer<Order> buffer;

    /**
     * Constructs an OrderCancel object which cancels orders from the specified buffer.
     * <p>
     * @param buffer the bounded buffer from which orders are cancelled.
     */
    public OrderCancel(BoundedBuffer<Order> buffer) {
        this.buffer = buffer;
    }

    @Override
	public void run() {
		synchronized (buffer) {
			if (!buffer.isEmpty()) {
				System.out.println("Cancelled:    " + buffer.take());
			} else {
//				System.out.println(Thread.currentThread().getName() + " - Exiting");
			}
		}
	}
}
