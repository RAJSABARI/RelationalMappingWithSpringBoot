package com.kgisl.MysqlRelationalMapping.daoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kgisl.MysqlRelationalMapping.entity.Laptop;

import java.util.List;


@Service
public class CriteriaQueriesForListOfLaptops {
	   @Autowired
	    private EntityManager entityManager;

	    public List<Laptop> getAllLaptops() {
	        // Create CriteriaBuilder
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

	        // Create CriteriaQuery
	        CriteriaQuery<Laptop> criteriaQuery = criteriaBuilder.createQuery(Laptop.class);

	        // Define the root (FROM clause)
	        Root<Laptop> laptopRoot = criteriaQuery.from(Laptop.class);

	        // Specify the select clause
	        criteriaQuery.select(laptopRoot);

	        // Execute the query and return results
	        return entityManager.createQuery(criteriaQuery).getResultList();
	    }
}
