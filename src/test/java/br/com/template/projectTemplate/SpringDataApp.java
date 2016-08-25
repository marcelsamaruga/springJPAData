package br.com.template.projectTemplate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import br.com.template.projectTemplate.entity.Embalagem;
import br.com.template.projectTemplate.entity.OfMateriaPrima;
import br.com.template.projectTemplate.repository.BaseRepository;
import br.com.template.projectTemplate.service.EmbalagemService;
import br.com.template.projectTemplate.service.OfMateriaPrimaService;

@SpringBootApplication
public class SpringDataApp implements CommandLineRunner {


	@Autowired
	EmbalagemService embalagemService;

	@Autowired
	OfMateriaPrimaService ofMPService;
	
	public static void main(String[] args) {
		SpringApplication.run( SpringDataApp.class, args );
	}

	
	@Override
	public void run(String... arg0) throws Exception {
		
		// find all entity
		List<Embalagem> list = embalagemService.getRepository().findAll();
		list.forEach( System.out::println );
		
		// find all using sort method
		list = embalagemService.getRepository().findAll( BaseRepository.sortAsc("nome") );
		list.forEach( System.out::println );
		
		// find by id (Long)
		Embalagem post = embalagemService.getRepository().findOne(1L);
		System.out.println(post);
		
		// count sql method'
		System.out.println(embalagemService.getRepository().count());
		
		
		// new register
		post = new Embalagem();
		post.setNome("Descricao");
		
		//postRepository.save(post);
		System.out.println(embalagemService.getRepository().count());
		
		// find using like
 		System.out.println(embalagemService.getRepository().findByNomeLikeIgnoreCase("B".concat("%")));
		
		// find all using pagination. Uses Pageable interface and return getContent() method to retrieve the data
		Pageable pagination = new PageRequest(1, BaseRepository.PAGE_SIZE);
		System.out.println(embalagemService.getRepository().findAll(pagination).getContent());
		
		// find using IN sql sentence
		List<Long> idList = new ArrayList<Long>();
		idList.add(1L); idList.add(2L); idList.add(3L);
		list = embalagemService.getRepository().findByIdIn(idList);
		list.forEach( System.out::println );
		
		// find by Starting with
		list = embalagemService.getRepository().findByNomeStartingWithIgnoreCase("B");
		list.forEach( System.out::println );
		
		// find using sort element
		list = embalagemService.getRepository().findByNomeOrderByIdAsc("BARRICA");
		list.forEach( System.out::println );

		// find using two fields
		list = embalagemService.getRepository().findByNomeAndId("BARRICA", 1L);
		list.forEach( System.out::println );
		
		// find is null query methods
		list = embalagemService.getRepository().findByNomeIsNotNull();
		list.forEach( System.out::println );

		// find by greater than the parameter and order by Nome Asc, Id Desc
		list = embalagemService.getRepository().findByNomeGreaterThanOrderByNomeAscIdDesc("D");
		list.forEach( System.out::println );
		
		List<OfMateriaPrima> listaOF = ofMPService.getRepository().findAll();
		listaOF.forEach( System.out::println );
		
		ofMPService.getRepository().updateOfMateriaPrimaById("0007/15", 7L);
		
		listaOF = ofMPService.getRepository().allDesc();
		listaOF.forEach( System.out::println );
		
		listaOF = ofMPService.getRepository().allDescSQL();
		listaOF.forEach( System.out::println );
		
		listaOF = ofMPService.getRepository().findByEmbalagemNomeHQL("BARRICA");
		listaOF.forEach( System.out::println );
		
		listaOF = ofMPService.getRepository().findByEmbalagemNomeSQLNative("BARRICA");
		listaOF.forEach( System.out::println );

	}
	
}
