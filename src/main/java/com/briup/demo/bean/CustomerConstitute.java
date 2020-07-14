package com.briup.demo.bean;

import javax.persistence.Entity;

/** 
* @author 作者 Aubwls: 
* @version 创建时间：Apr 3, 2020 10:35:51 AM 
* 类说明 
* 
* 额外的工具类
*/

public class CustomerConstitute {
	private String name;
	private Float y;
	private String drilldown;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getY() {
		return y;
	}
	public void setY(Float y) {
		this.y = y;
	}
	public String getDrilldown() {
		return drilldown;
	}
	public void setDrilldown(String drilldown) {
		this.drilldown = drilldown;
	}
	public CustomerConstitute(String name, Float y, String drilldown) {
		super();
		this.name = name;
		this.y = y;
		this.drilldown = drilldown;
	}
	public CustomerConstitute() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerConstitute [name=" + name + ", y=" + y + ", drilldown=" + drilldown + "]";
	}
	
}
