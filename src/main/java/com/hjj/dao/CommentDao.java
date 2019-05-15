package com.hjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hjj.pojo.CommentBean;

@Repository
public interface CommentDao {
	//�������  
	public int AddComment(CommentBean commentbean);
	//ɾ������
	public int DeleteComment(@Param("commentId") int commentId);
	//ͨarticleid��ȡ��������
	public List<CommentBean> getCommentByArticleId(@Param("articleId")int articleId);
}
