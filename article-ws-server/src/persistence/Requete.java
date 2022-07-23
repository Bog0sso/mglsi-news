package persistence;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;


import domaine.Article;

public class Requete {
	
	Connection con;
	Statement etat;
	PreparedStatement pre;
	
	public Requete() throws SQLException {
		this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mglsi_news", "etudiant", "etudiant");
		this.etat = con.createStatement();
	}
	
	public boolean addArticle(String titre ,String contenu, int categorie) throws SQLException {
		this.pre = this.con.prepareStatement("INSERT INTO Article (titre, contenu,categorie) VALUES (?, ?, ?)");
		this.pre.setString(1, titre);
		this.pre.setString(2, contenu);
		this.pre.setInt(3, categorie);
		return this.pre.executeUpdate() > 0 ? true : false;
	}
	
	public List<Article> getAllArticle() throws SQLException {
		Article article;
		List<Article> articles = new ArrayList<>();
		ResultSet resultats = this.etat.executeQuery("SELECT * FROM Article");
		while(resultats.next()) {
			article = new Article();
			if(resultats.getString("titre") != null) {
				article.setTitre(resultats.getString("titre"));
			}
			if(resultats.getString("categorie") != null) {
				article.setCategorie(resultats.getInt("categorie"));
			}
			if(resultats.getString("contenu") != null) {
				article.setContenu(resultats.getString("contenu"));
			}
			articles.add(article);
		}
		return articles;
	}
	
	
	public boolean updateArticle(int id, String titre, String contenu, int categorie) throws SQLException {
	
		this.pre = this.con.prepareStatement("UPDATE Article SET titre=?, categorie=?, contenu=?, dateModification=? WHERE id=?");
		this.pre.setString(1, titre);
		this.pre.setInt(2, categorie);
		this.pre.setString(3, contenu);
		// this.pre.setString(4,  (String) new Date());
		// debugging
		Date date = new java.util.Date();
		System.out.println(date.toString());
		// 
		this.pre.setInt(5, id);
		return this.pre.executeUpdate() > 0 ? true : false;
	}
	
	public boolean deletetById(int id) throws SQLException {
		this.pre = this.con.prepareStatement("Delete FROM Article WHERE id=?");
		this.pre.setInt(1, id);
		return this.pre.executeUpdate() > 0 ? true : false;
	}
	

}
