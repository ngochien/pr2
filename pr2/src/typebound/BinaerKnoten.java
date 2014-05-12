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
public class BinaerKnoten<T extends Number> {

	private static Number DEFAULT_VALUE = null; // nicht möglich
	private T element;
	
	private BinaerKnoten<T> left, right;
	
	public BinaerKnoten() {
//		 this.element = DEFAULT_VALUE;
	}
	
	public BinaerKnoten(T element, BinaerKnoten<T> left, BinaerKnoten<T> right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}

	public void resetElement() {
		// nicht möglich
	}
	
	public static void main(String[] args) {

		BinaerKnoten<Integer> l = new BinaerKnoten<>(5, null, null);
		BinaerKnoten<Double> r = new BinaerKnoten<Double>(0.1, null, null);
//		BinaerKnoten<Number> w = new BinaerKnoten<Number>(5, l, r);

		System.out.println(l.element instanceof Integer);
		
	}

}
