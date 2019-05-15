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
import com.hjj.pojo.DatingBean;
import com.hjj.service.SearchService;

@Controller
public class SearchControll {
	@Autowired
	private SearchService searchService;
	
	

	// 搜索文章结果页面
	@RequestMapping(value="SearchView",method = RequestMethod.POST)
	public ModelAndView SearchView(HttpServletRequest request) {
		//HttpSession session=request.getSession();
		ModelAndView model = new ModelAndView("common/search");
		 //model.addObject("articleSearch",searchService.getSearchArticle(articleName));
		List<ArticleBean> result = searchService.getSearchArticle(request.getParameter("articleName"));
		model.addObject("article", result);
		return model;
	}

	//搜索文章页面
	@RequestMapping("ArticleSearch")
	public ModelAndView ArticleSearch(){
		ModelAndView model=new ModelAndView("");
		return model;
	}
	// 活动搜索结果页面
	@RequestMapping("DatingSearchView")
	public ModelAndView DatingSearchView() {
		ModelAndView model = new ModelAndView("common/datingSearch");
		// model.addObject("datingSearch",searchService.getSearchDating(datingName));
		return model;
	}

	// 搜索活动接口
	@RequestMapping("SearchDating")
	@ResponseBody
	public List<DatingBean> getSearchDating(@RequestBody String datingName) {
		List<DatingBean> result = searchService.getSearchDating(datingName);
		return result;
	}
}
