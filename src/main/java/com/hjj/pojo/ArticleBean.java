package com.hjj.pojo;

public class ArticleBean {
	private int articleId;
	private int articleCategoryId;
	private String articleCategoryName;
	private String articleName;
	private String articleSponsorName;
	private String articleSponsorEmail;
	private String articleCreateTime;
	private String articleContent;
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getArticleCategoryId() {
		return articleCategoryId;
	}
	public void setArticleCategoryId(int articleCategoryId) {
		this.articleCategoryId = articleCategoryId;
	}
	public String getArticleCategoryName() {
		return articleCategoryName;
	}
	public void setArticleCategoryName(String articleCategoryName) {
		this.articleCategoryName = articleCategoryName;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public String getArticleSponsorName() {
		return articleSponsorName;
	}
	public void setArticleSponsorName(String articleSponsorName) {
		this.articleSponsorName = articleSponsorName;
	}
	public String getArticleSponsorEmail() {
		return articleSponsorEmail;
	}
	public void setArticleSponsorEmail(String articleSponsorEmail) {
		this.articleSponsorEmail = articleSponsorEmail;
	}
	public String getArticleCreateTime() {
		return articleCreateTime;
	}
	public void setArticleCreateTime(String articleCreateTime) {
		this.articleCreateTime = articleCreateTime;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	@Override
	public String toString() {
		return "Article [ArticleId=" + articleId + ", articleCategoryId=" + articleCategoryId
				+ ", articleCategoryName=" + articleCategoryName + ", articleName=" + articleName
				+ ", articleSponsorName=" + articleSponsorName + ", articleSponsorEmail=" + articleSponsorEmail
				+ ", articleCreateTime=" + articleCreateTime + ", articleContent=" + articleContent + "]";
	}
	
}