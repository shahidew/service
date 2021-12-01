package ir.maktab.service;

import ir.maktab.data.enums.UserRole;
import ir.maktab.data.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<ir.maktab.data.entity.User> userOptional = userRepository.findUserByEmailAddress(email);
        if (userOptional.isPresent()){
            ir.maktab.data.entity.User user = userOptional.get();
           /*  for (UserRole u: user.getUserRole()
                 ) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority();
            }*/
            if (user.getUserRole().equals(UserRole.Customer)){
                return User.withUsername(user.getEmailAddress())
                        .password(user.getPassword())
                        .roles("CUSTOMER").build();
            }else if(user.getUserRole().equals(UserRole.Expert)) {
                return User.withUsername(user.getEmailAddress())
                        .password(user.getPassword())
                        .roles("EXPERT").build();
            }
        }
        throw new UsernameNotFoundException("User not found.");
    }
/*
    private String getAuthorities() {
    }*/
}
