package finaltestex;

import java.util.Comparator;

public class PriceReverseComparator implements Comparator<Book> {
	@Override
	public int compare(Book r1, Book r2) {
		if(r1!=null&&r2!=null) {
			return r2.getPrice()-r1.getPrice();
		}
		return 0;
	}
}
