package com.hjj.service;

import java.util.List;

import com.hjj.pojo.CommentBean;

public interface CommentService {
	//�������  
	public int AddComment(CommentBean commentbean);
	//ɾ������
	public int DeleteComment(int commentId);
	//ͨarticleid��ȡ��������
	public List<CommentBean> getCommentByArticleId(int articleId);
}
