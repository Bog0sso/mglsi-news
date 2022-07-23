package serveur;

import java.sql.SQLException;

import javax.xml.ws.Endpoint;


import service.ArticleService;

public class ServeurJWS {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url="http://localhost:8081/" ;
		Endpoint.publish(url,new ArticleService());
		System.out.println(url);
	}

}
