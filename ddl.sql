CREATE SEQUENCE zoo.animal_id_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;

CREATE SEQUENCE zoo.profile_id_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;

CREATE SEQUENCE zoo.location_id_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;

CREATE SEQUENCE zoo.zoo_area_id_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;

CREATE SEQUENCE zoo.activity_id_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;

CREATE SEQUENCE zoo.staff_id_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;

CREATE SEQUENCE zoo.activity_id_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;

CREATE TABLE zoo.activity (
	id int4 NOT NULL DEFAULT nextval('zoo.activity_id_seq'::regclass),
	worker_id int NOT NULL references zoo.staff(id),
	location_id int NOT NULL references zoo.location(id),
	action varchar(128),
	time timestamp,
	CONSTRAINT staff_pkey PRIMARY KEY (worker_id,location_id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE zoo.staff (
	id int4 NOT NULL DEFAULT nextval('zoo.staff_id_seq'::regclass),
	firstname varchar(32) NOT NULL,
	lastname varchar(32) NOT NULL,
	age int,
	proficiency int,
	specialization varchar(32),
	CONSTRAINT staff_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE zoo.area (
	id int4 NOT NULL DEFAULT nextval('zoo.zoo_area_id_seq'::regclass),
	name varchar(32),
	size int,
	location_id int references zoo.location(id),
	CONSTRAINT zoo_area_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE zoo.profile (
	id int4 NOT NULL DEFAULT nextval('zoo.profile_id_seq'::regclass),
	nutrition varchar(32),
	wayOfLife varchar(64),
	CONSTRAINT profile_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE zoo.animal (
	id int4 NOT NULL DEFAULT nextval('zoo.animal_id_seq'::regclass),
	profile_id int NOT NULL references profile(id),
	species varchar(32) NOT NULL,
	name varchar(32),
	age int NOT NULL,
	origin varchar(32),
	health varchar(64) NOT NULL,
	CONSTRAINT animal_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;

CREATE TABLE zoo.location (
	id int4 NOT NULL DEFAULT nextval('zoo.location_id_seq'::regclass),
	type varchar(32),
	size int,
	animal_id int references zoo.animal(id),
	CONSTRAINT location_pkey PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;