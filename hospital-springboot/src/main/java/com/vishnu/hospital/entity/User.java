package com.vishnu.hospital.entity;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.vishnu.hospital.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Set<Role> roles;
	
	@Column(name = "email")
    private String email;

    @Column(name = "mobileNumber")
    private String mobileNumber;
    
    @Column(name = "confirmPassword")
    private String confirmPassword;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(int id, String username, String password, Set<Role> roles, String email,
			String mobileNumber, String confirmPassword) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.confirmPassword = confirmPassword;
	}

	

	public String getEmail() {
		return email;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream()
				    .map(role -> new SimpleGrantedAuthority(role.name()))
				    .collect(Collectors.toList());
	}



}
