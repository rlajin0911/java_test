package finaltestex;

import java.util.Comparator;

public class Pricecomparator implements Comparator<Book>{
	@Override
	public int compare(Book r1, Book r2) {
		if(r1!=null&&r2!=null) {
			return r1.getPrice()-r2.getPrice();
		}
		return 0;
	}
}
