package com.service;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DB;
import com.model.User;

public class UserServiceImpl implements UserService {

	@Override
	public void signup(User u) {
		String sql = "insert into user(fname,lname,username,password) values('"+u.getFname()+"','"+u.getLname()+"','"+u.getUsername()+"','"+u.getPassword()+"')";
		try {
		Statement stm = DB.getDBCon().createStatement();
		stm.execute(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean login(String un, String psw) {
		
		
		String sql = "select * from user where username = '"+un+"' and password = '"+psw+"' ";
		try {
			
			Statement stm = DB.getDBCon().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		
			List<User> ulist = new ArrayList<>();
			
			String sql = "select * from user";
			try {
				
				Statement stm = DB.getDBCon().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					User u = new User();
					u.setId(rs.getInt("id"));
					u.setFname(rs.getString("fname"));
					u.setLname(rs.getString("lname"));
					u.setUsername(rs.getString("username"));
					u.setPassword(rs.getString("password"));
					
					ulist.add(u);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return ulist;
	}

}
