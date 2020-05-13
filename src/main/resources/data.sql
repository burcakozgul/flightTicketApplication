INSERT INTO AIRPORT (id, name, address, telephone_number, number_of_flight_destinations, annual_passenger_capacity) VALUES (1,'IGA','Yeşilköy Mahallesi, Havaalanı Cad. No:3/1 34149 Bakırköy, İstanbul/Türkiye','+902126014100',300,200000);
INSERT INTO AIRPORT (id, name, address, telephone_number,number_of_flight_destinations, annual_passenger_capacity) VALUES (2,'Sabiha Gokcen','Kurtköy, Osmanlı Blv. Aeropark 11/A, 34912 Pendik/İstanbul','+902165888888',120,41000);

INSERT INTO AIRLINE (id, name, address, telephone_number, number_of_aircraft) VALUES (1,'Turkish Airlines','İstanbul','+902124440849',215);
INSERT INTO AIRLINE (id, name, address, telephone_number, number_of_aircraft) VALUES (2,'Pegasus','İstanbul','+908502506777',130);

INSERT INTO FLIGHT (id, flight_code, route_code, available_seat, total_seat) VALUES (1, 'TK1001', 'ROTA100', 10, 10);
INSERT INTO FLIGHT (id, flight_code, route_code, available_seat, total_seat) VALUES (2, 'TK1002', 'ROTA102', 160, 200);


INSERT INTO ROUTE (id, date, departure, destination, distance, route_code) VALUES (1, '2020-04-28 14:03:01.146' , 'IGA', 'New York JFK' ,1200, 'ROTA100');
INSERT INTO ROUTE (id, date, departure, destination, distance, route_code) VALUES (2, '2020-04-28 14:03:01.146' , 'IGA', 'Paris Airport' ,1200, 'ROTA102');