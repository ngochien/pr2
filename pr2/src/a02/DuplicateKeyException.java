/**
 * HAW Hamburg - Studiengang Wirtschaftsinformatik
 * Programmieren II - Wintersemester 2013/2014
 *
 * Aufgabenblatt 1
 * 
 * ngochien.le@haw-hamburg.de
 * bichngoc.nguyen@haw-hamburg.de
 */
package a02;

/**
 * @author Le
 * @author Nguyen
 */
public class DuplicateKeyException  extends Exception {

	public DuplicateKeyException() {
		super();
	}
	
	public DuplicateKeyException(String message) {
		super(message);
	}
}
