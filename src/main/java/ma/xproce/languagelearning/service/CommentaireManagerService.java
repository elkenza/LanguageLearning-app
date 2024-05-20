package ma.xproce.languagelearning.service;

import ma.xproce.languagelearning.dao.entities.Commentaire;
import ma.xproce.languagelearning.dao.repositories.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentaireManagerService implements CommentaireService {
    @Autowired
    CommentaireRepository commentaireRepository;
    @Override
    public Commentaire addCommentaire(Commentaire commentaire) {
        try {
            return  commentaireRepository.save(commentaire);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Commentaire updateCommentaire(Commentaire commentaire) {
        Commentaire com=commentaireRepository.findById(commentaire.getId()).get();
        com.setIndividuEtudiant(commentaire.getIndividuEtudiant());
        com.setIndividuEnseignant(commentaire.getIndividuEnseignant());
        com.setMessage(commentaire.getMessage());
        return com;
    }

    @Override
    public boolean deleteCommentaireById(Integer id) {
        if (commentaireRepository.existsById(id)) {
            commentaireRepository.deleteById(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean deleteCommentaire(Commentaire commentaire) {
        if(commentaireRepository.existsById(commentaire.getId())){
            commentaireRepository.delete(commentaire);
            return true;
        }
        else
            return false;
    }

    @Override
    public Commentaire getCommentaireById(Integer id) {
        return commentaireRepository.findById(id).get();
    }

    @Override
    public List<Commentaire> getAllCommentaire() {
        return commentaireRepository.findAll();
    }
}
