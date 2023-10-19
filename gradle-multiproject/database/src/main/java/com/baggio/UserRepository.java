package com.baggio;

import java.util.List;

public class UserRepository {


    List<User> findAllUsers() {
        return List.of(
                new User(1, "baggio"),
                new User(2, "dave")
        );
    }

}