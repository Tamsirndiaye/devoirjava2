import java.util.List;
import java.util.Scanner;

import entities.article;
import entities.categorie;
import services.articleService;
import services.categorieService;

public class App {
    public static void main(String[] args) throws Exception {
        int choix;
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        categorieService categorieService=new categorieService();
        articleService articleService=new articleService();
       
        do {
            System.out.println("1-creer une categorie");
            System.out.println("2-Lister les categories"); 
            System.out.println("3-Ajouter article et l'associee à une  categorie"); 
            System.out.println("4-Lister les articles ainsi que la categorie associée");
            System.out.println("5-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:
                     System.out.println("Entrer le nom de la categorie");
                     String nomcategorie=sc.nextLine(); 
                     categorie categorie=new categorie();
                     categorie.setNomcategorie(nomcategorie);
                     categorieService.ajoutercategorie(categorie);
                    break;
                case 2:
                    List<categorie> categories= categorieService.listercCategories();
                    for (categorie ct : categories) {
                        System.out.println("ID : "+ct.getId() ); 
                        System.out.println("NOM : "+ct.getNomcategorie() );     
                    }
                  
                    break; 
                    
              case 3:
                     System.out.println("Entrer le titre de l'article");
                     String titre=sc.nextLine(); 
                     List<categorie> categories2 =categorieService.listercCategories();
                        for (categorie ct : categories2) {
                            System.out.println(ct.getId()+"-"+ct.getNomcategorie());   
                        }
                       System.out.println("Entrer Id d'une categorie");
                       int id_categorie=sc.nextInt();
                       categorie=new categorie();
                       categorie.setId(id_categorie);
                       article article=new article();
                       article.settitre(titre);
                       article.setcategorie(categorie);;
                       articleService.ajouterarticle(article);
                   break;

                   case 4:
                   List<article> articles= articleService.listerarticles();
                   for (article a : articles) {
                       System.out.println("ID : "+a.getId() ); 
                       System.out.println("Reference : "+a.gettitre() ); 
                       System.out.println("Date Creation : "+a.getDateCreation());   
                       System.out.println("categorie : "+a.getcategorie().getNomcategorie() ); 
                       System.out.println("------------------------------------");      
                   }
                 
                   break; 
                    
            }
          } while (choix!=5);
    }
}
