package com.bitniki.vpnconreactiveserver.entity;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    private Long id;
    private String login;
    private String password;
}
