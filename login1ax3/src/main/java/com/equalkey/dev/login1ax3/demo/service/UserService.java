package com.equalkey.dev.login1ax3.demo.service;

import com.equalkey.dev.login1ax3.demo.entity.User;
import com.equalkey.dev.login1ax3.demo.exception.UserNotFoundException;
import com.equalkey.dev.login1ax3.demo.repository.UserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserJpaRepo userJpaRepo;

    public User save(String account, String email, String password) {
        User user = new User();
        user.setAccount(account);
        user.setEmail(email);
        user.setPassword(password);

        return userJpaRepo.save(user);
    }

    public User findById(String userId) {
        return userJpaRepo.findByAccount(userId).orElseThrow(UserNotFoundException::new);
    }

    public List<User> findAll() {
        return userJpaRepo.findAll();
    }

    public User update(String account, String email, String pwd) {
        User user = userJpaRepo.findByAccount(account).orElseThrow(UserNotFoundException::new);
        user.setEmail(email);
        user.setPassword(pwd);

        return userJpaRepo.save(user);
    }

    public void delete(String account, String pwd) {
        User user = userJpaRepo.findByAccountAndPassword(account, pwd).orElseThrow(UserNotFoundException::new);
        userJpaRepo.delete(user);
    }

}
