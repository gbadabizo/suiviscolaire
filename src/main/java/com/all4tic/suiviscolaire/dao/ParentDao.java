package com.all4tic.suiviscolaire.dao;


import com.all4tic.suiviscolaire.entities.Parent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ParentDao extends CrudRepository<Parent, Long> {
	
	@Query("select distinct parent from Parent parent left join fetch parent.suivis")
	List<Parent> findAllWithEagerRelationships();
	
	@Query("select parent from Parent parent left join fetch parent.suivis where  parent.id =:id")
	Parent findOneWithEagerRelationships(@Param("id") Long id);
	
	
}
