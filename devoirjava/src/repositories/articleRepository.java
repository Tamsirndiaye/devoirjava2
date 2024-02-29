package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.article;
import entities.categorie;

public class articleRepository  extends Database{
    private final  String SQL_SELECT_ALL="select * from article a, categorie c where a.categorie_id=categorie.id_categorie" ;
    private final  String SQL_INSERT="INSERT INTO `article` (`titre`, `contenu`, `date_creation`, `categorie_id`) VALUES (?,?,?,?)";
    public void insertarticle(article article){
            openConnexion();
            try {
                initPreparedStatement(SQL_INSERT);
                statement.setString(1, article.gettitre());
                statement.setString(2, article.getcontenu());
                statement.setDate(3, new java.sql.Date(new Date().getTime()));
                statement.setInt(4, article.getcategorie().getId());
                closeConnexion();
            } catch (SQLException e) {
            e.printStackTrace();
            }
       }
       public List<article> getAllaArticles(){
            List<article> articles=new ArrayList<>();
       try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_ALL);
           ResultSet rs= executeSelect();
             while (rs.next()) {
                     categorie categorie=new categorie();
                     categorie.setId(rs.getInt("id_categorie"));
                     categorie.setNomcategorie(rs.getString("nom_categorie"));
                     
                     article article=new article();
                     article.setId(rs.getInt("id_article"));
                     article.settitre(rs.getString("titre"));
                     article.setcategorie(categorie);
                   //  article.setcontenu(rs.getString("contenu"));
                     article.setDateCreation(rs.getDate("date_creation"));
                     articles.add(article);
             }
             rs.close();
            closeConnexion();
          }
          catch (SQLException e) {
              System.out.println("Erreur de Connexion a la BD");
         }
         return  articles;
       }
}
