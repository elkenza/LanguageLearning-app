package ma.xproce.languagelearning.dao.repositories;

import jakarta.transaction.Transactional;
import ma.xproce.languagelearning.dao.entities.Enseignememt;
import ma.xproce.languagelearning.dao.entities.Individu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface IndividuRepository extends JpaRepository<Individu,Integer> {

    Page<Individu> findByNameContains(String keyword,Pageable pageable);
}
