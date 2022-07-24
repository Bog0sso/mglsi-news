package com.utilisateur.service;
import com.utilisateur.domaine.Utilisateur;
import com.utilisateur.persistence.Requete;
import javax.jws.WebParam;

public class AuthentificationService {
	public boolean authentifier(@WebParam(name="login") String login ,@WebParam(name="password") String password)throws SQLException {
		Requete requete= new Requete();
		Utilisateur utilisateur=requete.getUtilisateur(login,password);
		return utilisateur.equals(new Utilisateur(login,password));
	}
}
