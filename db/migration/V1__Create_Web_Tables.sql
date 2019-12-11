CREATE TABLE web_user
(
    id         INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    email      VARCHAR2(64)                  NOT NULL,
    password   VARCHAR2(64)                  NOT NULL,
    first_name VARCHAR2(32)                  NOT NULL,
    last_name  VARCHAR2(32)                  NOT NULL,
    active     NUMBER(1, 0) DEFAULT (1) NOT NULL
);

CREATE TABLE web_role
(
    id   INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    name VARCHAR2(64) NOT NULL
);

CREATE TABLE web_user_role
(
    id      INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES web_user (id),
    role_id INTEGER NOT NULL REFERENCES web_role (id)
);
