package com.example.Project1.SocialMediaApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DaoService {

	
	private static List<Users> users=new ArrayList<>();
	private static int count =0;
	static {
		users.add(new Users(++count,"anish","M",28));
		users.add(new Users(++count,"manish","M",29));
		users.add(new Users(++count,"kanish","F",23));
		users.add(new Users(++count,"fanish","F",24));
		users.add(new Users(++count,"sanish","F",27));
	}
	
	public List<Users> allUserList() {
		// TODO Auto-generated method stub
		return users;
	}

	public Users oneUser(int id) {
		// TODO Auto-generated method stub
		for(Users user:users)
		{
			if(user.getId().equals(id)) return user;
			
		}
		return null;
	}

	public Users addOneUser(Users user) {
		user.setId(++count);
		users.add(user);
		return user;
	}

	public void deleteOneUser(int id) {
		// TODO Auto-generated method stub
		int i=0;
		for(Users user:users)
		{
			if(user.getId().equals(id))
				users.remove(i);
			i++;
		}
	}

	
}
