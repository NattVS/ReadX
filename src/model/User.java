package model;

import java.util.Calendar;

public abstract class User {
	private int type;
	private String id;
	private String name;
	private Calendar signUpDate;

	public User(int type, String id, String name) {
		this.type = type;
		this.id = id;
		this.name = name;
	}
    
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public Calendar getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Calendar signUpDate) {
		this.signUpDate = signUpDate;
	}

}
