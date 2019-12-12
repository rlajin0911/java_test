package MoneyLog;

public class Member {
	String id,name,password;
	int birth;
	public Member(String id, String name, String password, int birth) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.birth = birth;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	
}
