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

    public static final int CANCELLING_PERIOD = 1200;

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
        /* While checking number of removed elements and trying to remove an
         * order from the bounded buffer, other threads are not allowed to
         * access this buffer, or it may lead to inconsistent states.
         * Here : enter critical section -> synchronized.
         */
        synchronized (buffer) {
            if (buffer.getNumOfRemovedElements() < Simulation.NUM_OF_ORDERS) {
                Order order = buffer.take();
                System.out.println("Cancelled:    " + order);
            } else {
                /*
                 * When all orders needed for the simulation have been removed
                 * from the buffer, exits the run method.
                 */
                System.out.println(Thread.currentThread().getName() + " - Exiting");
                return;
            }
        }
    }
}
