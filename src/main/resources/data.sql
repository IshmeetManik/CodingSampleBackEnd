DROP TABLE IF EXISTS patients cascade;
DROP TABLE IF EXISTS address cascade;
CREATE TABLE patients (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  phone_number VARCHAR(250) DEFAULT NULL
);

CREATE TABLE address (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  patient_id INT,
  line1 VARCHAR(250) NOT NULL,
  line2 VARCHAR(250) NOT NULL,
   city VARCHAR(250) DEFAULT NULL,
  country VARCHAR(250) DEFAULT NULL,
  postal_code VARCHAR(250) DEFAULT NULL,
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`)
);


INSERT INTO patients (first_name, last_name, phone_number) VALUES
  ('Aliko', 'Dangote', '999999799'),
  ('Bill', 'Gates', '99999979956'),
  ('Folrunsho', 'Alakija', '99999876799');


  INSERT INTO address (patient_id, line1, line2,city,country,postal_code) VALUES
  (1,'c-1213','Gurgaon','Haryana','India','1210101'),
  (1,'c-3635','Faridabad','Haryana','India','00977'),
    (2,'c-1213','NEw Delhi Area ','Delhi','India','1110098'),
     (3,'c-1213','Gurgaon','Haryana','India','1210101');