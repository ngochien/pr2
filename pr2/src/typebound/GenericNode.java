/**
 * HAW Hamburg - Studiengang Wirtschaftsinformatik
 * Programmieren II - Wintersemester 2013/2014
 *
 * Aufgabenblatt 2
 * 
 * ngochien.le@haw-hamburg.de
 * bichngoc.nguyen@haw-hamburg.de
 */
package typebound;

/**
 * Typeinschränkung mit Generic.
 * @author Le
 * @author Nguyen
 */
public class GenericNode<T extends Number> {
	
	private T element;
	
	/*
	 * Vorteile :
	 * 	- Compiler überprüft Typen, mehrere Elementtypen innerhalb eines Baums nicht möglich.
	 * 	- Keine Typcast erforderlich.
	 * 	- Weitere Einschränkungen möglich.
	 * 	...
	 * 
	 * Nachteile :
	 * 	- Statische Variablen mit dem Typ "T" nicht möglich.
	 *	  	private static T DEFAULT_WERT = ...; // compile error
	 *	
	 *	- Erzeugung eines Objekt vom Typ "T" nicht möglich.
     *		element = new T();  // compile-time error
     *	...  
	 */
	 
	public static void main(String[] args) {
		
	}
}
