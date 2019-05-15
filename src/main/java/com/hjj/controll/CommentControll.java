package com.hjj.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hjj.pojo.CommentBean;
import com.hjj.service.CommentService;

@Controller
public class CommentControll {
	@Autowired
	CommentService commentService;
	
	//添加评论接口
	@RequestMapping("AddComment")
	@ResponseBody
	public int AddComment(@RequestBody CommentBean commentbean,HttpServletRequest request){
		HttpSession session = request.getSession();
		commentbean.setCommentByEmail((session.getAttribute("userEmail").toString()));
		commentbean.setCommentByName((session.getAttribute("userName").toString()));
		int result=commentService.AddComment(commentbean);
     	return result;
	}
	//删除评论
	@RequestMapping("DeleteComment")
	@ResponseBody
	public int DeleteComment(@RequestBody String data){
		String Id=JSONObject.parseObject(data).getString("commentId");
		int commentId=Integer.parseInt(Id);
		int result=commentService.DeleteComment(commentId);
		return result;
	}
	
	
	//获取文章评论
	@RequestMapping("GetCommentByArticleId")
	@ResponseBody
	public List<CommentBean> getCommentByArticleId(@RequestBody int articleId){
		List<CommentBean> result=commentService.getCommentByArticleId(articleId);
		return result;
	}

}
