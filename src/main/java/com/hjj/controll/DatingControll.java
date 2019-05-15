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

	// ��������ҳ��
	@RequestMapping("AddDatingView")
	public ModelAndView AddDatingView() {
		ModelAndView model = new ModelAndView("common/AddDating");

		return model;
	}

	// ���������ӿ�
	@RequestMapping("AddDating")
	@ResponseBody
	public int AddDating(@RequestBody DatingBean datingbean, HttpServletRequest request) {
		HttpSession session = request.getSession();
		datingbean.setDatingSponsorName((session.getAttribute("userName").toString()));
		datingbean.setDatingSponsorEmail((session.getAttribute("userEmail").toString()));
		int result = datingService.AddDating(datingbean);
		return result;
	}

	// ɾ����ӿ�
	@RequestMapping("DeleteDating")
	@ResponseBody
	public int DeleteDating(@RequestBody String data) {
		String Id = JSONObject.parseObject(data).getString("datingId");
		int datingId = Integer.parseInt(Id);
		int result = datingService.DeleteDating(datingId);
		return result;
	}

	// ���»�ӿ�
	@RequestMapping("UpdateDating")
	@ResponseBody
	public int UpdateDating(@RequestBody DatingBean dating, HttpServletRequest request) {
		dating.getDatingId();
		dating.getDatingName();
		dating.getDatingContent();
		int result = datingService.UpdateDating(dating);
		return result;
	}

	// ͨ�������߻�ȡ�
	@RequestMapping("GetDatingBySponsorEmail")
	@ResponseBody
	public List<DatingBean> GetDatingBySponsorEmail(@RequestBody String sponsorEmail) {
		List<DatingBean> result = datingService.GetDatingBySponsorEmail(sponsorEmail);
		return result;
	}

	// ��ȡ���л��ҳ
	@RequestMapping("GetAllDating")
	@ResponseBody
	public List<DatingBean> GetAllDating() {
		List<DatingBean> result = datingService.GetAllDating();
		return result;
	}

	// ������ҳ
	@RequestMapping("DatingView")
	public ModelAndView DatingView() {
		ModelAndView model = new ModelAndView("common/DatingModule");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("allDating", datingService.GetAllDating());
		return model;
	}

	// ͨ��id��ѯ�
	@RequestMapping("GetDatingByDatingId")
	@ResponseBody
	public DatingBean GetDatingByDatingId(@RequestBody int datingId) {
		DatingBean result = datingService.GetDatingByDatingId(datingId);
		return result;
	}

	// �����ҳ��
	@RequestMapping("DatingDetailView")
	public ModelAndView DatingDetailView(HttpServletRequest request) {
		//DatingBean datingBean = new DatingBean();
		ModelAndView model = new ModelAndView("common/Dating_Detail");
		model.addObject("allCategory", categoryService.getAllCatetory());
		model.addObject("dating", datingService.GetDatingByDatingId(Integer.parseInt(request.getParameter("datingId"))));
		return model;
	}

	// �ҷ����Ļҳ��
	@RequestMapping("DatingBySponsorEmailView")
	public ModelAndView DatingBySponsorEmail(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView("common/DatingBySponsorEmail");
		model.addObject("datingBySponsorEmail",
				datingService.GetDatingBySponsorEmail(session.getAttribute("userEmail").toString()));
		return model;
	}

	// �ҷ����Ļ����
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
