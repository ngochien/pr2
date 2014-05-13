/**
 * HAW Hamburg - Studiengang Wirtschaftsinformatik
 * Programmieren II - Wintersemester 2013/2014
 *
 * Aufgabenblatt 1
 * 
 * ngochien.le@haw-hamburg.de
 * bichngoc.nguyen@haw-hamburg.de
 */
package typebound;

/**
 * @author Le
 * @author Nguyen
 */
public class BinaryNode {
	
	private static Number defaultValue = 0;
	
	private Number element;

	private BinaryNode left, right;

	public BinaryNode(Number element) {
		this.element = element;
	}
	
	public void resetElement() {
		this.element = defaultValue;
	}

	public static void main(String[] args) {

		BinaryNode b = new BinaryNode(2);
		BinaryNode c = new BinaryNode(2.1);
		b = c;
	}
}
