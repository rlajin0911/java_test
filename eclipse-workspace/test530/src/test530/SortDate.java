package test530;

import java.util.Comparator;

public class SortDate implements Comparator<Movie> {
	@Override
	public int compare(Movie o1, Movie o2) {
		if(o1!=null&&o2!=null) {
			return o1.getDate().compareTo(o2.getDate());
		}
		return 0;
	}
}
