package ex12;

import java.io.Serializable;

public class UserInfo implements Serializable{

	/**
	 * 名前
	 */
	private String name;

	/**
	 * 性別
	 */
	private String gender;

	public UserInfo() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
