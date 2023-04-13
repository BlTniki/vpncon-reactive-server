package com.bitniki.vpnconreactiveserver.service;

import com.bitniki.vpnconreactiveserver.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<User> findAll();
    Mono<User> findUserById(Long id) throws Exception;
}
