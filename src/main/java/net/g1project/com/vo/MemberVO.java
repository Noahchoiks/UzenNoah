package net.g1project.com.vo;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

@SuppressWarnings("serial")
public class MemberVO implements Serializable {

	@Pattern(regexp = "regexp", message = "message")
	private String id;
	private String name;
	private String password;
	private String sex;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
