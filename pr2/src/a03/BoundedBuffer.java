/**
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
 * 
 * @author Le
 *
 */
public class BoundedBuffer<E> {

	private int size;
	private List<E> buffer;
	
	/**
	 * @param size	the number of elements that the buffer can hold.
	 */
	public BoundedBuffer(int size) {
		this.size = size;
		this.buffer = new LinkedList<E>();
	}
	
	public synchronized boolean isEmpty() {
		return buffer.size() == 0;
	}
	/**
	 * Puts an element of type E in this bounded buffer.
	 * @param element
	 */
	public synchronized void put(E element) {
		while (buffer.size() == size) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
				return;
			}
		}
		buffer.add(element);
		notifyAll();
	}
	
	/**
	 * Takes an element and removes it from this bounded buffer.
	 * @return	the element which was removed.
	 */
	public synchronized E take() {
		while (buffer.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
				return null;
			}
		}
		E element = buffer.remove(0);
		notifyAll();
		return element;
	}
}
