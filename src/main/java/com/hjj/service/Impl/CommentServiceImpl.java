package com.hjj.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hjj.dao.CommentDao;
import com.hjj.pojo.CommentBean;
import com.hjj.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;

	@Override
	public int AddComment(CommentBean commentbean) {
		return commentDao.AddComment(commentbean);
	}

	@Override
	public int DeleteComment(int commentId) {
		return commentDao.DeleteComment(commentId);
	}

	@Override
	public List<CommentBean> getCommentByArticleId(int articleId) {
		return commentDao.getCommentByArticleId(articleId);
	}

}
