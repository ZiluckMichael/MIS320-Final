-- 01
SELECT *
FROM person
         INNER JOIN guest g ON person.person_id = g.person_id;

--02
SELECT *
FROM person
         INNER JOIN employee e ON person.person_id = e.person_id
WHERE e.start_date >= trunc(sysdate, 'mm')
  AND e.start_date < trunc(sysdate, 'mm');

SELECT *
FROM (SELECT pc.*
           , ROW_NUMBER() OVER (PARTITION BY pc.guest_id ORDER BY pc.expiration_month, pc.expiration_year) rnk
      FROM payment_card pc)
WHERE rnk = 1;
--03
SELECT *
FROM (SELECT r.*
           , ROW_NUMBER() OVER (PARTITION BY r.guest_id ORDER BY r.start_date) rnk
      FROM reservation r)
WHERE rnk = 1
  AND guest_id = 1;

--04
SELECT *
FROM (SELECT r.*
           , ROW_NUMBER() OVER (PARTITION BY r.guest_id ORDER BY r.start_date) rnk
      FROM reservation r
               INNER JOIN guest g ON r.guest_id = g.person_id
               INNER JOIN person p ON g.person_id = p.person_id
          AND p.last_name LIKE '%src%')
WHERE rnk = 1;

--05
SELECT *
FROM (SELECT r.*
           , ROW_NUMBER() OVER (PARTITION BY r.guest_id ORDER BY r.start_date) rnk
      FROM reservation r
               INNER JOIN guest g ON r.guest_id = g.person_id
               INNER JOIN person p ON g.person_id = p.person_id
          AND p.phone = '2038854970')
WHERE rnk = 1;

--06
SELECT *
FROM invoice i
         INNER JOIN reservation r ON i.reservation_id = r.reservation_id
         INNER JOIN guest g ON r.guest_id = g.person_id
WHERE i.fully_paid_on IS NULL;

--07
SELECT l.location_id, COUNT(r.room_id) AS total_rooms
FROM location l
         INNER JOIN room r ON l.location_id = r.location_id
GROUP BY l.location_id;

--08
SELECT l.location_id, count(DISTINCT rm.room_id) AS booked_rooms
FROM location l
         INNER JOIN room rm ON l.location_id = rm.location_id
         INNER JOIN room_reservation rr ON rm.room_id = rr.room_id
         INNER JOIN reservation r ON rr.reservation_id = r.reservation_id
WHERE sysdate >= r.start_date
  AND sysdate <= r.end_date
GROUP BY l.location_id;

--09
SELECT l.location_id, count(DISTINCT rm.room_id) AS free_rooms
FROM location l
         INNER JOIN room rm ON l.location_id = rm.location_id
WHERE rm.room_id NOT IN (
    SELECT rm.room_id
    FROM room rm
             INNER JOIN room_reservation rr ON rm.room_id = rr.room_id
             INNER JOIN reservation r ON rr.reservation_id = r.reservation_id
    WHERE sysdate >= r.start_date
      AND sysdate <= r.end_date
);

--10
SELECT ayt.name, ayt.quantity
FROM amenity_type ayt
         INNER JOIN room_amenity ra ON ayt.amenity_type_id = ra.amenity_type_id
         INNER JOIN room rm ON ra.room_id = rm.room_id
WHERE rm.room_number = '0123'
  AND rm.location_id = 1;

--11: 9:33
SELECT rt.name
FROM room rm
         INNER JOIN location l ON rm.location_id = l.location_id
         INNER JOIN room_type rt ON rm.room_type_id = rt.room_type_id
WHERE rm.room_number = '0123'
  AND rm.location_id = 1;

--12: 9:34
SELECT r.*, SUM(s.cost) + (SUM(rt.default_rate) * (r.end_date - r.start_date)) AS invoice_total
FROM reservation r
         LEFT JOIN reservation_service rs
         INNER JOIN service s ON rs.service_id = s.service_id
                    ON r.reservation_id = rs.reservation_id
         LEFT JOIN room_reservation rr
         INNER JOIN room rm ON rr.room_id = rm.room_id
         INNER JOIN room_type rt ON rm.room_type_id = rt.room_type_id
                    ON r.reservation_id = rr.reservation_id
WHERE r.reservation_id = 1
GROUP BY r.reservation_id, r.start_date, r.end_date, r.guest_id;

--13 9:44
SELECT guest_id, SUM(invoice_total)
FROM (SELECT r.*, SUM(s.cost) + (SUM(rt.default_rate) * (r.end_date - r.start_date)) AS invoice_total
      FROM reservation r
               LEFT JOIN reservation_service rs
               INNER JOIN service s ON rs.service_id = s.service_id
                          ON r.reservation_id = rs.reservation_id
               LEFT JOIN room_reservation rr
               INNER JOIN room rm ON rr.room_id = rm.room_id
               INNER JOIN room_type rt ON rm.room_type_id = rt.room_type_id
                          ON r.reservation_id = rr.reservation_id
      GROUP BY r.reservation_id, r.start_date, r.end_date, r.guest_id)
WHERE guest_id = 1
GROUP BY guest_id;

--14 9:48
SELECT guest_id, SUM(invoice_total)
FROM (SELECT r.*, SUM(s.cost) + (SUM(rt.default_rate) * (r.end_date - r.start_date)) AS invoice_total
      FROM reservation r
               LEFT JOIN reservation_service rs
               INNER JOIN service s ON rs.service_id = s.service_id
                          ON r.reservation_id = rs.reservation_id
               LEFT JOIN room_reservation rr
               INNER JOIN room rm ON rr.room_id = rm.room_id
               INNER JOIN room_type rt ON rm.room_type_id = rt.room_type_id
                          ON r.reservation_id = rr.reservation_id
               INNER JOIN guest g ON r.guest_id = g.person_id
               INNER JOIN person p ON g.person_id = p.person_id
          AND p.last_name LIKE '%src%'
      GROUP BY r.reservation_id, r.start_date, r.end_date, r.guest_id)
GROUP BY guest_id;

--15 9:51
SELECT *
FROM guest g
         INNER JOIN person p ON g.person_id = p.person_id
WHERE p.last_name LIKE '%src%';

--16 9:52
UPDATE reservation r
SET r.start_date = TO_DATE('2019-12-04', 'YYYY-MM-DD')
WHERE r.reservation_id = 1;

--17 9:53
UPDATE reservation r
SET r.end_date = to_date('2019-12-11', 'YYYY-MM-DD')
WHERE r.reservation_id = 1;

--18 9:54
UPDATE room_reservation rr
SET rr.room_id = 2
WHERE rr.room_id = 1
  AND rr.reservation_id = 1;

--19 10:03
-- assume r.start/end = A and given = B
SELECT count(DISTINCT g.person_id)
FROM guest g
         INNER JOIN reservation r ON g.person_id = r.guest_id
WHERE r.start_date <= TO_DATE('2019-12-08', 'YYYY-MM-DD')
  AND (
        TO_DATE('2019-12-01', 'YYYY-MM-DD') <= r.end_date
        OR r.end_date IS NULL
    );

--20 10:18
SELECT p.person_id
     , p.first_name
     , p.last_name
     , p.birth_date
     , p.phone
     , p.phone_ext
     , e.ssn
     , e.start_date
     , e.termination_date
     , e.employee_type_id
     , e.location_id
     , e.manager_id
FROM person p
         INNER JOIN employee e ON p.person_id = e.person_id
         INNER JOIN employee_type et ON e.employee_type_id = et.employee_type_id
WHERE (LOWER(et.title) LIKE '%manager%'
    OR LOWER(et.title) LIKE '%supervisor%')
  AND e.location_id = 1;

--21 10:24
SELECT p.person_id
     , p.first_name
     , p.last_name
     , p.birth_date
     , p.phone
     , p.phone_ext
     , e.ssn
     , e.start_date
     , e.termination_date
     , e.employee_type_id
     , e.location_id
     , e.manager_id
FROM person p
         INNER JOIN employee e ON p.person_id = e.person_id
         INNER JOIN employee_type et ON e.employee_type_id = et.employee_type_id
WHERE (LOWER(et.title) NOT LIKE '%manager%'
    AND LOWER(et.title) NOT LIKE '%supervisor%')
  AND e.location_id = 1;

--22 10:29
SELECT s.service_id, s.name, s.description, s.cost, count(rs.reservation_id) quantity
FROM reservation r
         INNER JOIN reservation_service rs ON r.reservation_id = rs.reservation_id
         INNER JOIN service s ON rs.service_id = s.service_id
WHERE r.reservation_id = 1
GROUP BY s.service_id, s.name, s.description, s.cost;

-- Add a new guest to the database
INSERT INTO person (first_name, last_name, birth_date, phone, phone_ext)
VALUES ('Michael', 'Ziluck', TO_DATE('2019-12-01', 'YYYY-MM-DD'), '2038854970', NULL);

------------------------------------------------------------------------------------------
INSERT INTO reservation (start_date, end_date, guest_id)
VALUES (TO_DATE('2019-12-01', 'YYYY-MM-DD'), TO_DATE('2019-12-08', 'YYYY-MM-DD'), 1);

INSERT INTO service (name, description, cost)
VALUES ('Breakfast Buffet', 'Unlimited access to the breakfast buffet for one morning', 8);

INSERT INTO invoice (created_on, due_on, fully_paid_on, reservation_id, invoice_status_id)
VALUES ();