package entity;

//宿管实体类
public class DormitoryManager {
	
	private Integer id;
	private Integer sgno;
	private String sgname;
	private String password;
	private Integer budno;
	private Integer phone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSgno() {
		return sgno;
	}
	public void setSgno(Integer sgno) {
		this.sgno = sgno;
	}
	public String getSgname() {
		return sgname;
	}
	public void setSgname(String sgname) {
		this.sgname = sgname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getBudno() {
		return budno;
	}
	public void setBudno(Integer budno) {
		this.budno = budno;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
}
