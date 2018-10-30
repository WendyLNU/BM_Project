package com.java.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dao.MaterialDao;
import com.java.entity.EchartsBean;
import com.java.entity.Material;

/**
 - @ClassName: EchartsBean
 - @Description: TODO(图标数据包装类)
 - @author 爱琴孩
*/
@Controller
//@RequestMapping("/echartsAsynController")
public class PictureShow {

		@Autowired
		MaterialDao materialDao;
	    /** 
	    * @Description: TODO(跳转页面) 
	    * @return
	    * @author 爱琴孩  
	    * @version V1.0
	     */
	    @RequestMapping(value="/showTable",method=RequestMethod.GET)
	    public String showTable(){
	        System.out.println("跳转到对应的test.html页面");
	        return "test";
	    }

	    /**
	    * 
	    * @Description: TODO(模拟从数据库获取数据) 
	    * @return
	    * @author 爱琴孩  
	    * @version V1.0
	    */
	    @ResponseBody
	    @RequestMapping(value="/getDatas")
	    public EchartsBean getDatas(){
	    	System.out.println("getDatas");
	        EchartsBean echartsBean =new EchartsBean();
	        List<String> xAxisCategory =Arrays.asList("含Na的化学物质","含Li的化学物质");
/*	        String prettyformula="Na";
	    	List<Material> list1=materialDao.findByPrettyformulaLike("Na");
	    	System.out.println(list1);
	    	int a=list1.size();
	    	List<Material> list2=materialDao.findByPrettyformulaLike("Li");
	    	System.out.println(list2);
	    	int b=list1.size();
	    	System.out.println(a);
	    	System.out.println(b);*/
	        List<Integer> datas = Arrays.asList(100,200);
	        echartsBean.setDatas(datas);
	        echartsBean.setxAxisCategory(xAxisCategory);
	        return echartsBean; 
	    }
}
	

