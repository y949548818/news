package com.news.entity;


public class CommentsEnt {
	private int comments_id;
	private String comments_detail;
	private String comments_date;
	private int user_id;
	private int news_id;
	public int getComments_id() {
		return comments_id;
	}
	public void setComments_id(int comments_id) {
		this.comments_id = comments_id;
	}
	public String getComments_detail() {
		return comments_detail;
	}
	public void setComments_detail(String comments_detail) {
		this.comments_detail = comments_detail;
	}
	public String getComments_date() {
		return comments_date;
	}
	public void setComments_date(String comments_date) {
		this.comments_date = comments_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
}
