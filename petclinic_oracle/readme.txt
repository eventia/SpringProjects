로그인 & spring security

1. pom.xml 수정 (spring-security 모듈 추가)
2. web.xml 수정(필터추가 + 외부 security-xml 추가)
3. security-context.xml 추가
4. view/security 폴더 추가 + 로그인 관련 jsp 파일 생성
5. resources/config/login.properties 파일 추가

6. DB TABLE 생성
7. security-xml 수정
8. dataSource 를 security-xml 안으로 옮김 (실행순서)
9. 


# Oracle DB 설정
# Delete Unused Table
DROP  TABLE  vet_specialties; ...

# Show the content of TableA
SELECT * FROM TableA;


# memberuser DB Table SQL Query
DROP TABLE memberuser;

CREATE TABLE memberuser (
  username VARCHAR2(30) NOT NULL PRIMARY KEY,
  password VARCHAR2(30) NOT NULL,
  enabled INT default 1,
  authority VARCHAR2(30) default 'ROLE_USER'
);

insert into memberuser (username, password) values ('aaa', '123');
insert into memberuser (username, password) values ('bbb', '123');
insert into memberuser (username, password, authority) values ('abc', '123', 'ROLE_ADMIN');

commit;



CREATE SEQUENCE petclinic_seq;

CREATE TABLE vets (
 	id NUMBER(4) NOT NULL PRIMARY KEY,
 	first_name VARCHAR2(30),
last_name VARCHAR2(30)
);

CREATE TABLE specialties (
  	id NUMBER(4) NOT NULL PRIMARY KEY,
  	name VARCHAR2(80)
);

CREATE TABLE vet_specialties (
  	vet_id NUMBER(4) NOT NULL,
  	specialty_id NUMBER(4) NOT NULL,
  	CONSTRAINT fk_vetid 
    		FOREIGN KEY (vet_id) REFERENCES vets(id),
CONSTRAINT fk_specialtyid 
    		FOREIGN KEY (specialty_id) REFERENCES specialties(id)
);



INSERT  INTO specialties VALUES (1, 'physician');
INSERT  INTO specialties VALUES (2, 'surgery');
INSERT  INTO specialties VALUES (3, 'dentistry');
INSERT  INTO specialties VALUES (4, 'radiology');

INSERT  INTO vets VALUES (1, 'Hoon', 'Lim');
INSERT  INTO vets VALUES (2, 'James', 'Carter');
INSERT  INTO vets VALUES (3, 'Helen', 'Leary');
INSERT  INTO vets VALUES (4, 'Gildong', 'Hong');
INSERT  INTO vets VALUES (5, 'Uhee', 'Park');
INSERT  INTO vets VALUES (6, 'John', 'Douglas');
INSERT  INTO vets VALUES (7, 'Gana', 'Kim');
INSERT  INTO vets VALUES (8, 'Dorae', 'Lee');
INSERT  INTO vets VALUES (9, 'Jane', 'Dou');

INSERT  INTO vet_specialties VALUES (1, 1);
INSERT  INTO vet_specialties VALUES (2, 2);
INSERT  INTO vet_specialties VALUES (3, 3);
INSERT  INTO vet_specialties VALUES (4, 2);
INSERT  INTO vet_specialties VALUES (5, 1);
INSERT  INTO vet_specialties VALUES (6, 2);
INSERT  INTO vet_specialties VALUES (7, 3);
INSERT  INTO vet_specialties VALUES (8, 4);
INSERT  INTO vet_specialties VALUES (9, 4);
INSERT  INTO vet_specialties VALUES (9, 1);
INSERT  INTO vet_specialties VALUES (9, 2);
INSERT  INTO vet_specialties VALUES (9, 3);

commit;


CREATE TABLE types (
  id NUMBER(4) NOT NULL PRIMARY KEY,
  name VARCHAR2(80)
);

CREATE TABLE owners (
  id NUMBER(4) NOT NULL PRIMARY KEY,
  first_name VARCHAR2(30),
  last_name VARCHAR2(30),
  address VARCHAR2(255),
  city VARCHAR2(80),
  telephone VARCHAR2(20)
);


CREATE TABLE pets (
  id NUMBER(4) NOT NULL PRIMARY KEY,
  name VARCHAR2(30),
  birth_date DATE,
  type_id NUMBER(4) NOT NULL,
  owner_id NUMBER(4) NOT NULL,
  FOREIGN KEY (owner_id) REFERENCES owners(id),
  FOREIGN KEY (type_id) REFERENCES types(id)
);

CREATE TABLE visits (
  id NUMBER(4) NOT NULL PRIMARY KEY,
  pet_id NUMBER(4) NOT NULL,
  visit_date DATE DEFAULT SYSDATE,
  description VARCHAR2(255),
  FOREIGN KEY (pet_id) REFERENCES pets(id)
);

INSERT INTO types VALUES (1, 'cat');
INSERT INTO types VALUES (2, 'dog');
INSERT INTO types VALUES (3, 'lizard');
INSERT INTO types VALUES (4, 'snake');
INSERT INTO types VALUES (5, 'bird');
INSERT INTO types VALUES (6, 'hamster');


INSERT INTO owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023');
INSERT INTO owners VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749');
INSERT INTO owners VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763');
INSERT INTO owners VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198');
INSERT INTO owners VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765');
INSERT INTO owners VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654');
INSERT INTO owners VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387');
INSERT INTO owners VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683');
INSERT INTO owners VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435');
INSERT INTO owners VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487');

INSERT INTO pets VALUES (1, 'Leo', '2000-09-07', 1, 1);
INSERT INTO pets VALUES (2, 'Basil', '2002-08-06', 6, 2);
INSERT INTO pets VALUES (3, 'Rosy', '2001-04-17', 2, 3);
INSERT INTO pets VALUES (4, 'Jewel', '2000-03-07', 2, 3);
INSERT INTO pets VALUES (5, 'Iggy', '2000-11-30', 3, 4);
INSERT INTO pets VALUES (6, 'George', '2000-01-20', 4, 5);
INSERT INTO pets VALUES (7, 'Samantha', '1995-09-04', 1, 6);
INSERT INTO pets VALUES (8, 'Max', '1995-09-04', 1, 6);
INSERT INTO pets VALUES (9, 'Lucky', '1999-08-06', 5, 7);
INSERT INTO pets VALUES (10, 'Mulligan', '1997-02-24', 2, 8);
INSERT INTO pets VALUES (11, 'Freddy', '2000-03-09', 5, 9);
INSERT INTO pets VALUES (12, 'Lucky', '2000-06-24', 2, 10);
INSERT INTO pets VALUES (13, 'Sly', '2002-06-08', 1, 10);

INSERT INTO visits VALUES (1, 7, '2010-03-04', 'rabies shot');
INSERT INTO visits VALUES (2, 8, '2011-03-04', 'rabies shot');
INSERT INTO visits VALUES (3, 8, '2009-06-04', 'neutered');
INSERT INTO visits VALUES (4, 7, '2008-09-04', 'spayed');







