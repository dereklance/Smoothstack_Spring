package com.smoothstack.dec2020.model;

public class Author {
	String name;
	int authorId;

	public Author(String name, int id) {
		this.name = name;
		this.authorId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
}
