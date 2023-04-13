package com.bitniki.vpnconreactiveserver.service.impl;

import com.bitniki.vpnconreactiveserver.mapper.UserMapper;
import com.bitniki.vpnconreactiveserver.model.User;
import com.bitniki.vpnconreactiveserver.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    /**
     * Retrieves all users from the data source.
     * @return a {@link reactor.core.publisher.Flux} emitting {@link User} objects representing all users
     * @implNote This implementation delegates the call to the {@link UserMapper#selectAll()} method of the
     * underlying data access layer and maps the results to {@link User} objects using the {@link User#toModel}
     * method.
     */
    @Override
    public Flux<User> findAll() {
        return userMapper.selectAll()
                .map(User::toModel);
    }

    /**
     * Retrieves a user from the data source by their ID.
     * @param id the unique identifier of the user to retrieve
     * @return a {@link reactor.core.publisher.Mono} emitting a {@link User} object representing the user with
     * the specified ID
     * @implNote This implementation delegates the call to the {@link UserMapper#selectById(Long)} method of the
     * underlying data access layer and maps the result to a {@link User} object using the {@link User#toModel}
     * method. If no user is found with the specified ID, a new {@link Exception} is thrown.
     * @throws Exception if no user is found with the specified ID or there is an error accessing the underlying
     * data source
     */
    private Mono<User> findById(Long id) throws Exception {
        return userMapper.selectById(id)
                .switchIfEmpty(Mono.error(new Exception()))
                .map(User::toModel);
    }

    /**
     * Should be called after access check. Wrapper for {@link #findById(Long)}.
     * @param id the unique identifier of the user to retrieve
     * @return a {@link reactor.core.publisher.Mono} emitting a {@link User} object representing the user with
     * the specified ID
     * @implNote This implementation delegates the call to the {@link #findById(Long)} method.
     * @throws Exception if no user is found with the specified ID or there is an error accessing the underlying data source
     */
    @Override
    public Mono<User> findUserById(Long id) throws Exception {
        return findById(id);
    }
}
