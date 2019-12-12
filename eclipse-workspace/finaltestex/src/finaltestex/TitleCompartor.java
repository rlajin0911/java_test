package finaltestex;

import java.util.Comparator;

public class TitleCompartor implements Comparator<Book> {
	@Override
	public int compare(Book r1, Book r2) {
		if(r1!=null&&r2!=null) {
			return r1.getTitle().compareTo(r2.getTitle());
		}
		return 0;
	}
}
