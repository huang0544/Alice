package com.hjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hjj.pojo.CommentBean;

@Repository
public interface CommentDao {
	//添加评论  
	public int AddComment(CommentBean commentbean);
	//删除评论
	public int DeleteComment(@Param("commentId") int commentId);
	//通articleid获取文章评论
	public List<CommentBean> getCommentByArticleId(@Param("articleId")int articleId);
}
