package com.utilisateur.service;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.utilisateur.domaine.Utilisateur;
import com.utilisateur.persistence.Requete;

@WebService (name="UtilisateurWS")

public class UtilisateurService {
	Requete requete;
	
	public UtilisateurService() throws SQLException {
		this.requete = new Requete();
	}
	// R1
	@WebMethod(operationName="getAllUtilisateurs")
	public List<Utilisateur> getAllUtilisateurs() throws SQLException {
		return this.requete.getAllUtilisateurs();
	}
	// R2
	@WebMethod(operationName="getUtilisateur")
	public Utilisateur getUtilisateur(@WebParam(name = "id") int id) throws SQLException {
		return this.requete.getUtilisateur(id);
	}
	
	// C
	@WebMethod(operationName="addUtilisateur")
	public boolean addUtilisateur(@WebParam(name="login") String login ,@WebParam(name="password") String password) throws SQLException{
		return this.requete.addUtilisateur( login, password);
	}
	// D
	public boolean deleteUtilisateur(@WebParam(name="id") int id) throws SQLException{
		return this.requete.deleteUtilisateurtById(id);
	}
	// U
	@WebMethod(operationName="updateUtilisateur")
	public boolean updateUtilisateur(
								@WebParam(name="id") int id, 
								@WebParam(name="login") String login, 
								@WebParam(name="password") String password
	) throws SQLException{
		return this.requete.updateUtilisateur( id, login, password);
	}
	// method
	@WebMethod(operationName = "authentifier")
	public boolean authentifier(@WebParam(name="login") String login ,@WebParam(name="password") String password)throws SQLException {
		Requete requete_= new Requete();
		Utilisateur utilisateur_=requete_.getUtilisateur(login,password);
		Utilisateur utilisateur = new Utilisateur(login, password);
		return utilisateur.getLogin().equals(utilisateur_.getLogin()) && utilisateur_.getPassword().equals(utilisateur.getPassword());
	}
}
