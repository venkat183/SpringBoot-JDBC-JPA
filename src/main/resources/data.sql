/*create table person(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)
);*/

Insert into PERSON
(ID,NAME,LOCATION,BIRTH_DATE)
values(1001,'Venkat','Milwaukee',sysdate());
Insert into PERSON
(ID,NAME,LOCATION,BIRTH_DATE)
values(1002,'Mikyo','Cleveland',sysdate());
Insert into PERSON
(ID,NAME,LOCATION,BIRTH_DATE)
values(1003,'Anthony','London',sysdate());
