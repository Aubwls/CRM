package com.briup.demo.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.demo.bean.Chance;
import com.briup.demo.bean.Role;
import com.briup.demo.bean.User;
import com.briup.demo.service.IChanceService;
import com.briup.demo.service.IUserService;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：2020年4月1日 下午7:18:26 
* 类说明 
*/
@Controller
public class ChanceController {
	@Autowired
	private IChanceService chanceService;
	@Autowired
	private IUserService userService;
	
	private boolean flag = false;
	
	private String customer = null;
	
	private String address = null;
	
	@RequestMapping("toChance")
	public String toRole(HttpSession session) {
		User u = (User) session.getAttribute("user");
		if (!flag) {
			Page<Chance> sales = chanceService.findAllChances(u);
			session.setAttribute("sales", sales);
		}
		Role role = new Role();
		role.setId(4);
		List<User> list = userService.findByRole(role);
		session.setAttribute("UserForSales", list);
		return "pages/sales";
	}
	@RequestMapping("changeChancePage")
	public String changeChancePage(HttpSession session,int pageIndex) {
		Page<Chance> sales = null;
		User u = (User) session.getAttribute("user");
		if(!flag) {
			sales = chanceService.findAllChances(pageIndex,u);
		}else {
			sales = chanceService.findChanceByNameAndAdress(u,customer, address, pageIndex);
		}
		session.setAttribute("sales", sales);
		return "pages/sales";
	}
	

	@RequestMapping("sales/delete")
	@ResponseBody
	public String DeleteRole(String id) {
		chanceService.deleteById(Integer.parseInt(id));
		return "删除成功！";
	}
	
	@RequestMapping("sales/saveAndUpdate")
	@ResponseBody
	public String saveAndUpdate(String id,String source,String customer,String rate,String title,String address,
			String linkman,String phone,String creator,String handler,String description) {
		Chance chance = new Chance();
		chance.setSource(source);
		System.out.println(source+"========"+customer);
		chance.setCustomer(customer);
		chance.setRate(rate);
		chance.setTitle(title);
		chance.setAddress(address);
		chance.setLinkman(linkman);
		System.out.println(phone);
		chance.setPhone(Integer.parseInt(phone));
		User Creator = userService.findByName(creator);
		chance.setCreator(Creator);
		User Handler = new User();
		Handler.setId(Integer.parseInt(handler));
		System.out.println(handler);
		chance.setHandler(Handler);
		chance.setDescription(description);
		chance.setStatus("待处理");
		if(id == null) {
			chanceService.saveAndUpdate(chance);
			return "保存成功！";
		}else {
			chance.setId(Integer.parseInt(id));
			chanceService.saveAndUpdate(chance);
			return "更新成功！";
		}
	}
	
	@RequestMapping("findChance")
	@ResponseBody
	public Chance findChance(Integer id) {
		Chance chance = chanceService.findChanceById(id);
		return chance;
	}
	
	@RequestMapping("chance/reset")
	@ResponseBody
	public String resetChance() {
		flag = false;
		address = null;
		customer = null;
		return "重置成功！";
	}
	
	@RequestMapping("chance/select")
	@ResponseBody
	public String userSelect(String address,String costomerName,HttpSession session) {
		System.out.println(address+"-------"+costomerName);
		this.address = address;
		this.customer = costomerName;
		flag = true;
		User u = (User) session.getAttribute("user");
		Page<Chance> sales = chanceService.findChanceByNameAndAdress(u,costomerName, address, 0);
		session.setAttribute("sales", sales);
		return "查询成功！";
	}
}
