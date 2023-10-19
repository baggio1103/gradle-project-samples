package com.baggio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private final UserService userService = new UserService();

    @Test
    void findUsers() {
        var actual = userService.findUsers();
        System.out.println("Hello world");
        assertEquals(2, actual.size());
    }

}