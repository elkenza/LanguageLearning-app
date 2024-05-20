package ma.xproce.languagelearning.security.service;

import lombok.AllArgsConstructor;

import ma.xproce.languagelearning.security.entities.User;
import ma.xproce.languagelearning.security.entities.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImp implements UserDetailsService {
    private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= accountService.loadUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User not found");
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .roles(user.getRoleList().stream().map(Role::getRole).toArray(String[]::new))
                .password(user.getPassword())
                .build();


    }
}
