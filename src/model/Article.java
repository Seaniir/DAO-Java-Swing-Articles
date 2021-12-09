package model;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Article {

    public static List<Article> listeArticles = new ArrayList<Article>();
    private String titre;
    private String resume;
    private String contenu;
    private Date created_at;
    private String auteur;

    public String getTitre() {
        return titre;
    }

    public String getResume() {
        return resume;
    }

    public String getContenu() {
        return contenu;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public String getAuteur() {
        return auteur;
    }

    public Article() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Article(String titre, String resume, String contenu) {
        super();
        this.titre = titre;
        this.resume = resume;
        this.contenu = contenu;
    }

    public Article(String titre, String resume, String contenu, Date created_at, String auteur) {
        super();
        this.titre = titre;
        this.resume = resume;
        this.contenu = contenu;
        this.created_at = created_at;
        this.auteur = auteur;
    }
}
