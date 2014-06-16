/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package a04;

import java.util.Comparator;

/**
 * Compares two strings lexicographically.
 * <p>
 * @author Le
 * @author Nguyen
 */
public class StringComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
}
