package entities;
import java.util.Date;

public class article {
    private int id;
    private String titre;
    private String contenu;
    private Date dateCreation;
    private categorie categorie;
    
    public categorie getcategorie() {
        return categorie;
    }
    public void setcategorie(categorie categorie) {
        this.categorie = categorie;
    }
    public article() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String gettitre() {
        return titre;
    }
    public void setReference(String titre) {
        this.titre = titre;
    }
    public String getcontenu() {
        return contenu;
    }
    public void setcontenu(String contenu) {
        this.contenu= contenu;
   
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    public void settitre(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'settitre'");
    }
}
