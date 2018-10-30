package com.java.controller;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dao.MaterialDao;
//import com.java.dao.MaterialDao;
import com.java.entity.Material;
import static org.springframework.data.mongodb.core.query.Criteria.where;


@Controller
@RequestMapping("/search")
public class MaterialController {
	
	
	
	
	@Autowired
	private MongoTemplate mongoOperations;
	
	@Autowired
	private MaterialDao materialDao;
	
	
	
	/**
	 * 通过id搜索
	 * @return
	 */
	@RequestMapping("/searchid")
	
	public String searchid(HttpServletRequest request,Map<String, Object>map) {
	//返回多个数值
	//org.springframework.data.mongodb.core.query.Query query= query(where("material_id").is("mp-976010"));

	//List<Material> ret= mongoOperations.find(query,Material.class);
	//return ret;
	//返回单个数值
	//Criteria criteria= where("material_id").is("mp-976010");
	//Query query = new Query(criteria);
	//Material p= mongoOperations.findOne(query,Material.class);
	//return p;
		
		String materialid=request.getParameter("materialid");
		System.out.println(materialid);
		List<Material> list= materialDao.findByMaterialid(materialid);
		System.out.println(list);
		map.put("mes",list );
	    return "bm";
		

	

	}
	@RequestMapping("/searchformula")
	
	public String searchformyla(HttpServletRequest request,Map<String, Object>map) {
		String prettyformula=request.getParameter("prettyformula");
		System.out.println(prettyformula);
		List<Material> list1= materialDao.findByPrettyformula(prettyformula);
		System.out.println(list1);
		map.put("mes",list1 );
	    return "bm";
		

		

		}
	

//	@RequestMapping("/searchelements")
//	
//	public String searchelements(HttpServletRequest request,Map<String, Object>map) {
//		String elements=request.getParameter("elements");
//		System.out.println(elements);
//		List<Material> list1= materialDao.findByElementsLike(elements);
//		System.out.println(list1);
//		map.put("mes",list1 );
//	    return "bm";
//	}
	
	
	@RequestMapping("/searchelements")
	
	public String searchelements(@RequestParam(value="pageNumber",defaultValue="1")int pageNumber,HttpServletRequest request,Map<String,Object> map){
		
		String elements=request.getParameter("elements");
		System.out.println(elements);
		PageRequest pageRequest=new PageRequest(pageNumber-1,10);
		Page<Material> list=materialDao.findByElementsLike(elements, pageRequest);
		System.out.println(list);
		System.out.println(list.getTotalPages());
		int totalPages=list.getTotalPages();
		map.put("mes",list);
		map.put("pageNumber", pageNumber);
		
		return "bm";
	}
	



	
	
	
	/**
	 * 打开searchid界面
	 * @return
	 */

	
	
}
