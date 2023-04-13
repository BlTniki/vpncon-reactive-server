package com.bitniki.vpnconreactiveserver.model;

import com.bitniki.vpnconreactiveserver.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String login;

    public static User toModel(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getLogin()
        );
    }
}
