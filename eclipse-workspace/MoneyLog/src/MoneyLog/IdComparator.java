package MoneyLog;

import java.util.Comparator;

public class IdComparator implements Comparator<Member>{
	@Override
	public int compare(Member m1,Member m2) {
		if(m1!=null&&m2!=null) {
			return m1.getId().compareTo(m2.getId());
		}return 0;
	}
}
