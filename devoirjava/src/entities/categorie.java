package entities;
import java.util.ArrayList;
import java.util.List;

public class categorie {
    private int id;
    private String nomcategorie;
    List<article> article=new ArrayList<>();
      
    public List<article> getarticle() {
        return article;
    }
    public void setarticle(List<article> articles) {
        this.article = articles;
    }
    public categorie() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomcategorie() {
        return nomcategorie;
    }
    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }
}
