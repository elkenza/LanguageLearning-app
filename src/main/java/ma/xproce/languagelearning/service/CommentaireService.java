package ma.xproce.languagelearning.service;

import ma.xproce.languagelearning.dao.entities.Commentaire;

import java.util.List;

public interface CommentaireService {
    public Commentaire addCommentaire(Commentaire commentaire);
    public Commentaire updateCommentaire(Commentaire commentaire);
    public boolean deleteCommentaireById(Integer id);
    public  boolean deleteCommentaire(Commentaire commentaire);
    public Commentaire getCommentaireById(Integer id);
    public List<Commentaire> getAllCommentaire();

}
