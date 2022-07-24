package com.article.articlewebservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.article.articlewebservice.domaine.Article;
import com.article.articlewebservice.repository.ArticleRepository;

@SpringBootApplication
public class ArticleWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleWebserviceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ArticleRepository articleRepository){
		return args ->{
				articleRepository.save(new Article("VSD","On n'est pas des bandits", 3));
				articleRepository.findAll().forEach(c->{
					System.out.println(c.toString());
				});
			};
	}

}
