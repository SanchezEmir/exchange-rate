

INSERT INTO Role (id_role, name, description) VALUES (1, 'ADMIN', 'Administrador');
INSERT INTO Role (id_role, name, description) VALUES (2, 'USER', 'Usuario');
INSERT INTO Role (id_role, name, description) VALUES (3, 'DBA', 'Admin de bd');

INSERT INTO user_data(id_user, username, password, enabled) values (1, 'demo1@gmail.com', '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', '1');
INSERT INTO user_data(id_user, username, password, enabled) values (2, 'demo2@gmail.com', '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', '1');

INSERT INTO user_role (id_user, id_role) VALUES (1, 1);
INSERT INTO user_role (id_user, id_role) VALUES (1, 3);
INSERT INTO user_role (id_user, id_role) VALUES (2, 2);

INSERT INTO exchanges (base_currency, final_currency, exchange_type) VALUES ('PEN', 'USD', 0.2594);
INSERT INTO exchanges (base_currency, final_currency, exchange_type) VALUES ('PEN', 'EUR', 0.2357);
INSERT INTO exchanges (base_currency, final_currency, exchange_type) VALUES ('USD', 'PEN', 3.8548);
INSERT INTO exchanges (base_currency, final_currency, exchange_type) VALUES ('EUR', 'PEN', 4.2441);
INSERT INTO exchanges (base_currency, final_currency, exchange_type) VALUES ('EUR', 'USD', 1.1009);
INSERT INTO exchanges (base_currency, final_currency, exchange_type) VALUES ('USD', 'EUR', 0.9102);