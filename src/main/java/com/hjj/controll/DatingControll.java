package com.hjj.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.hjj.pojo.DatingBean;
import com.hjj.service.CategoryService;
import com.hjj.service.DatingService;
import com.hjj.service.JoinDatingService;

@Controller
public class DatingControll {
	@Autowired
	DatingService datingService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	JoinDatingService joinDatingService;

	// 户外活动发帖页面
	@RequestMapping("AddDatingView")
	public ModelAndView AddDatingView() {
		ModelAndView model = new ModelAndView("common/AddDating");

		return model;
	}

	// 户外活动发帖接口
	@RequestMapping("AddDating")
	@ResponseBody
	public int AddDating(@RequestBody DatingBean datingbean, HttpServletRequest request) {
		HttpSession session = request.getSession();
		datingbean.setDatingSponsorName((session.getAttribute("userName").toString()));
		datingbean.setDatingSponsorEmail((session.getAttribute("userEmail").toString()));
		int result = datingService.AddDating(datingbean);
		return result;
	}

	// 删除活动接口
	@RequestMapping("DeleteDating")
	@ResponseBody
	public int DeleteDating(@RequestBody String data) {
		String Id = JSONObject.parseObject(data).getString("datingId");
		int datingId = Integer.parseInt(Id);
		int result = datingService.DeleteDating(datingId);
		return result;
	}

	// 更新活动接口
	@RequestMapping("UpdateDating")
	@ResponseBody
	public int UpdateDating(@RequestBody DatingBean dating, HttpServletRequest request) {
		dating.getDatingId();
		dating.getDatingName();
		dating.getDatingContent();
		int result = datingService.UpdateDating(dating);
		return result;
	}

	// 通过发起者获取活动
	@RequestMapping("GetDatingBySponsorEmail")
	@ResponseBody
	public List<DatingBean> GetDatingBySponsorEmail(@RequestBody String sponsorEmail) {
		List<DatingBean> result = datingService.GetDatingBySponsorEmail(sponsorEmail);
		return result;
	}

	// 获取所有活动主页
	@RequestMapping("GetAllDating")
	@ResponseBody
	public List<DatingBean> GetAllDating() {
		List<DatingBean> result = datingService.GetAllDating();
		return result;
	}

	// 户外活动主页
	@RequestMapping("DatingView")
	public ModelAndView DatingView() {
		ModelAndView model = new ModelAndView("common/DatingModule");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("allDating", datingService.GetAllDating());
		return model;
	}

	// 通过id查询活动
	@RequestMapping("GetDatingByDatingId")
	@ResponseBody
	public DatingBean GetDatingByDatingId(@RequestBody int datingId) {
		DatingBean result = datingService.GetDatingByDatingId(datingId);
		return result;
	}

	// 活动详情页面
	@RequestMapping("DatingDetailView")
	public ModelAndView DatingDetailView(HttpServletRequest request) {
		//DatingBean datingBean = new DatingBean();
		ModelAndView model = new ModelAndView("common/Dating_Detail");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("dating", datingService.GetDatingByDatingId(Integer.parseInt(request.getParameter("datingId"))));
		return model;
	}

	// 我发布的活动页面
	@RequestMapping("DatingBySponsorEmailView")
	public ModelAndView DatingBySponsorEmail(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView("common/DatingBySponsorEmail");
		model.addObject("datingBySponsorEmail",
				datingService.GetDatingBySponsorEmail(session.getAttribute("userEmail").toString()));
		return model;
	}

	// 我发布的活动详情
	@RequestMapping("DatingBySponsorEmailDetailView")
	public ModelAndView DatingBySponsorEmailDetailView(HttpServletRequest request) {
		DatingBean dating=new DatingBean();
		ModelAndView model = new ModelAndView("common/DatingBySponsorEmailDetail");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("dating", datingService.GetDatingByDatingId(Integer.parseInt(request.getParameter("datingId"))));
		model.addObject("joinDatingUser",
				joinDatingService.getJoinDatingByDatingId(Integer.parseInt(request.getParameter("datingId"))));
		model.addObject("datingId",Integer.parseInt(request.getParameter("datingId")));
		return model;
	}

}
