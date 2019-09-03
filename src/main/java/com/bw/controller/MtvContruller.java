package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.bean.Mtv;
import com.bw.bean.Types;
import com.bw.mapper.MtvMapper;
import com.bw.service.MtvService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @a作者wb
 *
 * @时间2019年9月3日
 */
@Controller
public class MtvContruller {
	
	@Resource
	private MtvService service;

	
	@RequestMapping("list.do")
	public String listMtv(Model model,String name,
			Integer pageNum) {
		
		if(pageNum==null){
			pageNum=1;
		}
		
		
		//进行模糊查询
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("names", name);
		
		
		//设置分页
		Page<Object> startPage = PageHelper.startPage(pageNum, 4);
		
		List<Map<String, Object>> selectMtvList = service.selectMtvList(map);
		PageInfo<Map<String, Object>> info = new PageInfo<Map<String,Object>>(selectMtvList);
		
		model.addAttribute("info", info);
		
		return "list";
	}
	
	
/**
 * 查询所有影视类型
 * @return 
 * 	
 */
	@RequestMapping("selectType.do")
	@ResponseBody
	public List<Types> selectType(){
		
		//获取数据
		List<Types> listTypes= service.selectType();	
		return listTypes;
	}
	
	/**
	 * 添加影视
	 * @return 
	 */
	@RequestMapping("addMtv.do")
	@ResponseBody
	public boolean addMtv(Mtv mtv,Integer tid){
		
		//添加影视
		int num  = service.addMtv(mtv);
		//获取添加的主键
		Integer mid = mtv.getMid();
		//设置map存入影视主键以及类型主键
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mid", mid);
		map.put("tid", tid);
		
		//添加中间表
		int num1 =service.addMtvTypes(map);
		
		return true;
		
	}
	
/**
 * 批量删除影视	
 * @return 
 */
	@RequestMapping("deleteMtv.do")
	@ResponseBody
	public boolean deleteMtv(String str){
		String[] split = str.split(",");
		
		int num = service.deleteMtv(split);
		
		//删除中间表
		int num2 = service.deleteMtvType(split);
		
		return true;
	}
	
/**
 * 修改影视。进行回显
 * @return 
 */
	@RequestMapping("updateMtv.do")
	public String updateMtv(Model model,Integer mid){
		
		model.addAttribute("mid", mid);
		
		return "updateMtv";
		
	}
	
	/**
	 * 查询一条数据,进行数据回显
	 * @return 
	 */
	
	@RequestMapping("selectMtvByID.do")
	@ResponseBody
	public Map<String, Object> selectMtvByID(Integer mid){
		Map<String, Object>maps = service.selectMtvByID(mid);
		
		return maps;
		
	}
	/**
	 * 数据修改
	 */
	
	@RequestMapping("updataMtv.do")
	@ResponseBody
	public boolean updateMtv(Mtv mtv){
		
		int num = service.updateMtv(mtv);
		return true;
	}
	
	
	
	//安全状态页面跳转
	@RequestMapping("toAddMtv.do")
	public String toAddMtv(){
		return "addMtv";
	}
	
	
	
	
	
	

}
