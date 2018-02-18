package com.diansetiyadi.springsecurity.service;

import com.diansetiyadi.springsecurity.entity.User;

public interface UserService {

    public User findUserByEmail(String email);
    public void saveUser(User user);
}
