package com.baggio;

import java.util.List;

public class UserService {

    List<User> findUsers() {
        return List.of(
                new User(1, "baggio"),
                new User(2, "dave")
        );
    }

}

record User(Integer id, String name) {

}
