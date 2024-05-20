package ma.xproce.languagelearning.security.repositories;

import ma.xproce.languagelearning.dao.entities.Maitrise;
import ma.xproce.languagelearning.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public User findByUserName(String username);
}
