package com.equalkey.dev.login.service;

import com.equalkey.dev.login.entity.User;
import com.equalkey.dev.login.persistence.UserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserJpaRepo userJpaRepo;

    public User save(String uid, String name) {
        User user = new User();
        user.setUid(uid);
        user.setName(name);
        return userJpaRepo.save(user);
    }

}
