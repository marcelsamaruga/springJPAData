package br.com.template.projectTemplate.service;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<T> {

	public abstract JpaRepository<T, Long> getRepository();
	
}
