///**
// * 
// */
//package com.smoothstack.airlines.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import com.mysql.jdbc.Driver;
//
///**
// * @author dlance handles connection to MySQL database
// */
//public class AirlinesConnector {
//
//	public static final String url = "jdbc:mysql://smoothstack-project.cqxybfmjssty.us-east-2.rds.amazonaws.com:3306/utopia";
//	public static final String username = "admin";
//	public static final String password = "password";
//
//	/*
//	 * Get a connection to database
//	 * 
//	 * @return Connection object
//	 */
//	public static Connection getConnection() {
//		try {
//			DriverManager.registerDriver(new Driver());
//			return DriverManager.getConnection(url, username, password);
//		} catch (SQLException ex) {
//			throw new RuntimeException("Error connecting to the database", ex);
//		}
//	}
//
//}
