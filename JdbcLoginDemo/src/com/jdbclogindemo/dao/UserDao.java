package com.jdbclogindemo.dao;

import com.jdbclogindemo.pojo.User;

public interface UserDao {

	boolean addNewUser(User user);
	boolean checkUserCredentials(User user);
}
