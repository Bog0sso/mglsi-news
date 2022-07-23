package service;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import domaine.Article;
import persistence.Requete;

@WebService (name="ArticleWS")

public class ArticleService {
	Requete requete;
	
	public ArticleService() throws SQLException {
		this.requete = new Requete();
	}

	@WebMethod(operationName="getAllArticle")
	public List<Article> getAllArticles(@WebParam(name = "dataFormat") String dataFormat) throws SQLException {
		System.out.println(dataFormat);
		return this.requete.getAllArticle();
	}
	
	
	@WebMethod(operationName="addArticle")
	public boolean addArticle(@WebParam(name="titre") String titre ,@WebParam(name="contenu") String contenu,@WebParam(name="categorie") int categorie) throws SQLException{
		return this.requete.addArticle(titre, contenu, categorie);
	}
	
	public boolean deleteArticle(@WebParam(name="id") int id) throws SQLException{
		return this.requete.deletetById(id);
	}
	@WebMethod(operationName="updateArticle")
	public boolean updateArticle(
								@WebParam(name="id") int id, 
								@WebParam(name="titre") String titre,
								@WebParam(name="contenu") String contenu,
								@WebParam(name="categorie") int categorie
	) throws SQLException{
		return this.requete.updateArticle( id, titre,contenu,categorie);
	}
}
