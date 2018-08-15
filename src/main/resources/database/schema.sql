DROP TABLE IF EXISTS certificates;
DROP TABLE if EXISTS positions;
DROP TABLE IF EXISTS history;
DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS employees;

CREATE TABLE IF NOT EXISTS certificates (
  id       INTEGER PRIMARY KEY AUTOINCREMENT,
  employee_id INTEGER  REFERENCES employees (id),
  name     VARCHAR(255) NOT NULL,
  date     DATE         NOT NULL,
  company  VARCHAR(255) NOT NULL,
  number   INTEGER      NOT NULL    UNIQUE,
  scan     BLOB         NOT NULL
);

CREATE TABLE IF NOT EXISTS positions (
  id   INTEGER      NOT NULL    PRIMARY KEY,
  name VARCHAR(255) NOT NULL    UNIQUE
);

CREATE TABLE IF NOT EXISTS history(
  id INTEGER NOT NULL    PRIMARY KEY  AUTOINCREMENT,
  employee_id INTEGER NOT NULL REFERENCES employees(id),
  event_date   DATE         NOT NULL,
  end_date Date NOT NULL ,
  event       VARCHAR(255) NOT NULL
--   FOREIGN KEY (employee_id) REFERENCES employees(id)
);


CREATE TABLE IF NOT EXISTS departments (
  id INTEGER PRIMARY KEY AUTOINCREMENT ,/*AUTOINCREMENT */
  version INTEGER NOT NULL,
  full_name VARCHAR(255) NOT NULL ,
  manager_id INTEGER ,
  parent_id INTEGER REFERENCES departments(id)
--   FOREIGN KEY(parent_id) REFERENCES departments(id)
);


CREATE TABLE IF NOT EXISTS employees (
  id INTEGER PRIMARY KEY AUTOINCREMENT ,/*AUTOINCREMENT */
  version INTEGER NOT NULL,
  first_name VARCHAR(50) NOT NULL ,
  last_name VARCHAR(50) NOT NULL,
  middle_name VARCHAR(50),
  gender integer NOT NULL ,
  birth_date DATE NOT NULL,
  department_id INTEGER NOT NULL REFERENCES departments(id),
  position_id INTEGER NOT NULL REFERENCES positions(id),
  grade INTEGER NOT NULL,
  salary DECIMAL  NOT NULL
--   FOREIGN KEY(department_id) REFERENCES departments(id),
--   FOREIGN KEY(position_id) REFERENCES positions(id)
);


INSERT INTO positions(id, name) VALUES (1,'Director');
INSERT INTO positions(id, name) VALUES (2,'Analyzer');
INSERT INTO positions(id, name) VALUES (3,'Developer');
INSERT INTO positions(id, name) VALUES (4,'Recruiter');
INSERT INTO positions(id, name) VALUES (5,'Guard');


INSERT INTO departments(id,full_name,manager_id,parent_id) VALUES (
    null,'Head',1,null
);
INSERT INTO departments(id,full_name,manager_id,parent_id) VALUES (
  null,'Developing',1,1
);
INSERT INTO departments(id,full_name,manager_id,parent_id) VALUES (
  null,'HR',1,1
);
INSERT INTO departments(id,full_name,manager_id,parent_id) VALUES (
  null,'Analytics',1,1
);


INSERT INTO employees(id,first_name,last_name,middle_name,gender
  ,birth_date,department_id,position_id,grade,salary) VALUES (
    NULL ,'Alex','Pushkin',NULL ,1,'07-03-1745',1,1,10,10000);
INSERT INTO employees(id,first_name,last_name,middle_name,gender
  ,birth_date,department_id,position_id,grade,salary) VALUES (
    NULL ,'Sergei','Esenin',NULL ,1,'29-08-1857',1,1,8,14000);