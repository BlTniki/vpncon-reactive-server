package com.bitniki.vpnconreactiveserver.controller;

import com.bitniki.vpnconreactiveserver.model.User;
import com.bitniki.vpnconreactiveserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Flux<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<User> findById(@PathVariable Long id) {
        return userService.findUserById(id);
    }
}
