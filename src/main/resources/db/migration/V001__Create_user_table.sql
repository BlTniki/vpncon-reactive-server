CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    login varchar(255) UNIQUE NOT NULL,
    password varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS hosts (
    id BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name varchar(255) UNIQUE NOT NULL,
    ipaddress varchar(255) NOT NULL,
    port INTEGER NOT NULL DEFAULT 80,
    host_password varchar(255) NOT NULL,
    host_public_key varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS peers (
    id BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    peer_conf_name varchar(255) NOT NULL,
    peer_ip varchar(255) NOT NULL,
    peer_private_key varchar(255) NOT NULL,
    peer_public_key varchar(255) NOT NULL,
    user_id BIGINT NOT NULL REFERENCES users(id),
    host_id BIGINT NOT NULL REFERENCES hosts(id)
);