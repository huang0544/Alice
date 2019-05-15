package com.hjj.controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hjj.pojo.DatingBean;
import com.hjj.service.ArticleService;
import com.hjj.service.CategoryService;
import com.hjj.service.CommentService;
import com.hjj.service.DatingService;
import com.hjj.service.UsersService;

@Controller
public class ManagementControll {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private DatingService datingService;
	@Autowired
	private UsersService usersService;

	// ��̨������ҳ
	@RequestMapping("Admin/ManagementView")
	public ModelAndView MaanagementView() {
		ModelAndView model = new ModelAndView("admin/Management");
		model.addObject("allCategory", categoryService.getAllCatetory());
		return model;
	}

	// ���¹���ҳ��
	@RequestMapping("ArticleManagementView")
	public ModelAndView ManagementView(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("admin/ArticleManagement");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("categoryId", request.getParameter("categoryId"));
		model.addObject("categoryName", request.getParameter("categoryName"));
		model.addObject("categoryIntroduce", request.getParameter("categoryIntroduce"));
		model.addObject("allArticle",
				articleService.getArticleByCategoryId(Integer.parseInt(request.getParameter("categoryId"))));
		return model;
	}

	// ���¹�������ҳ��
	@RequestMapping("ArticleManagementDetailView")
	public ModelAndView ArticleManagementDetailView(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("admin/ArticleManagementDetail");
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

	// �����ҳ��
	@RequestMapping("DatingManagementView")
	public ModelAndView DatingManagementView() {
		ModelAndView model = new ModelAndView("admin/DatingManagement");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("allDating", datingService.GetAllDating());
		return model;
	}

	// ���������ҳ��
	@RequestMapping("DatingManagementDetailView")
	public ModelAndView DatingManagementDetailView(HttpServletRequest request) {
		DatingBean datingBean = new DatingBean();
		ModelAndView model = new ModelAndView("admin/DatingManagementDetail");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("dating", datingService.GetDatingByDatingId(Integer.parseInt(request.getParameter("datingId"))));
		return model;
	}

	// �û�����ҳ��
	@RequestMapping("UserManagementView")
	public ModelAndView UserManagementView() {
		ModelAndView model = new ModelAndView("admin/UserManagement");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("allUsers", usersService.getAllUsers());
		return model;
	}

	// �û���������ҳ��
	@RequestMapping("UserManagementDetailView")
	public ModelAndView UserManagementDetailView(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView("admin/UserManagementDetail");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("User",usersService.getUserByEmail(request.getParameter("email")));
		return model;
	}

}
