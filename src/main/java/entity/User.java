package entity;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String password;
	private int state;
	
	public User() {}

	public User(int id, String name, String password, int state) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.state = state;
	}
	
	public User(String name, String password, int state) {
		this.name = name;
		this.password = password;
		this.state = state;
	}

	public int getId() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", state=" + state + "]";
	}

}
