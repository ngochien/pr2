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
 * Typeinschr�nkung mit Generic.
 * @author Le
 * @author Nguyen
 */
public class GenericNode<T extends Number> {
	
	private T element;
	
	/*
	 * Vorteile :
	 * 	- Compiler �berpr�ft Typen, mehrere Elementtypen innerhalb eines Baums nicht m�glich.
	 * 	- Keine Typcast erforderlich.
	 * 	- Weitere Einschr�nkungen m�glich.
	 * 	...
	 * 
	 * Nachteile :
	 * 	- Statische Variablen mit dem Typ "T" nicht m�glich.
	 *	  	private static T DEFAULT_WERT = ...; // compile error
	 *	
	 *	- Erzeugung eines Objekt vom Typ "T" nicht m�glich.
     *		element = new T();  // compile-time error
     *	...  
	 */
	 
	public static void main(String[] args) {
		
	}
}
