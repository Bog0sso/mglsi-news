package com.utilisateur.persistence;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.utilisateur.domaine.Utilisateur;
import com.utilisateur.service.AuthentificationService;

public class Requete {
	
	Connection con;
	Statement etat;
	PreparedStatement pre;
	
	public Requete() throws SQLException {
		this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mglsi_news", "etudiant", "etudiant");
		this.etat = con.createStatement();
	}
	
	public boolean addUtilisateur(String login ,String password) throws SQLException {
		this.pre = this.con.prepareStatement("INSERT INTO Utilisateur (login,password) VALUES (?, ?)");
		this.pre.setString(1, login);
		this.pre.setString(2, password);
		return this.pre.executeUpdate() > 0 ? true : false;
	}
	
	public List<Utilisateur> getAllUtilisateurs() throws SQLException {
		
		Utilisateur utilisateur;
		List<Utilisateur> utilisateurs = new ArrayList<>();
		ResultSet resultats = this.etat.executeQuery("SELECT * FROM Utilisateur");
		while(resultats.next()) {
			utilisateur = new Utilisateur();

			if(resultats.getString("id") != null) {
				utilisateur.setId(resultats.getInt("id"));
			}

			if(resultats.getString("login") != null) {
				utilisateur.setLogin(resultats.getString("login"));
			}

			if(resultats.getString("password") != null) {
				utilisateur.setPassword(resultats.getString("password"));
			}
			
			utilisateurs.add(utilisateur);
		}
		return utilisateurs;
	}
	public Utilisateur getUtilisateur(int id) throws SQLException{
		Utilisateur utilisateur = new Utilisateur();
		this.pre=this.con.prepareStatement("SELECT id,login,password FROM Utilisateur WHERE id=?");
		this.pre.setInt(1,id);
		ResultSet resultat = this.pre.executeQuery();

		while(resultat.next()) {
			utilisateur = new Utilisateur();

			if(resultat.getString("id") != null) {
				utilisateur.setId(resultat.getInt("id"));
			}

			if(resultat.getString("login") != null) {
				utilisateur.setLogin(resultat.getString("login"));
			}

			if(resultat.getString("password") != null) {
				utilisateur.setPassword(resultat.getString("password"));
			}
			
		}
		return utilisateur;
	}
	public Utilisateur getUtilisateur(String login, String password ) throws SQLException{
		Utilisateur utilisateur = new Utilisateur();
		this.pre=this.con.prepareStatement("SELECT id,login,password FROM Utilisateur WHERE login=? AND password=?");
		this.pre.setString(1,login);
		this.pre.setString(2,password);
		ResultSet resultat = this.pre.executeQuery();

		while(resultat.next()) {
			utilisateur = new Utilisateur();

			if(resultat.getString("id") != null) {
				utilisateur.setId(resultat.getInt("id"));
			}

			if(resultat.getString("login") != null) {
				utilisateur.setLogin(resultat.getString("login"));
			}

			if(resultat.getString("password") != null) {
				utilisateur.setPassword(resultat.getString("password"));
			}
			
		}
		return utilisateur;
	}
	
	
	public boolean updateUtilisateur(int id, String login, String password) throws SQLException {
	
		this.pre = this.con.prepareStatement("UPDATE Utilisateur SET login=?, password=? WHERE id=?");
		this.pre.setString(1, login);
		this.pre.setString(2, password);
		this.pre.setInt(3, id);
		return this.pre.executeUpdate() > 0 ? true : false;
	}
	
	public boolean deleteUtilisateurtById(int id) throws SQLException {
		this.pre = this.con.prepareStatement("DELETE FROM Utilisateur WHERE id=?");
		this.pre.setInt(1, id);
		return this.pre.executeUpdate() > 0 ? true : false;
	}
	

}
