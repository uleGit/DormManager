package entity;

import java.util.Date;

public class Repairs {

	private Integer id;
	private Integer dor;
	private Integer budno;
	private String detail;
	private String handler;
	private String result;
	private Date time;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDor() {
		return dor;
	}
	public void setDor(Integer dor) {
		this.dor = dor;
	}
	public Integer getBudno() {
		return budno;
	}
	public void setBudno(Integer budno) {
		this.budno = budno;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getHandler() {
		return handler;
	}
	public void setHandler(String handler) {
		this.handler = handler;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
