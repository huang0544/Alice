package com.hjj.controll;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hjj.pojo.UserBean;
import com.hjj.service.CategoryService;
import com.hjj.service.LoginAndRegisterService;
import com.hjj.util.SendEmail;

@Controller
public class LoginAndRegisterControll {
	@Autowired
	private LoginAndRegisterService loginAndRegisterService;
	@Autowired
	private CategoryService categoryService;
	//µÇÂ¼Ò³Ãæ
	@RequestMapping("LoginView")
	public ModelAndView LoginView(){
		ModelAndView model=new ModelAndView("login");
		return model;
	}
	//µÇÂ¼ÇëÇó
	@RequestMapping("Login")
	@ResponseBody
	public int Login(@RequestBody UserBean userBean,HttpServletRequest request){
		int result = loginAndRegisterService.Login(userBean.getEmail(), userBean.getPassword(),request);
		return result;
	}
	//Ö÷Ò³Ò³Ãæ
	@RequestMapping("Home")
	public ModelAndView Home(){
		ModelAndView model = new ModelAndView("common/index");
		model.addObject("allCategory", categoryService.getAllCatetory());
		return model;
	}
	//×¢²áÇëÇó
	@RequestMapping("RegisterApply")
	@ResponseBody
	public int RegisterApply(@RequestBody UserBean userBean){
		int result = loginAndRegisterService.RegisterApply(userBean);
		return result;
	}
	//×¢²áÒ³Ãæ
	@RequestMapping("RegisterView")
	public ModelAndView RegisterView(){
		ModelAndView model=new ModelAndView("sign_up");
		return model;
	}
	//×¢²áÈ·ÈÏÇë
	@RequestMapping("RegisterSure")
	public ModelAndView RegisterSure(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int result=loginAndRegisterService.RegisterSure(request);
		ModelAndView modelAndView = new ModelAndView("login");
		if(result==1){
			modelAndView.addObject("registerInfo", "×¢²á³É¹¦£¬ÇëµÇÂ¼£¡");
		}else{
			modelAndView.addObject("registerInfo", "×¢²áÊ§°Ü£¬ÇëÖØÐÂ×¢²á£¡");
		}
		return modelAndView;
	}
}
