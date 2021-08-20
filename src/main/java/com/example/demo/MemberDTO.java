package com.example.demo;

public class MemberDTO {
	private String id;
	private String name;
	private String email;
	private int age;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public MemberDTO(String id, String name, String email, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + "]";
	}

}
