package kje;

import java.util.Comparator;

public class SortPrice implements Comparator <Robot>{
	@Override
	public int compare(Robot o1,Robot o2) {
		if(o1!=null&&o2!=null) {
			return o1.getPrice()-o2.getPrice();
		}
		return 0;
	}
}
