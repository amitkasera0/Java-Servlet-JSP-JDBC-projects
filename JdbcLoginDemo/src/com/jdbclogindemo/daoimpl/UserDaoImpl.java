package com.jdbclogindemo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbclogindemo.connection.DbConnection;
import com.jdbclogindemo.dao.UserDao;
import com.jdbclogindemo.pojo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean addNewUser(User user) {
		try(Connection con = 
		DbConnection.getDatabaseConnection()) {
			PreparedStatement pst = con.prepareStatement(
			"INSERT INTO userdata VALUES (?,?)");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			int count = pst.executeUpdate();
			if(count > 0)
				return true;
			else
				return false;
		} catch(SQLException | NullPointerException exc) {
			exc.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean checkUserCredentials(User user) {
		try(Connection con = 
			DbConnection.getDatabaseConnection()) {
			PreparedStatement pst = con.prepareStatement(
			"SELECT * FROM userdata WHERE username = ?"
			+ " AND password = ?");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			ResultSet rs = pst.executeQuery();
			if(rs.isBeforeFirst())
				return true;
			else
				return false;
			} 
			catch(SQLException | NullPointerException exc){
				exc.printStackTrace();
				return false;
			}
	}
}
