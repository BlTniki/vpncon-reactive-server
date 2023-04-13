package com.bitniki.vpnconreactiveserver.entity;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeerEntity {
    private Long id;
    private String peerConfName;
    private String peerIp;
    private String peerPrivateKey;
    private String peerPublicKey;
    private UserEntity user;
    private HostEntity host;
}
