package com.bitniki.vpnconreactiveserver.mapper;

import com.bitniki.vpnconreactiveserver.entity.UserEntity;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Mapper
public interface UserMapper {
    Flux<UserEntity> selectAll();
    Mono<UserEntity> selectById(@Param("id") Long id);
    Mono<UserEntity> insert(UserEntity entity);
}
