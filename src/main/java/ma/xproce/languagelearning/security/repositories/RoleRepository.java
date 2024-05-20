package ma.xproce.languagelearning.security.repositories;

import ma.xproce.languagelearning.security.entities.Role;
import ma.xproce.languagelearning.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
    public Role findByRole(String newRole);
}
