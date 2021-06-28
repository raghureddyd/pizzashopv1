package ch.tim.pizzashopv1.common.security.service;

import ch.tim.pizzashopv1.common.security.userdetails.CustomUserDetails;

import ch.tim.pizzashopv1.user.dao.UserRepository;
import ch.tim.pizzashopv1.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findById(userName);
        User user ;
        if (userOptional.isPresent()) {
            user = userOptional.get();
            return new CustomUserDetails(user);

        }
        return null;
    }
}
