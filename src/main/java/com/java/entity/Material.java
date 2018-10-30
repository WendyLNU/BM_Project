package com.java.entity;

import org.springframework.data.annotation.Id;

public class Material {

	/**
	 * 化学材料实体
	 * @author 纹萱
	 *
	 */
	
	@Id
	private String  id;
	
	private String materialid;
	
	private String elements;
	
	private String prettyformula;
	
	private String structure;
	
	private String information;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaterialid() {
		return materialid;
	}

	public void setMaterialid(String materialid) {
		this.materialid = materialid;
	}

	public String getElements() {
		return elements;
	}

	public void setElements(String elements) {
		this.elements = elements;
	}

	public String getPrettyformula() {
		return prettyformula;
	}

	public void setPrettyformula(String prettyformula) {
		this.prettyformula = prettyformula;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
	
	
	
	


	
	
}
