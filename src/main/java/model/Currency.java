package model;

import java.time.DayOfWeek;
import java.util.Set;

public class Currency {
	
	private String name;
	private String code;
	private boolean startOnSunday;
	private float agreedFx;
	private Set<DayOfWeek> hodayList;
	
	public Currency() {
		
	}
	
	public Currency(String code,  Set<DayOfWeek> hodayList, float agreedFx) {
		super();
		this.code = code;
		this.hodayList = hodayList;
		this.agreedFx = agreedFx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isStartOnSunday() {
		return startOnSunday;
	}
	public void setStartOnSunday(boolean startOnSunday) {
		this.startOnSunday = startOnSunday;
	}
	public float getAgreedFx() {
		return agreedFx;
	}
	public void setAgreedFx(float agreedFx) {
		this.agreedFx = agreedFx;
	}

	public Set<DayOfWeek> getHodayList() {
		return hodayList;
	}

	public void setHodayList(Set<DayOfWeek> hodayList) {
		this.hodayList = hodayList;
	}

}
