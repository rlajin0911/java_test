package test530;

import java.util.Comparator;

public class SortTitle implements Comparator<Movie> {
	@Override
	public int compare(Movie o1, Movie o2) {
		if(o1!=null&&o2!=null) {
			return o1.getTitle().compareTo(o2.getTitle());
		}
		return 0;
	}
}
