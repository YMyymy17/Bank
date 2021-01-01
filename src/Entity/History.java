package Entity;

import java.util.*;

public class History {
	
	private String id;
	private String name;
	private String home;
	private String kind;
	private String date;
	private float rate;
	private float num;
	public History(String id, String name, String home, String kind, String date, float rate, float num) {
		super();
		this.id = id;
		this.name = name;
		this.home = home;
		this.kind = kind;
		this.date = date;
		this.rate = rate;
		this.num = num;
	}
	public History() {
		// TODO Auto-generated constructor stub
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
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getNum() {
		return num;
	}
	public void setNum(float num) {
		this.num = num;
	}	
}