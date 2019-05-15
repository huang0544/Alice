package com.hjj.service;

import java.util.List;

import com.hjj.pojo.CommentBean;

public interface CommentService {
	//添加评论  
	public int AddComment(CommentBean commentbean);
	//删除评论
	public int DeleteComment(int commentId);
	//通articleid获取文章评论
	public List<CommentBean> getCommentByArticleId(int articleId);
}
