/**
 * HAW Hamburg - Studiengang Wirtschaftsinformatik
 * Programmieren II - Wintersemester 2013/2014
 *
 * Aufgabenblatt 2
 * 
 * ngochien.le@haw-hamburg.de
 * bichngoc.nguyen@haw-hamburg.de
 */
package a02.typebound;

/**
 * Andere M�glichkeit f�r Typeinschr�nkung.
 * 
 * @author Le
 * @author Nguyen
 */
public class Node {
	
	private Number element;

	/*
	 * Vorteile :
	 * 		Ganz flexibel :
	 * 			private static Number DEFAULT_WERT = 0;	// OK
	 * 			element = new Integer(aNumber);			// OK
	 * 
	 * Nachteile :
	 * 		- Keine weitere Einschr�nkungen m�glich.
	 * 		- Verschiedene Elementtypen innerhalb eines Baums m�glich.
	 * 		...
	 */

	public static void main(String[] args) {
		
	}		
}
