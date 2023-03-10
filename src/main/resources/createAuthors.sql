create table AUTHOR (author_id integer not null, author_name varchar(255),country_id integer, primary key (author_id));
create table COUNTRY (country_id integer not null, country_name varchar(255), primary key (country_id));
create table POST (POST_ID integer not null, POST_name varchar(255), author_id integer, primary key (POST_ID));
CREATE TABLE POST_LIKES (POST_ID INTEGER NOT NULL, AUTHOR_ID INTEGER NOT NULL, PRIMARY KEY (POST_ID, AUTHOR_ID));

ALTER TABLE AUTHOR ADD CONSTRAINT FK_AUTHOR_COUNTRY_ID FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY (COUNTRY_ID);
ALTER TABLE POST ADD CONSTRAINT FK_POST_AUTHOR_ID FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHOR (AUTHOR_ID);
ALTER TABLE POST_LIKES ADD CONSTRAINT FK_POST_LIKES_POST_ID FOREIGN KEY (POST_ID) REFERENCES POST (POST_ID);
ALTER TABLE POST_LIKES ADD CONSTRAINT FK_POST_LIKES_AUTHOR_ID FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHOR (AUTHOR_ID);
