package MoneyLog;

import java.util.Comparator;

public class AgeComparator implements Comparator<Member>{
	@Override
	public int compare(Member m1,Member m2) {
		if(m1!=null&&m2!=null) {
			return m1.getBirth()-m2.getBirth();
		}return 0;
	}
}
