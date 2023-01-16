package ex12;

import java.io.Serializable;

public class TestBean implements Serializable{
	
	/**
	 * 名前
	 */
	private String name;
	


	/**
	 * 性別
	 */
	private String gender;
	
	/**
	 * 住所
	 */
	private String address;
	
	/**
	 * id
	 */
	
	private String id;
	
	
	/**
	 * デフォルトコンストラクタ
	 */
	public TestBean() {
		
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
