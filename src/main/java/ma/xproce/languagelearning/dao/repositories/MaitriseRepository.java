package ma.xproce.languagelearning.dao.repositories;

import jakarta.transaction.Transactional;
import ma.xproce.languagelearning.dao.entities.Enseignememt;
import ma.xproce.languagelearning.dao.entities.Maitrise;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface MaitriseRepository extends JpaRepository<Maitrise,Integer> {
}
