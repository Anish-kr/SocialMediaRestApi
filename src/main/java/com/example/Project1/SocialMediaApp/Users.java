package com.example.Project1.SocialMediaApp;

import java.lang.*;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;





public class Users {

	
	private Integer id;
	
	@Size(min=2,message="minimum two characters required")
	private String name;
	
	@Size(max=1,message="M=male, F=Female, O=Others")
	private String Gender;
	
	@PositiveOrZero
	private Integer age;
	
	public Users(Integer id, String name, String gender, Integer age) {
		super();
		this.id = id;
		this.name = name;
		Gender = gender;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", Gender=" + Gender + ", age=" + age + "]";
	}
	
	
}
