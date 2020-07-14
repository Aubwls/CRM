package com.briup.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年3月27日 下午12:46:35 
* 类说明 用户管理模块
*/
@Controller
public class CustomerController {
	
	
	@RequestMapping("toCustomer")
	public String toCustomer() {
		return "customer";
	}
}
