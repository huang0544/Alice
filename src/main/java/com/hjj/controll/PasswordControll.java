package com.hjj.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.hjj.service.PasswordService;

@Controller
public class PasswordControll {
	@Autowired
	PasswordService passwordService;
	
	//忘记密码页面
	@RequestMapping("LostPasswordView")
	public ModelAndView LostPasswordView(){
		ModelAndView model=new ModelAndView("LostPassword");
		return model;
	}
	
	//忘记密码接口
	@RequestMapping("LostPassword")
	@ResponseBody
	public int SendPassword(@RequestBody String data){
		String email = JSONObject.parseObject(data).getString("email");
		int result=passwordService.SendPassword(email);
		return result;
	}

}
