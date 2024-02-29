package services;
import java.util.List;
import entities.article;
import repositories.articleRepository;


public class articleService {
    private articleRepository articleRepository=new articleRepository();
    public void ajouterarticle(article article){
        articleRepository.insertarticle(article);
    }
    public List<article> listerarticles(){
          return   articleRepository.getAllaArticles();
    }
      
}
