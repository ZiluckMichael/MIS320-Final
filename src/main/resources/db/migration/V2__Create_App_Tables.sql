CREATE TABLE person
(
    person_id  INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    first_name VARCHAR2(16) NOT NULL,
    last_name  VARCHAR2(16) NOT NULL,
    birth_date DATE         NOT NULL,
    phone      CHAR(10)     NOT NULL,
    phone_ext  VARCHAR2(6)  NULL
);

CREATE TABLE guest
(
    person_id      INTEGER PRIMARY KEY REFERENCES person (person_id),
    rewards_number CHAR(12)           NOT NULL,
    rewards_points NUMBER DEFAULT (0) NOT NULL
);

CREATE TABLE payment_card
(
    payment_card_id  INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    card_number      VARCHAR2(19) NOT NULL,
    expiration_month NUMBER(2)    NOT NULL,
    expiration_year  NUMBER(4)    NOT NULL,
    security_value   NUMBER(4)    NULL,
    guest_id         INTEGER      NOT NULL REFERENCES guest (person_id)
);

CREATE TABLE location
(
    location_id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    street      VARCHAR2(128) NOT NULL,
    city        VARCHAR2(48)  NOT NULL,
    state       CHAR(2)       NOT NULL,
    zip_code    CHAR(5)       NOT NULL,
    phone       CHAR(10)      NULL,
    phone_ext   VARCHAR2(6)   NULL,
    square_feet NUMBER        NOT NULL,
    room_count  INTEGER        NOT NULL
);

CREATE TABLE employee_type
(
    employee_type_id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    title            VARCHAR2(64) NOT NULL,
    classification   CHAR(1)      NOT NULL
);

CREATE TABLE employee
(
    person_id        INTEGER PRIMARY KEY REFERENCES person (person_id),
    ssn              CHAR(9) NULL,
    start_date       DATE    NULL,
    termination_date DATE    NULL,
    employee_type_id INTEGER NOT NULL REFERENCES employee_type (employee_type_id),
    location_id      INTEGER NULL REFERENCES location (location_id),
    manager_id       INTEGER NULL REFERENCES employee (person_id)
);

CREATE TABLE room_type
(
    room_type_id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    name         VARCHAR2(24)  NOT NULL,
    description  VARCHAR2(156) NULL,
    default_rate NUMBER(*, 2)  NOT NULL
);

CREATE TABLE bed_type
(
    bed_type_id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    name        VARCHAR2(12) NOT NULL
);

CREATE TABLE room_type_bed
(
    room_bed_id  INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    room_type_id INTEGER NOT NULL REFERENCES room_type (room_type_id),
    bed_type_id  INTEGER NOT NULL REFERENCES bed_type (bed_type_id)
);

CREATE TABLE amenity_type
(
    amenity_type_id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    name            VARCHAR2(24)       NOT NULL,
    description     VARCHAR2(156)      NULL,
    quantity        NUMBER DEFAULT (1) NOT NULL
);

CREATE TABLE room
(
    room_id      INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    room_number  CHAR(4)      NOT NULL,
    square_feet  NUMBER(*, 1) NOT NULL,
    room_type_id INTEGER      NOT NULL REFERENCES room_type (room_type_id),
    location_id  INTEGER      NOT NULL REFERENCES location (location_id)
);

CREATE TABLE room_amenity
(
    room_amenity_id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    room_id         INTEGER NOT NULL REFERENCES room (room_id),
    amenity_type_id INTEGER NOT NULL REFERENCES amenity_type (amenity_type_id)
);

CREATE TABLE reservation
(
    reservation_id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    start_date     DATE    NOT NULL,
    end_date       DATE    NULL,
    guest_id       INTEGER NOT NULL REFERENCES guest (person_id)
);

CREATE TABLE room_reservation
(
    room_reservation_id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    room_id             INTEGER NOT NULL REFERENCES room (room_id),
    reservation_id      INTEGER NOT NULL REFERENCES reservation (reservation_id)
);

CREATE TABLE service
(
    service_id  INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    name        VARCHAR(24)  NOT NULL,
    description VARCHAR(156) NULL,
    cost        NUMBER       NOT NULL
);

CREATE TABLE reservation_service
(
    reservation_service_id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    reservation_id         INTEGER NOT NULL REFERENCES reservation (reservation_id),
    service_id             INTEGER NOT NULL REFERENCES service (service_id)
);

CREATE TABLE invoice_status
(
    invoice_status_id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    name              VARCHAR2(24) NOT NULL
);

CREATE TABLE invoice
(
    invoice_id        INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    created_on        DATE DEFAULT (sysdate) NOT NULL,
    due_on            DATE                   NOT NULL,
    fully_paid_on     DATE                   NULL,
    reservation_id    INTEGER                NOT NULL REFERENCES reservation (reservation_id),
    invoice_status_id INTEGER                NOT NULL REFERENCES invoice_status (invoice_status_id),
    notes             VARCHAR2(156)          NULL
);

CREATE TABLE invoice_payment
(
    invoice_payment_id INTEGER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    payment_date       DATE         NOT NULL,
    payment_amount     NUMBER(*, 2) NOT NULL,
    invoice_id         INTEGER      NOT NULL REFERENCES invoice (invoice_id),
    payment_card_id    INTEGER      NOT NULL REFERENCES payment_card (payment_card_id)
);