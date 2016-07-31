package br.com.template.projectTemplate;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.template.projectTemplate.config.DataConfig;
import br.com.template.projectTemplate.entity.Embalagem;
import br.com.template.projectTemplate.repository.EmbalagemRepository;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:application-context.xml")
@ContextConfiguration(locations="classpath:application.properties")
//@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {SpringDataApp.class, DataConfig.class})
//@WebIntegrationTest(randomPort = true)
//@IntegrationTest("server.port=8080")
//@ActiveProfiles("unit")
public class PostRepositoryTest {

	@Autowired
	EmbalagemRepository repository;
	
	@Test
	public void test() {
		Embalagem post = new Embalagem();
		post.setNome("First Post");
		
		//repository.save(post);
		
		Embalagem dbpost = repository.findOne(post.getId());
		assertNotNull(dbpost);
		System.out.println(dbpost.getNome());
	}

}
