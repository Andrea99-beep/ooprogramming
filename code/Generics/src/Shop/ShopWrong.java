package Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ShopWrong<T> implements Iterable<T> {
	private LinkedList<T> l;

	public ShopWrong() {
		l = new LinkedList<T>();
	}

	T sell() {
		return l.removeLast();
	}

	void buy(T item) {
		l.addFirst(item);
	}

	void sell(List<T> items, int nItems) {
		for (int i = 0; i < nItems; i++) {
			items.add(l.removeLast());
		}
	}

	void buy(List<T> items) {
		for (T item : items) {
			l.add(item);
		}
	}

	@Override
	public Iterator<T> iterator() {
		return l.iterator();
	}

	public static void main(String[] args) {
		ShopWrong<Fruit> fs = new ShopWrong<Fruit>();
		ShopWrong<Product> ps = new ShopWrong<Product>();

		List<Fruit> lf;
		List<Product> lp;

		// CASE1: Single type (Single Object)
		System.out.println("CASE1: Single type (Single Object)");
		fs.buy(new Fruit());
		System.out.println(fs.sell());

		// CASE2: Single type (Collections)
		System.out.println("CASE2: Single type (Collections)");
		lf = new ArrayList<Fruit>(Arrays.asList(new Fruit(), new Fruit(), new Fruit()));
		fs.buy(lf);

		lf.clear();
		fs.sell(lf, 2);
		System.out.println(lf);

		// CASE3: Sub-typing (Single Object)
		System.out.println("CASE3: Sub-typing (Single Object)");
		ps.buy(new Fruit());
		System.out.println(ps.sell());

		// CASE4: Sub-typing (Collections) NOT working!
		System.out.println("Sub-typing (Collections) NOT working!");
		lf = new ArrayList<Fruit>(Arrays.asList(new Fruit(), new Fruit(), new Fruit()));

		// compile error if uncommented
		// ps.buy(lf);

		lp = new ArrayList<Product>();
		// compile error if uncommented
		// fs.sell(lp, 3);
	}
}
