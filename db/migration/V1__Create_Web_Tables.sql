CREATE TABLE web_user
(
    id         SERIAL PRIMARY KEY NOT NULL,
    email      VARCHAR            NOT NULL,
    password   VARCHAR            NOT NULL,
    first_name VARCHAR            NOT NULL,
    last_name  VARCHAR            NOT NULL,
    active     BIT                NOT NULL DEFAULT (1)
);

CREATE TABLE web_role
(
    id   SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR            NOT NULL
);

CREATE TABLE web_user_role
(
    id      SERIAL PRIMARY KEY NOT NULL,
    user_id INT                NOT NULL REFERENCES web_user (id),
    role_id INT                NOT NULL REFERENCES web_role (id)
);