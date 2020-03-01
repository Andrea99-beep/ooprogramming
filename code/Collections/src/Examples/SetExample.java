package Examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<String>(Arrays.asList("Nicola", "Agata", "Marzia", "Agata"));

		Set<String> hs = new HashSet<String>(l);
		Set<String> lhs = new LinkedHashSet<String>(l);
		Set<String> ts = new TreeSet<String>(l);

		// original list
		System.out.println(l);

		// initial ordering
		System.out.println(lhs);

		// no particular ordering
		System.out.println(hs);

		// natural ordering
		System.out.println(ts);
	}

}
