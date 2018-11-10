package com.spring.service;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Override
    public boolean login(String userName, String pwd) {
        if (userName.equals(pwd))
            return true;
        return false;
    }

    @Override
    public void getinfo() {

    }
}
