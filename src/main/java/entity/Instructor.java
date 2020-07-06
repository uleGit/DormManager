package entity;

//导员实体类
public class Instructor {
	
	private Integer id;
	private Integer insno;
	private String insname;
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getInsno() {
		return insno;
	}
	public void setInsno(Integer insno) {
		this.insno = insno;
	}
	public String getInsname() {
		return insname;
	}
	public void setInsname(String insname) {
		this.insname = insname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
