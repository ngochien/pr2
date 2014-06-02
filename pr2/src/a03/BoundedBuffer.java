/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a03;

import java.util.LinkedList;
import java.util.List;

/**
 * A bounded buffer which can hold a specified number of elements of type E.
 * Operations (put and take) on bounded buffer objects are implemented with FIFO behavior.
 * <p>
 * @author Le
 *
 */
public class BoundedBuffer<E> {

    private int size;

    /**
     * A list as internal storage.
     */
    private List<E> list;

    /**
     * Number of elements that were added to this bounded buffer.
     */
    private int numOfAddedElements;

    /**
     * Number of elements that were removed from this bounded buffer.
     */
    private int numOfRemovedElements;

    /**
     * Constructs a bounded buffer with the specified size.
     * <p>
     * @param size the number of elements that the buffer can hold.
     */
    public BoundedBuffer(int size) {
        this.size = size;
        this.list = new LinkedList<E>();
    }

    /**
     * Returns the number of added elements in this bounded buffer.
     * <p>
     * @return number of elements that were added to this bounded buffer.
     */
    public synchronized int getNumOfAddedElements() {
//		System.out.println(Thread.currentThread().getName() + " - Getting number of added elements.");
        return numOfAddedElements;
    }

    /**
     * Returns the number of removed elements in this bounded buffer.
     * <p>
     * @return number of elements that were removed from this bounded buffer.
     */
    public synchronized int getNumOfRemovedElements() {
//		System.out.println(Thread.currentThread().getName() + " - Getting number of removed elements.");
        return numOfRemovedElements;
    }

    /**
     * Puts an element of type E in this bounded buffer.
     * <p>
     * @param element the element to be put.
     */
    public synchronized void put(E element) {
//		System.out.println(Thread.currentThread().getName() + " - Trying to put " + element);
        while (list.size() == size) {
            try {
//				System.out.println(Thread.currentThread().getName() + " - Waiting");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                return;
            }
        }
        list.add(element);
//		System.out.println(Thread.currentThread().getName() + " - Putted " + element);
        numOfAddedElements++;
        notifyAll();
    }

    /**
     * Takes an element and removes it from this bounded buffer.
     * <p>
     * @return	the element which was removed.
     */
    public synchronized E take() {
//		System.out.println(Thread.currentThread().getName() + " - Trying to take");
        while (list.size() == 0) {
            try {
//				System.out.println(Thread.currentThread().getName() + " - Waiting");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                return null;
            }
        }
        E element = list.remove(0);
//		System.out.println(Thread.currentThread().getName() + " - Took " + element);
        numOfRemovedElements++;
        notifyAll();
        return element;
    }
}
