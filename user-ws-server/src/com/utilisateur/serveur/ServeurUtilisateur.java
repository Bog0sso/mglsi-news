package com.utilisateur.serveur;

import java.sql.SQLException;

import javax.xml.ws.Endpoint;


import com.utilisateur.service.UtilisateurService;

public class ServeurUtilisateur {

	public static void main(String[] args) throws SQLException {
		String url="http://localhost:8082/" ;
		Endpoint.publish(url,new UtilisateurService());
		System.out.println(url);
	}

}
