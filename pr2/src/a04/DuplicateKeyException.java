/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a04;

/**
 * Thrown to indicate that a same key as the given key already exists.
 * <p>
 * @author Le
 * @author Nguyen
 */
public class DuplicateKeyException extends Exception {

    private static final long serialVersionUID = -133053552643765332L;

    /**
     * Constructs a duplicate key exception with no detail message.
     */
    public DuplicateKeyException() {
        super();
    }

    /**
     * Constructs a duplicate key exception with the specified detail message.
     * <p>
     * @param message the detail message.
     */
    public DuplicateKeyException(String message) {
        super(message);
    }
}
