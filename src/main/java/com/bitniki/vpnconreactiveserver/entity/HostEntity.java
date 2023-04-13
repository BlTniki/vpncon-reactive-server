package com.bitniki.vpnconreactiveserver.entity;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HostEntity {
    private Long id;
    private String name;
    private String ipaddress;
    private Integer port;
    private String hostPassword;
    private String hostPublicKey;
}
