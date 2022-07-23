package domaine;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;
@XmlRootElement(name = "root")
public class Article implements Serializable {
    private int id;
    private String titre;
    private String contenu;
    private Date dateCreation;
    private Date dateModification;
    private int categorie;
    public Article() {
        super();
    }
    public Article(String titre, String contenu, int categorie){
        super();
        this.titre=titre;
        this.contenu=contenu;
        this.dateCreation= new Date();
        this.dateModification= new Date();
        this.categorie=categorie;
    }
    public int getCategorie() {
        return categorie;
    }
    public String getContenu() {
        return contenu;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public Date getDateModification() {
        return dateModification;
    }
    public int getId() {
        return id;
    }
    public String getTitre() {
        return titre;
    }
    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    
}