package com.shop.filters;

import com.shop.models.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component("filter")
public class MainFilter implements Filter {

    private final UserService userService;

    @Autowired
    public MainFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //TODO logic???
        userService.userAuthentication(new User());
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
<<<<<<< HEAD:src/main/java/com/shop/filters/MainFilter.java
=======
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //TODO logic???
        userService.userAuthentication(new User());
        chain.doFilter(request, response);
    }

    @Override
>>>>>>> 4ba6791d3e25acd975f97cd08ebd30f11e416c9f:src/main/java/com/shop/filters/AuthenticationFilter.java
    public void destroy() {}
}
