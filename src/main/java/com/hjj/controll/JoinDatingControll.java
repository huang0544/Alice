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
import com.hjj.pojo.JoinDatingBean;
import com.hjj.service.CategoryService;
import com.hjj.service.JoinDatingService;

@Controller
public class JoinDatingControll {
	@Autowired
	JoinDatingService joinDatingService;
	@Autowired
	CategoryService categoryService;
	
	//��ӲμӼ�¼�ӿ�
	@RequestMapping("AddJoinDating")
	@ResponseBody
	public int addJoinDating(@RequestBody JoinDatingBean joinDatingbean,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		joinDatingbean.setJoinUserName((session.getAttribute("userName").toString()));
		joinDatingbean.setJoinUserEmail((session.getAttribute("userEmail").toString()));
		joinDatingbean.setJoinUserIphone((session.getAttribute("iphone").toString()));
		joinDatingbean.setJoinUserSex((session.getAttribute("sex").toString()));
		int result=joinDatingService.addJoinDating(joinDatingbean);
		return result;
	}
	
	//ɾ���μӼ�¼�ӿ�
	@RequestMapping("DeleteJoinDating")
	@ResponseBody
	public int deleteJoinDating(@RequestBody String data){
		String Id = JSONObject.parseObject(data).getString("joinId");
		int joinId=Integer.parseInt(Id);
		int result=joinDatingService.deleteJoinDating(joinId);
		System.out.println(joinId);
		return result;
	}
	
	//�����û�email��ѯ�μӼ�¼
	@RequestMapping("GetJoinDatingByUserEamil")
	@ResponseBody
	public List<JoinDatingBean> getJoinDatingByUserEamil(@RequestBody String joinDatingUserEmail){
		List<JoinDatingBean> result=joinDatingService.getJoinDatingByUserEamil(joinDatingUserEmail);
		return result;
	}
	
	//���ݻid��ѯ�μӼ�¼
	@RequestMapping("GetJoinDatingByDatingId")
	@ResponseBody
	public List<JoinDatingBean> getJoinDatingByDatingId(@RequestBody int datingId){
		List<JoinDatingBean> result=joinDatingService.getJoinDatingByDatingId(datingId);
		return result;
	}
	//�Ҳμӻҳ��
		@RequestMapping("DatingByUser")
		public ModelAndView DatingManageView(HttpServletRequest request){
			HttpSession session=request.getSession();
			ModelAndView model=new ModelAndView("common/DatingByUser");
			model.addObject("allCategory", categoryService.getAllCatetory());
			model.addObject("DatingManage",joinDatingService.getJoinDatingByUserEamil((session.getAttribute("userEmail").toString())));
			return model;
		}
		
		//�Ҳμӻ����ҳ��
		@RequestMapping("DatingByUserDetail")
		public ModelAndView DatingManageDetail(HttpServletRequest request){
			ModelAndView model=new ModelAndView("common/DatingByUserDetail");
			model.addObject("allCategory",categoryService.getAllCatetory());
			model.addObject("datingDetail", joinDatingService.getJoinDatingByJoinId(Integer.parseInt(request.getParameter("joinId"))));
			return model;
		}
		



}
