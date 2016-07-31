package br.com.template.projectTemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.template.projectTemplate.entity.Embalagem;
import br.com.template.projectTemplate.repository.EmbalagemRepository;

@Service
public class EmbalagemService extends BaseService<Embalagem> {

	@Autowired
	EmbalagemRepository repository;
	
	@Override
	public EmbalagemRepository getRepository() {
		return repository;
	}

	
	
}
