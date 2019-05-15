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
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.hjj.pojo.ArticleBean;
import com.hjj.pojo.CategoryBean;
import com.hjj.service.ArticleService;
import com.hjj.service.CategoryService;
import com.hjj.service.CommentService;

@Controller
public class ArticleControll {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CommentService commentService;

	// ������ҳ
	@RequestMapping("ArticleView")
	public ModelAndView ArticleView(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("common/Article");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("categoryId", request.getParameter("categoryId"));
		model.addObject("categoryName", request.getParameter("categoryName"));
		model.addObject("categoryIntroduce", request.getParameter("categoryIntroduce"));
		model.addObject("allArticle",
				articleService.getArticleByCategoryId(Integer.parseInt(request.getParameter("categoryId"))));
		return model;
	}

	// ͨ�����id��ȡ����
	@RequestMapping("ArticleByCategoryId")
	@ResponseBody
	public List<ArticleBean> getArticleByCategoryId(@RequestBody int categoryId) {
		List<ArticleBean> result = articleService.getArticleByCategoryId(categoryId);
		return result;
	}

	// ��������
	@RequestMapping("ArticleDetailView")
	public ModelAndView ArticleDetailView(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("common/ArticleDetail");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("categoryName", request.getParameter("categoryName"));
		model.addObject("categoryIntroduce", request.getParameter("categoryIntroduce"));
		model.addObject("articleDetail",
				articleService.getArticleById(Integer.parseInt(request.getParameter("articleId"))));
		model.addObject("comment",
				commentService.getCommentByArticleId(Integer.parseInt(request.getParameter("articleId"))));
		model.addObject("commentArticleId", request.getParameter("articleId"));
		return model;
	}

	// ͨ������id��ȡ����
	@RequestMapping("ArticleById")
	@ResponseBody
	public ArticleBean getArticleById(@RequestBody int articleId) {
		ArticleBean result = articleService.getArticleById(articleId);
		return result;
	}

	// ��������ҳ��
	@RequestMapping(value = "AddArticleView")
	public ModelAndView AddArticleView(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("common/AddArticle");
		model.addObject("allCategory", categoryService.getAllCatetory());
		System.out.println(categoryService.getAllCatetory());
		model.addObject("categoryId", request.getParameter("categoryId"));
		model.addObject("categoryName", request.getParameter("categoryName"));
		model.addObject("categoryIntroduce", request.getParameter("categoryIntroduce"));
		return model;
	}

	// ��������
	@RequestMapping(value = "AddArticle", method = { RequestMethod.POST })
	@ResponseBody
	public int addArticle(@RequestBody ArticleBean article, HttpServletRequest request) {
		HttpSession session = request.getSession();
		article.setArticleSponsorName((session.getAttribute("userName").toString()));
		article.setArticleSponsorEmail((session.getAttribute("userEmail").toString()));
		int result = articleService.addArticle(article);
		return result;
	}

	// �ҷ��������
	@RequestMapping("ArticleByUserView")
	public ModelAndView ArticleManagementView(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView("common/ArticleByUser");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("articleManage",
				articleService.getArticleBySponsorEmail(session.getAttribute("userEmail").toString()));
		return model;
	}

	// �ҷ������������
	@RequestMapping("ArticleByUserDetail")
	public ModelAndView ArticleManagementDetail(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("common/ArticleByUserDetail");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("articleManagementDetail",
				articleService.getArticleById(Integer.parseInt(request.getParameter("articleId"))));
		return model;
	}

	// ɾ�����½ӿ�
	@RequestMapping("DeleteArticle")
	@ResponseBody
	public int deleteArticle(@RequestBody String data) {
		String Id=JSONObject.parseObject(data).getString("articleId");
		int articleId=Integer.parseInt(Id);
		int result = articleService.deleteArticle(articleId);
		return result;
	}

	// �������½ӿ�
	@RequestMapping("UpdateArticle")
	@ResponseBody
	public int updateArticle(@RequestBody ArticleBean article) {
		int result = articleService.updateArticle(article);
		return result;
	}

	
	

}
