package com.hjj.pojo;

public class CommentBean {
	private int commentId;
	private int commentArticleId;
	private String commentContent;
	private String commentByName;
	private String commentByEmail;
	private String commentCreateTime;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getCommentArticleId() {
		return commentArticleId;
	}
	public void setCommentArticleId(int commentArticleId) {
		this.commentArticleId = commentArticleId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentByName() {
		return commentByName;
	}
	public void setCommentByName(String commentByName) {
		this.commentByName = commentByName;
	}

	public String getCommentByEmail() {
		return commentByEmail;
	}
	public void setCommentByEmail(String commentByEmail) {
		this.commentByEmail = commentByEmail;
	}
	public String getCommentCreateTime() {
		return commentCreateTime;
	}
	public void setCommentCreateTime(String commentCreateTime) {
		this.commentCreateTime = commentCreateTime;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentArticleId=" + commentArticleId + ", commentContent="
				+ commentContent + ", commentByName=" + commentByName + ", commentByEmail=" + commentByEmail
				+ ", commentCreateTime=" + commentCreateTime + "]";
	}
}
