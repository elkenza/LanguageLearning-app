package ma.xproce.languagelearning.dao.repositories;

import jakarta.transaction.Transactional;
import ma.xproce.languagelearning.dao.entities.Enseignememt;
import ma.xproce.languagelearning.dao.entities.Langue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface LangueRepository extends JpaRepository<Langue,Integer> {
    Page<Langue> findByNameContains(String keyword, Pageable pageable);
}
