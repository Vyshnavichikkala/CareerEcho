package com.srivasavi.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("user")
public class User {
    @Id
    private String id;
    private String username;
    @Indexed(unique = true)
    private String email;
    private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	} 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}