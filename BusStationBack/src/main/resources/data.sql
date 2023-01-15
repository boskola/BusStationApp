INSERT INTO operator (id, name, adress, vat) VALUES (1, 'King Long', 'Aero China 32', '11111');
INSERT INTO operator (id, name, adress, vat) VALUES (2, 'Golden Dragon', 'Water China 142a', '22222');
INSERT INTO operator (id, name, adress, vat) VALUES (3, 'Marcopolo S.A.', 'Fire Brasil 5', '33333');
INSERT INTO operator (id, name, adress, vat) VALUES (4, 'Zhongtong', 'Soil China 3322', '44444');
INSERT INTO operator (id, name, adress, vat) VALUES (5, 'MAN', 'Real Gremany 14b', '55555');
INSERT INTO operator (id, name, adress, vat) VALUES (6, 'Higer Bus', 'Again China 522c', '66666');
INSERT INTO operator (id, name, adress, vat) VALUES (7, 'Volvo Buses', 'Goldy Sweden 32', '77777');
INSERT INTO operator (id, name, adress, vat) VALUES (8, 'Scania', 'Cape Town, South Africa 14/2a', '88888');
INSERT INTO operator (id, name, adress, vat) VALUES (9, 'Golden Arrow Bus Services', 'Cape Town, South Africa 14/25c', '99999');
INSERT INTO operator (id, name, adress, vat) VALUES (10, 'Greyhound Canada', 'Cold Canada 18F', '10101');
INSERT INTO operator (id, name, adress, vat) VALUES (11, 'Burlington Transit', 'Easy Ontario 1423', '20202');
INSERT INTO operator (id, name, adress, vat) VALUES (12, 'Bustang', 'U.S. Colorado, Springs 511a', '30303');


INSERT INTO line (id, seats_number, ticket_price, departure_time, destination, operator_id) VALUES (1, 100, 48.0, '21:00', 'Shijiazhuang', 1);
INSERT INTO line (id, seats_number, ticket_price, departure_time, destination, operator_id) VALUES (2, 150, 40.0, '22:10', 'Xian', 2);
INSERT INTO line (id, seats_number, ticket_price, departure_time, destination, operator_id) VALUES (3, 80, 120.0, '23:15', 'Brasilia', 3);
INSERT INTO line (id, seats_number, ticket_price, departure_time, destination, operator_id) VALUES (4, 200, 51.0, '07:30', 'Dongguan', 4);
INSERT INTO line (id, seats_number, ticket_price, departure_time, destination, operator_id) VALUES (5, 100, 68.0, '21:00', 'Berlin', 5);
INSERT INTO line (id, seats_number, ticket_price, departure_time, destination, operator_id) VALUES (6, 150, 20.0, '22:10', 'Ronneby', 6);
INSERT INTO line (id, seats_number, ticket_price, departure_time, destination, operator_id) VALUES (7, 80, 220.0, '23:15', 'Cape Town', 7);
INSERT INTO line (id, seats_number, ticket_price, departure_time, destination, operator_id) VALUES (8, 200, 41.0, '07:30', 'Cape Town', 8);
INSERT INTO line (id, seats_number, ticket_price, departure_time, destination, operator_id) VALUES (9, 100, 38.0, '21:00', 'Toronto', 9);
INSERT INTO line (id, seats_number, ticket_price, departure_time, destination, operator_id) VALUES (10, 150, 20.0, '22:10', 'Ottawa', 10);
INSERT INTO line (id, seats_number, ticket_price, departure_time, destination, operator_id) VALUES (11, 80, 120.0, '23:15', 'Regina', 11);
INSERT INTO line (id, seats_number, ticket_price, departure_time, destination, operator_id) VALUES (12, 200, 74.0, '07:30', 'Miami', 12);

INSERT INTO user (id, e_mail, user_name, password, name, last_name, role)
              VALUES (1,'bosko@mail.bb','bosko','$2a$12$oCozgT6psOyZKniV1300OuHC6RanY0Div9..BAfYSxn/jHP810gRG','Bosko','Lazic','ADMIN');
INSERT INTO user (id, e_mail, user_name, password, name, last_name, role)
              VALUES (2,'olja@mail.bb','olja','$2a$12$WdPqqg8RuCYnuPMjhrqH5emo/JrqfUAqq.hxtF80hhDjCW2JsvHfm','Olivera','Lazic','ADMIN');
INSERT INTO user (id, e_mail, user_name, password, name, last_name, role)
              VALUES (4,'petar@mail.pp','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Petrovic','USER');
INSERT INTO user (id, e_mail, user_name, password, name, last_name, role)
              VALUES (5,'ivana@mail.ii','ivana','$2a$12$8v/VETEG4LhCYNiiE/YGMeJxChjHbzvZ1eZZbv3kH9yzoQHuynShG','Ivana','Ivanovic','USER');