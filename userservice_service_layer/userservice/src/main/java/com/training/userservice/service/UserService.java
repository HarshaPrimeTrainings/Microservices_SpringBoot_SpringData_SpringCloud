package com.training.userservice.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.training.userservice.dao.User;

@Service
public class UserService {
	List<User> userlist = new ArrayList<User>();
	
	UserService(){
	userlist.add(new User(1, "vivek", "Hyd", "vivek@gmail.com"));
	userlist.add(new User(2, "anand", "Bang", "anand@gmail.com"));
	userlist.add(new User(3, "ryan", "NY", "ryan@gmail.com"));
	userlist.add(new User(4, "bob", "chennai", "bob@gmail.com"));
	userlist.add(new User(5, "melisa", "chicago", "melisa@gmail.com"));
	}
	
	
	public List<User> getUsers(){
		return userlist;
	}
	
	public User getUserById(int userid) {
		return userlist.stream()
				.filter(usr -> usr.getUserId() == userid).findAny()
				.orElseThrow(()->new RuntimeException("User Not Found"));
	}
	
	public User addUser(User user) {
		userlist.add(user);
		return getUserById(user.getUserId());
	}
	
	public User updateUser(int usertId,User user) {
		User existingUser=  getUserById(usertId);
		if(existingUser!=null) {
			existingUser.setUserName(user.getUserName());
			existingUser.setAddr(user.getAddr());
			existingUser.setEmail(user.getEmail());
		}
		return existingUser;
	}
	
	public User updatePatch(int usertId,User user) {
		User existingUser= getUserById(usertId);
		if(existingUser!=null) {
			existingUser.setUserName(user.getUserName()!=null?user.getUserName():existingUser.getUserName());
			existingUser.setAddr(user.getAddr()!=null?user.getAddr():existingUser.getAddr());
			existingUser.setEmail(user.getEmail()!=null?user.getEmail():existingUser.getEmail());
		}
		return user;
	}
	
	public User updatePatchReflection(int userid,Map<String, String> feildMap) {
		User existingUser = getUserById(userid);

		Set<String> feildSet = feildMap.keySet();
		
		// Regular for loop
		for (String userFeild : feildSet) {
			Field field = ReflectionUtils.findField(User.class, userFeild);
			field.setAccessible(true);
			ReflectionUtils.setField(field, existingUser, feildMap.get(userFeild));
		}

		// Stream api
		feildMap.forEach((k, v) -> {
			Field field = ReflectionUtils.findField(User.class, k);
			field.setAccessible(true);
			ReflectionUtils.setField(field, existingUser, v);
		});

		return existingUser;
	}
	
	public String deleteUser(int userid) {
		User existingUser = getUserById(userid);
		userlist.remove(existingUser);	 
		return "User Deleted with UserID :: "+userid;
	}
	
	
	
}
