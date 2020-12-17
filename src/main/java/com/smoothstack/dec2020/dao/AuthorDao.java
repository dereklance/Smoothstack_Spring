package com.smoothstack.dec2020.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.smoothstack.dec2020.model.Author;

@Component
public class AuthorDao {
	
	public Connection conn = AuthorDatabase.getConnection();
	
	public ResultSet executeQuery(String query) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(query);
			return results.next() ? results : null;
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
		return null;
	}
	

	public Author getAuthorById(int id) {
		ResultSet results = executeQuery("select * from Authors where id = " + id);
		try {
			return results == null ? null : new Author(results.getString("name"), results.getInt("id"));
		} catch (SQLException e) {
			return null;
		}
	}
	
	public List<Author> getAuthors() {
		ResultSet results = executeQuery("select * from Authors");
		List<Author> authors = new ArrayList<>();
		
		try {
			do {
				String name = results.getString("name");
				Integer id = results.getInt("id");
				authors.add(new Author(name, id));
			} while (results.next());
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
		return authors;
	}
}
