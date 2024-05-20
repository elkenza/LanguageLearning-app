package ma.xproce.languagelearning.dao.repositories;

import jakarta.transaction.Transactional;
import ma.xproce.languagelearning.dao.entities.Commentaire;
import ma.xproce.languagelearning.dao.entities.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface EvaluationRepository extends JpaRepository<Evaluation,Integer> {
}
