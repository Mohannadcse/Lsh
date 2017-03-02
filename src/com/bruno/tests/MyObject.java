package com.bruno.tests;

public class MyObject {

	private Integer id;
	private String name;

	public MyObject(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		String hash = id.hashCode() + "" + name.hashCode();
		return Integer.parseInt(hash);
		// TODO Auto-generated method stub
		//return super.hashCode();
	}
	
}
