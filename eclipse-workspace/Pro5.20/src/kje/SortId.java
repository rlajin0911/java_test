package kje;

import java.util.Comparator;

public class SortId implements Comparator <Robot>{
	@Override
	public int compare(Robot o1,Robot o2) {
		if(o1!=null&&o2!=null) {
			return o1.getId()-o2.getId();
		}
		return 0;
	}
}
