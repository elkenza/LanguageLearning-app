package ma.xproce.languagelearning.security.service;


import ma.xproce.languagelearning.security.entities.Role;
import ma.xproce.languagelearning.security.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    public User createUser(String username, String email, String password, String confirmPassword );
    public Role createRole(String role);
    public void addRoleToUser(String username,String role);
    public void removeRoleFromUser(String username,String role);
    public User loadUserByUsername(String username);

}
