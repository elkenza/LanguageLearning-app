package ma.xproce.languagelearning.dao.repositories;

import jakarta.transaction.Transactional;
import ma.xproce.languagelearning.dao.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
@Transactional
public interface CommentaireRepository  extends JpaRepository<Commentaire,Integer> {
}
