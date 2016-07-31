/**
 * abstract class to deal with non-operacional interfaces managed by the JPA Spring Data
 * */
package br.com.template.projectTemplate.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Repository;


@Repository
public abstract class BaseRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public static int PAGE_SIZE = 2;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	/************/
	public static Sort sortAsc(String field) {
		Order order = new Order( Direction.ASC, field );
		return new Sort(order);
	}
	
	public static Sort sortAsc(String... fields) {
		List<Order> orders = new ArrayList<Order>();
		
		for (String field : fields) {
			orders.add( new Order(Direction.ASC, field) );
		}
		
		return new Sort(orders);
	}
	
	public static Sort sortDes(String field) {
		Order order = new Order( Direction.DESC, field );
		return new Sort(order);
	}
	
	public static Sort sortDesc(String... fields) {
		List<Order> orders = new ArrayList<Order>();
		
		for (String field : fields) {
			orders.add( new Order(Direction.DESC, field) );
		}
		
		return new Sort(orders);
	}
	
	public static Sort sort(Direction direction, String field) {
		Order order = new Order( direction, field );
		return new Sort(order);
	}
	
	public static Sort sort(Direction direction, String... fields) {
		List<Order> orders = new ArrayList<Order>();
		
		for (String field : fields) {
			orders.add( new Order(direction, field) );
		}
		
		return new Sort(orders);
	}
	/************/
	
}
