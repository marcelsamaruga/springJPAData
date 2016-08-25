/**
 * @name: OfMateriaPrimaService
 * Service MVC layer
 * */
package br.com.template.projectTemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.template.projectTemplate.entity.OfMateriaPrima;
import br.com.template.projectTemplate.repository.OfMateriaPrimaRepository;

@Service
public class OfMateriaPrimaService extends BaseService<OfMateriaPrima> {

	@Autowired
	OfMateriaPrimaRepository repository;
	
	@Override
	public OfMateriaPrimaRepository getRepository() {
		return repository;
	}

	
	
}
