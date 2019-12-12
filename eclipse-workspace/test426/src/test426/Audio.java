package test426;

public class Audio extends Product{
	String M;
	String YN;
	public Audio(String model, String company, int date, int numOfstock, int price, String m, String yN) {
		super(model, company, date, numOfstock, price);
		M = m;
		YN = yN;
	}
	public String getM() {
		return M;
	}
	public void setM(String m) {
		M = m;
	}
	public String getYN() {
		return YN;
	}
	public void setYN(String yN) {
		YN = yN;
	}
}
