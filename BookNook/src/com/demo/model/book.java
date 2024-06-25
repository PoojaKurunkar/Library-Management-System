package com.demo.model;

public class book {
	private int id;
	private String title;
	private String authorName;
	private String publisher;
	
	private String description;
	private int userId;
	public book(String title, String authorName, String publisher, String description, int userId) {
		super();
		this.title = title;
		this.authorName = authorName;
		this.publisher = publisher;
		this.description = description;
		this.userId = userId;
	}
	public book() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}

