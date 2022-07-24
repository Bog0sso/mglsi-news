package com.article.articlewebservice.web;

import java.util.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.article.articlewebservice.domaine.Article;
import com.article.articlewebservice.repository.ArticleRepository;
@Component
@Path("/articles")
public class ArticleJAXRS {
    @Autowired
    private ArticleRepository articleRepository;
    @Produces({MediaType.APPLICATION_JSON})
	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}
    // C
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Article addArticle( Article article){
        article.setDateCreation(new Date());
        article.setDateModification(new Date());
        return articleRepository.save(article);
    }
    // R one
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})

	public Article getArticle(@PathParam("id")int id){
		return articleRepository.findById(id).orElse(null);
	}

	// R many
    @GET
    @Produces({MediaType.APPLICATION_JSON})

	public List<Article> getManyArticle(){
		return articleRepository.findAll();
	}
    //U 
	@PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})

    public Article updateArticle(@RequestBody Article article,@PathParam("id")int id) {
        article.setId(id);
        article.setDateModification(new Date());
        return articleRepository.save(article);

	}
	// D
    @Path("/{id}")
    @DELETE
	public void deleteArticletById(@PathParam("id") int id) {
		articleRepository.deleteById(id);
	}
	
}