package com.woniu.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	static ComboPooledDataSource dataSource;
	
	static{
		dataSource = new ComboPooledDataSource("usersystem");
	}
	public static Connection getConn() throws SQLException{
		Connection conn = dataSource.getConnection();
	return conn;
	}
	public static void closeConn(ResultSet rs,Statement state,Connection conn){
		try {
		if(rs!=null){
				rs.close();
			} 
		if(state!=null){
			state.close();
		}
		if(conn!=null){
			conn.close();
		}
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

