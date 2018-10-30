package com.java.dao;



import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.java.entity.Material;

public interface MaterialDao extends PagingAndSortingRepository<Material, String> {
	//public List<Material> findByElements(String elements);


	public List<Material> findByMaterialid(String materialid);

	public List<Material> findByPrettyformula(String prettyformula);

	public List<Material> findByElements(String elements);
	
	public List<Material> findByPrettyformulaLike(String prettyformula);

	//public List<Material> findByElementsLike(String elements);
		
	public Page<Material> findByElementsLike(String elements,PageRequest pageRequest);	
	
		
	

	//public List<Material> findOne(String material_id);

	//public Material findById(String material_id);
}
