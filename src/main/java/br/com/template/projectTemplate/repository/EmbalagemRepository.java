package br.com.template.projectTemplate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.template.projectTemplate.entity.Embalagem;

public interface EmbalagemRepository extends JpaRepository<Embalagem, Long> {

	// all methods above are construct in real time by the Spring Data JPA interface
	// http://docs.spring.io/spring-data/jpa/docs/1.7.3.RELEASE/reference/html/
	//Table 3. Supported keywords inside method names
	
	// find using like
	List<Embalagem> findByNomeLike(String nome);
	
	List<Embalagem> findByNomeLikeIgnoreCase(String nome);
	
	// find using IN sql sentence
	List<Embalagem> findByIdIn(List<Long> id);
	
	List<Embalagem> findByIdNotIn(List<Long> id);
	
	// find by Starting with
	List<Embalagem> findByNomeStartingWithIgnoreCase(String nome);
	
	// find using sort element
	List<Embalagem> findByNomeOrderByIdAsc(String nome);
	
	// find using two fields
	List<Embalagem> findByNomeAndId(String nome, Long id);
	
	// find ISNULL query method
	List<Embalagem> findByNomeIsNotNull();
	
	// find by greater than the parameter and order by Nome Asc, Id Desc
	List<Embalagem> findByNomeGreaterThanOrderByNomeAscIdDesc(String nome);
	
	
	// 1/N query: findByAttributeFieldinEntityAction: e.g.: findByPhonesNumberStartingWith
	// where in the entity has List<Phone> phones and Phone has number attribute
}
