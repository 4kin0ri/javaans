package ex12;

import java.io.Serializable;

public class Kadai1Bean implements Serializable{

	private String name;

	private String id;

	private String password;

	private String address;

	private String gender;

	public Kadai1Bean() {
		this.id = "kouka";

		this.password = "teu";

		this.name = "工科太郎";

		this.address = "東京都八王子市片倉町";

		this.gender = "男性";

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}






}
