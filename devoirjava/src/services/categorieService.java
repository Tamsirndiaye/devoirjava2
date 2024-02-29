package services;

import java.util.List;

import entities.categorie;
import repositories.categorieRepository;

public class categorieService {
    private categorieRepository categorieRepository=new categorieRepository();
    public void ajoutercategorie(categorie categorie){
        categorieRepository.insertcategorie(categorie);
    }
    public List<categorie> listercCategories(){
          return categorieRepository.getAllcCategories();
    }
    
}
