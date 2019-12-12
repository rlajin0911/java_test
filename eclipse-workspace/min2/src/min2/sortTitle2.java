package min2;

import java.util.Comparator;

public class sortTitle2 implements Comparator<Event> {

	@Override
	public int compare(Event o1, Event o2) {
		if (o1 != null && o2 != null) {
			return o2.getTitle().compareTo(o1.getTitle());
		}
		return 0;
	}

}
