package MoneyLog;

import java.util.Comparator;

public class NameComparator implements Comparator<Member>{
	@Override
	public int compare(Member m1,Member m2) {
		if(m1!=null&&m2!=null) {
			return m1.getName().compareTo(m2.getName());
		}return 0;
	}
}
