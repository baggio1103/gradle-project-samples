package com.baggio;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/users")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        var writer = resp.getWriter();
        userService.findUsers().forEach(
                user -> writer.write("""
                        <h1>%d: %s</h1>
                        """.formatted(user.id(), StringUtils.trim(user.name()))
                )
        );
        writer.close();
    }

}
