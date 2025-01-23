SELECT 'CREATE DATABASE cucumber'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'cucumber');

CREATE ROLE jonathan WITH CREATEDB CREATEROLE LOGIN SUPERUSER PASSWORD 'admin';
GRANT ALL PRIVILEGES on DATABASE cucumber TO jonathan;

CREATE TABLE IF NOT EXISTS cucumbers (
    uid varchar primary key,
    csize int not null,
    sizeCategory varchar not null,
    pimpleCount int not null,
    address  varchar
);

INSERT INTO cucumbers (uid, csize, sizeCategory, pimpleCount, address) VALUES ('daea0d59-308c-47c3-b5c0-3484ef3ee7cf', 4, 'MIDDLE', 62, 'Address 1');
INSERT INTO cucumbers (uid, csize, sizeCategory, pimpleCount, address) VALUES ('9698458a-a184-4716-b2b6-466e7fdb581d', 4, 'SMALL', 72, 'Address 2');

