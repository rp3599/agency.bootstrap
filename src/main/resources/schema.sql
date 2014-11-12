CREATE SCHEMA IF NOT EXISTS AGENCY;

CREATE TABLE agency_data
(
	id BIGINT NOT NULL auto_increment,
	company_name VARCHAR(50) NOT NULL,
	created timestamp default current_timestamp,
	modified timestamp default current_timestamp,
	PRIMARY KEY (id)
);

INSERT INTO agency_data (company_name) values ('rp3599');
INSERT INTO agency_data (company_name) values ('rakesh');
INSERT INTO agency_data (company_name) values ('test');
