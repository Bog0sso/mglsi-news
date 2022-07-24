package com.article.articlewebservice.domaine;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="article")
@Data @ToString @NoArgsConstructor @AllArgsConstructor
public class Article {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String contenu;
    private int categorie;
    @Column(name="dateCreation")
    private Date dateCreation;
    private Date dateModification;
    // private int categorie;
    // public Article(String titre, String contenu, int categorie){
    //     super();
    //     this.titre=titre;
    //     this.contenu=contenu;
    //     this.dateCreation= new Date();
    //     this.dateModification=this.dateCreation;
    //     this.categorie=categorie;
    // }
}