package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.categorie;

public class categorieRepository extends Database {
        private final  String SQL_SELECT_ALL="select * from categorie" ;
        private final  String SQL_INSERT="INSERT INTO categorie(nom_categorie) VALUES (?)";
        //select
       public void insertcategorie(categorie categorie){
            openConnexion();
            try {
                initPreparedStatement(SQL_INSERT);
                statement.setString(1, categorie.getNomcategorie());
                closeConnexion();
            } catch (SQLException e) {
            e.printStackTrace();
            }
       }
       public List<categorie> getAllcCategories(){
            List<categorie> categories=new ArrayList<>();
       try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_ALL);
           ResultSet rs= executeSelect();
             while (rs.next()) {
                  categorie categorie=new categorie();
                   categorie.setId(rs.getInt("id_categorie"));
                   categorie.setNomcategorie(rs.getString("nom_categorie"));
                   categories.add(categorie);
             }
             rs.close();
           closeConnexion();
        }
         catch (SQLException e) {
              System.out.println("Erreur de Connexion a la BD");
        }
        return  categories;
       }
}
