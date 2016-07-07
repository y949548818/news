package com.news.entity;

import java.util.Date;
public class News {
	private int id;
	private String content;
	private String title;
	/**
	 * 图片地址
	 */
	private String imageUrl;
	/**
	 * 评论数量
	 */
	private int commentNumber;
	/**
	 * 是否可以被评论
	 */
	private boolean canComment;

	/**
	 * 审核状态,1:通过审核，2：没有通过审核
	 */
	private int checkState;
	
	public int getCheckState() {
		return checkState;
	}
	public void setCheckState(int checkState) {
		this.checkState = checkState;
	}
	public int getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	private int user_id;

	private String date;

	public boolean isCanComment() {
		return canComment;
	}
	public void setCanComment(boolean canComment) {
		this.canComment = canComment;
	}

	public News(String content, String title, String imageUrl,  int user_id,
			String date) {
		super();
		this.content = content;
		this.title = title;
		this.imageUrl = imageUrl;
		this.user_id = user_id;
		this.date = date;
	}


	public News(int id, String content, String title, String imageUrl, int commentNumber, boolean canComment,
			int user_id, String date) {
		super();
		this.id = id;
		this.content = content;
		this.title = title;
		this.imageUrl = imageUrl;
		this.commentNumber = commentNumber;
		this.canComment = canComment;
		this.user_id = user_id;
		this.date = date;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", content=" + content + ", title=" + title + ", imageUrl=" + imageUrl
				+ ", commentNumber=" + commentNumber + ", canComment=" + canComment + ", user_id=" + user_id + ", date="
				+ date + "]";
	}

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {

		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


}
