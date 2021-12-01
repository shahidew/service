package ir.maktab.service;

import ir.maktab.data.entity.Manager;
import ir.maktab.data.repository.ManagerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerDetailsServiceImpl implements UserDetailsService {
    private final ManagerRepository managerRepository;

    public ManagerDetailsServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Manager> managerOptional = managerRepository.findByEmailAddress(email);
        if (managerOptional.isPresent()){
            Manager manager = managerOptional.get();
            return User.withUsername(manager.getEmailAddress())
                        .password(manager.getPassword())
                        .roles("MANAGER").build();

        }
        throw new UsernameNotFoundException("User not found.");
    }
}
