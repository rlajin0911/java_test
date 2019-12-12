package kje;

import java.util.Comparator;

public class SortName implements Comparator <Robot>{
	@Override
	public int compare(Robot o1,Robot o2) {
		if(o1!=null&&o2!=null) {
			return o1.getRobotname().compareTo(o2.getRobotname());
		}
		return 0;
	}
}
