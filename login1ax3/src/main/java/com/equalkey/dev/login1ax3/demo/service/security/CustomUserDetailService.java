package com.equalkey.dev.login1ax3.demo.service.security;

import com.equalkey.dev.login1ax3.demo.exception.UserNotFoundException;
import com.equalkey.dev.login1ax3.demo.repository.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService  implements UserDetailsService{

    private final UserJpaRepo userJpaRepo;

    @Override
    public UserDetails loadUserByUsername(String userPk) throws UsernameNotFoundException {
        return userJpaRepo.findById(Long.valueOf(userPk)).orElseThrow(UserNotFoundException::new);
    }
}
