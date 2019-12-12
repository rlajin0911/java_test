package MoneyLog;

public class MoneyLog {
	String intputoutput, rname,date;
	int price;
	String atname;
	public MoneyLog(String intputoutput, String rname, String date, int price, String atname) {
		super();
		this.intputoutput = intputoutput;
		this.rname = rname;
		this.date = date;
		this.price = price;
		this.atname = atname;
	}
	public String getIntputoutput() {
		return intputoutput;
	}
	public void setIntputoutput(String intputoutput) {
		this.intputoutput = intputoutput;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAtname() {
		return atname;
	}
	public void setAtname(String atname) {
		this.atname = atname;
	}
	
}
