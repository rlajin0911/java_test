package min2;

import java.util.Comparator;

public class sortTitle implements Comparator<Event>{

	@Override
	public int compare(Event o1, Event o2) {
		if(o1!=null&&o2!=null) {
			return o1.getTitle().compareTo(o2.getTitle());
		}
		return 0;
	}
}