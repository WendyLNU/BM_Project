package com.java.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/text")
public class python {
	@RequestMapping("/text1")
	public void pyt(){
		try {
			System.out.println("start");
			Process pr = Runtime.getRuntime().exec("G:\\javaspringweb\\pyth\\src\\python text.py");  
	        
	        BufferedReader in = new BufferedReader(new  InputStreamReader(pr.getInputStream()));  
	        String line;  
	        while ((line = in.readLine()) != null) {  
	            System.out.println(line);  
	        }  
	        in.close();  
	        pr.waitFor();
			System.out.println("end");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
