package ma.xproce.languagelearning.dao.repositories;

import jakarta.transaction.Transactional;
import ma.xproce.languagelearning.dao.entities.Commentaire;
import ma.xproce.languagelearning.dao.entities.Enseignememt;
import org.springframework.data.jpa.repository.JpaRepository;
@Transactional
public interface EnseignementRepository extends JpaRepository<Enseignememt,Integer> {
}
