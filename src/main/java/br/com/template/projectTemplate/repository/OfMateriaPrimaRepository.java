/**
 * @name: OfMateriaPrimaRepository
 * Methods to access the database
 * */
package br.com.template.projectTemplate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.template.projectTemplate.entity.OfMateriaPrima;

public interface OfMateriaPrimaRepository extends JpaRepository<OfMateriaPrima, Long> {

	// all methods above are construct in real time by the Spring Data JPA interface
	// http://docs.spring.io/spring-data/jpa/docs/1.7.3.RELEASE/reference/html/
	//Table 3. Supported keywords inside method names
	
	
	/*******************************************************************/
	
	// to update/delete using HQL it must to use the @Modifying
	
	@Modifying
	@Query( value="update OfMateriaPrima set numeroCompleto = :numeroCompleto WHERE id = :id" )
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateOfMateriaPrimaById(@Param(value="numeroCompleto") String numeroCompleto,  @Param(value="id") Long id);
	
	
	/*******************************************************************/
	

	List<OfMateriaPrima> findByEmbalagemNomeStartingWithIgnoreCaseOrderById(String nome);
	
	/*******************************************************************/

	// @NamedQuery used in the Pedido.java
	
	List<OfMateriaPrima> allDesc();
	
	List<OfMateriaPrima> allDescSQL();
	
	/*******************************************************************/
	
	// using native query in the repository query
	@Query(value = " SELECT of_materia_prima.* FROM of_materia_prima INNER JOIN embalagem ON embalagem.id = of_materia_prima.id_embalagem "
			+ "		 WHERE embalagem.nome = :nome",
		   nativeQuery = true)
	List<OfMateriaPrima> findByEmbalagemNomeSQLNative(@Param(value="nome") String nome);
	
	
	// using query in the repository query
	@Query(value = "SELECT ofMP FROM OfMateriaPrima ofMP WHERE ofMP.embalagem.nome = :nome")
	List<OfMateriaPrima> findByEmbalagemNomeHQL(@Param(value="nome") String nome);
	
	
}
