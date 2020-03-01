package Collections;

import java.util.ArrayList;
import java.util.List;

public class SetExample {
	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<String>();
		l.add("ciao");
		l.add("nicola");

		List<?> u = l;
		String p = (String) u.get(0);
		System.out.println(p);
	}
}
