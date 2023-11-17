package application.service;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.security.core.userdetais.UserDetails;
import org.springframework.security.core.userdetais.UserDetailsService;
import org.springframework.security.core.userdetais.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import application.repository.UserRepository;

@service
public class AppUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Usuario nao encontrado");
        }
        UserDetails = org.springframework;security.core.userdetails.User.builder()
        .username(user.getUsername());
        .password(user.getPassword());
        .roles("USER");
        .build();
    return UserDetails;    
    
    }
}