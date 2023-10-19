package com.baggio;

import java.util.List;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    List<User> findUsers() {
        return userRepository.findAllUsers();
    }

}
