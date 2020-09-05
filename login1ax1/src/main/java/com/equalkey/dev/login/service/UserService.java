package com.equalkey.dev.login.service;

import com.equalkey.dev.login.entity.User;
import com.equalkey.dev.login.exception.CUserNotFoundException;
import com.equalkey.dev.login.persistence.UserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserJpaRepo userJpaRepo;

    public User save(String uid, String name) {
        User user = new User();
        user.setUid(uid);
        user.setName(name);
        System.out.println(user.getUid());
        return userJpaRepo.save(user);
    }

    public User findById(Long msrl) {
        return userJpaRepo.findById(msrl).orElseThrow(CUserNotFoundException::new);
    }

    public List<User> findAll() {
        return userJpaRepo.findAll();
    }

    public User update(Long msrl, String uid, String name) {
        User u = userJpaRepo.findById(msrl).orElseThrow(CUserNotFoundException::new);
        u.setUid(uid);
        u.setName(name);
        return userJpaRepo.save(u);
    }

    public void delete(Long msrl) {
        userJpaRepo.deleteById(msrl);
    }
}