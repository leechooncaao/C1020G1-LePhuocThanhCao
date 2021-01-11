

CREATE TABLE contacts
( contact_id INT(11) NOT NULL AUTO_INCREMENT,
  last_name VARCHAR(30) NOT NULL,
  first_name VARCHAR(25),
  birthday DATE,
  CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);

ALTER TABLE contacts
ADD full_name VARCHAR(50) NOT NULL
AFTER first_name;

ALTER TABLE contacts
MODIFY last_name VARCHAR(50) NULL;

ALTER TABLE contacts
DROP COLUMN full_name;

ALTER TABLE contacts
CHANGE COLUMN last_name l_name
	VARCHAR(40);
    
ALTER TABLE contacts
RENAME TO contact ;

DROP TABLE contacts;

